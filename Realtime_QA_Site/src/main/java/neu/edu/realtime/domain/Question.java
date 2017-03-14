package neu.edu.realtime.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="QUESTION")
public class Question implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String question;
	
/*	private String userinfo;
	
	public void setUserinfo(String userinfo){
		this.userinfo=userinfo;
	}
	
	public String getUserinfo(){
		return userinfo;
	}
	*/
	public void setQuestion(String question){
		this.question=question;
	}											
	
	public String getQuestion(){
		return question;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="user_id", referencedColumnName="id" )
	private User user;
	
	@OneToMany(mappedBy="question", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Answer> answers = new HashSet<Answer>();
	
	public void setAnswers(Set answers){
		this.answers=answers;
	}
	
	public Set getAnswers(){
		return answers;
	}
	
	public void setUser(User user){
		this.user=user;
	}
	
	public User getUser(){
		return user;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
}
