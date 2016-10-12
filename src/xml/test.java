package xml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import xml.User;
import xml.XmlUtil;

public class test {
	public static void main(String[] args) {
//		Users users=new Users();
//		User user1 =new User();
//		User user2 =new User();
//		Question ques1 = new Question();
//		
//		user1.setScore(0);
//		user1.setName("user1");
//		user2.setScore(0);
//		user2.setName("user2");
//		List<User> list = new ArrayList<>();
//		List<Question> list2 = new ArrayList<>();
//		list.add(user1);
//		list.add(user2);
//		list2.add(ques1);
//		users.setUsers(list);
//		
//		ques1.setAuthor(user1.getName());
//		ques1.setId(1);
//		ques1.setIsSolve(IsSolved.UNSOLVED);
//		ques1.setQues("njrjgnrgnj");
//		list2.add(ques1);
//		users.setQuestions(list2);
//		XmlUtil.toXML(users);
		try {
			BufferedReader reader = new BufferedReader(new FileReader("user1.xml"));
			StringWriter writer = new StringWriter();
			String line = reader.readLine();
			while(line!=null){
				writer.append(line);
				line = reader.readLine();
			}
//			System.out.println(writer.toString());
			reader.close();
			
			Users player = (Users)XmlUtil.fromXML(writer.toString(), Users.class);
			List<Question> question = player.getQuestions();
			List<User> users = player.getUsers();
			List<Answer> answers = player.getAnswers();
			for(Question q:question){
				System.out.println(q.toString());
			}
			User currentUser = null;
			System.out.print("�������û�����");
			Scanner sc= new Scanner(System.in);
			String name = sc.nextLine();
			for(User u:users){
				if(name.equals(u.getName())){
					currentUser = u;
					System.out.println("��ӭ"+currentUser.getName()+"�û��������ǵ���Ϸ��");
				}
			}
			if(currentUser==null){
				
				User newUser = new User();
				newUser.setName(name);
				newUser.setScore(0);
				users.add(newUser);
				player.setUsers(users);
				currentUser = newUser;
				XmlUtil.toXML(player);
				System.out.println("���û��Դ���������");
				System.out.println("��ӭ"+currentUser.getName()+"�û��������ǵ���Ϸ��");
			}

			String input=sc.nextLine();
			while(!"exit".equals(input)){
				if("list".equals(input)){
					if(question.size()==0){
						System.out.println("û��������");
					}else{
						for(Question q :question){
							System.out.println(q.toString());
						}
					}
				}else if("score".equals(input)){
					System.out.println("��ĵ÷��ǣ�"+currentUser.getScore());
				}else if("ask".equals(input)){
					System.out.print("������������⣺ ");
					String ques1;
					ques1 = sc.nextLine();
					Question q1 = new Question();
					q1.setIsSolve(IsSolved.UNSOLVED);
					q1.setAuthor(currentUser.getName());
					q1.setId(question.size()+1);
					q1.setQues(ques1);
					question.add(q1);
					player.setQuestions(question);
					System.out.println("��������ѱ�����");
					XmlUtil.toXML(player);
				}else if("answer".equals(input)){
					System.out.print("������ش������ID�� ");
					String quesId = sc.nextLine();
					for(Question q :question){
						try {
							long question_id = Integer.parseInt(quesId);							
						
							if(q.getId()==Integer.parseInt(quesId)){
								if(q.getIsSolve().equals(IsSolved.UNSOLVED)){
									System.out.print("��������Ļش� ");
									String quesAnswer = sc.nextLine();
									Answer newAnswer = new Answer();
									newAnswer.setAnswer(quesAnswer);
									q.setAuthor(currentUser.getName());
									newAnswer.setAuthor(currentUser.getName());
									newAnswer.setQues_id(q.getId());
									q.setIsSolve(IsSolved.SOLVED);
									currentUser.setScore(currentUser.getScore()+10);
									System.out.println("лл���ύ�Ĵ�");
									answers.add(newAnswer);
									player.setAnswers(answers);
									XmlUtil.toXML(player);
								}else{
									System.out.println("�������Ѿ������");
									for(Answer a:answers){
										if(a.getQues_id()==q.getId()){
											System.out.println(a.toString());
										}
									}
								}
							}
						} catch (Exception e) {
							System.out.println("�����ʽ����");
						}
							
						
					}
				}else if("help".equals(input)){
					System.out.println("============������Ϣ==============");
					System.out.println(" exit  : �˳�");
					System.out.println(" help  : �г�������Ϣ");
					System.out.println(" list  : �г������б�");
					System.out.println(" ask   : ������");
					System.out.println("answer : �ش�����");
				}
				System.out.print("�����룺");
				input=sc.nextLine();
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
