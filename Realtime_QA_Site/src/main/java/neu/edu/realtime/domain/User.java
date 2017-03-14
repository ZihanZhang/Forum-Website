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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User implements Serializable{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	private int exp;
	
	private int enabled;
	
	private int level;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Set<Question> questions = new HashSet<Question>();
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Set<Role> roles = new HashSet<Role>();
	
	public void setExp(int exp){
		this.exp=exp;
	}
	
	public int getExp(){
		return exp;
	}
	
	public void setEnabled(int enabled){
		this.enabled=enabled;
	}
	
	public int getEnabled(){
		return enabled;
	}
	
	public void setRoles(Set roles){
		this.roles=roles;
	}
	
	public Set getRoles(){
		return roles;
	}

	
	public void setQuestions(Set questions){
		this.questions=questions;
	}
	
	public Set getQuestions(){
		return questions;
	}
	

/*		
	private ArrayList<Question> questions = new ArrayList<Question>();

	private ArrayList<Answer> answers = new ArrayList<Answer>();
	
	
	public void setQuestions(ArrayList<Question> questions){
		this.questions=questions;
	}
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	
	public void setAnswers(ArrayList<Answer> answers){
		this.answers=answers;
	}
	
	public ArrayList<Answer> getAnswers(){
		return answers;
	}
	*/
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public void setLevel(int level){
		this.level=level;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}

}
