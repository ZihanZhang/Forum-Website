package neu.edu.realtime.service;

import java.util.Collection;

import neu.edu.realtime.domain.Answer;

public interface AnswerService {
	public void addAnswer(Answer answer);
	public void delAnswer(Answer answer);
	public void updateAnswer(Answer answer);
	public Collection<Answer> listAnswer();
}
