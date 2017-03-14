package neu.edu.realtime.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER")
public class Answer {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String answer;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="question", referencedColumnName="id" )
	private Question question;
	
	public Question getQuestion(){
		return question;
	}
	
	public void setQuestion(Question question){
		this.question=question;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	public void setAnswer(String answer){
		this.answer=answer;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
}
