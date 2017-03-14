package neu.edu.realtime.dao;

import java.util.Collection;

import neu.edu.realtime.domain.Answer;
import neu.edu.realtime.domain.Question;

public interface AnswerDAO {
	public void addAnswer(Answer answer);
	public void delAnswer(Answer answer);
	public void updateAnswer(Answer answer);
	public Collection<Answer> listAnswer();
}
