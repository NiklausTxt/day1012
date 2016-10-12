package xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
	@XmlElementWrapper(name="users")  
	@XmlElement(name = "user")
	private List<User> users;
	
	@XmlElementWrapper(name="questions")  
	@XmlElement(name = "question")
	private List<Question> questions;
	
	@XmlElementWrapper(name="answers")  
	@XmlElement(name = "answer")
	private List<Answer> answers;
	
	public Users() {
		users=new ArrayList<>();
		questions = new ArrayList<>();
		answers = new ArrayList<>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
}

@XmlAccessorType(XmlAccessType.FIELD)
class User{
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "score")
	private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}

@XmlAccessorType(XmlAccessType.FIELD)
class Question {
	@XmlAttribute(name = "isSlove")
	private IsSolved isSolve;
	@XmlAttribute(name = "id")
	private long id;
	@XmlAttribute(name = "author")
	private String author;
	@XmlValue
	private String ques;
	
	public Question() {
	}
	public IsSolved getIsSolve() {
		return isSolve;
	}
	public void setIsSolve(IsSolved isSolve) {
		this.isSolve = isSolve;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "["+isSolve+"] "+id+": ["+ques+"] "+"from "+author;
	}
	
}

@XmlAccessorType(XmlAccessType.FIELD)
class Answer{
	@XmlAttribute(name = "ques_id")
	private long ques_id;
	@XmlAttribute(name = "author")
	private String author;
	@XmlValue
	private String answer;
	
	
	public long getQues_id() {
		return ques_id;
	}
	public void setQues_id(long ques_id) {
		this.ques_id = ques_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return ques_id+" : "+"[ 答案："+answer+" ,来自于"+author+"的回答 ]";
	}
	
}