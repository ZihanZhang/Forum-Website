package neu.edu.realtime.service;

import java.util.Collection;

import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.User;

public interface QuestionService {
	public void addQuestion(Question question);
	public void delQuestion(Question question);
	public void updateQuestion(Question question);
	public Question query(int id);
	public Collection<Question> listQuestion();
}
