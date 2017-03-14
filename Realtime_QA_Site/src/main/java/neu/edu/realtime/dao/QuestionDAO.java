package neu.edu.realtime.dao;

import java.util.Collection;

import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.User;

public interface QuestionDAO {
	public void addQuestion(Question question);
	public void delQuestion(Question question);
	public void updateQuestion(Question question);
	public Question query(int id);
	public Collection<Question> listQuestion();
}
