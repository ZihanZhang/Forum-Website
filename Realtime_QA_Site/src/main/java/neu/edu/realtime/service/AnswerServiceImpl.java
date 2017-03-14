package neu.edu.realtime.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import neu.edu.realtime.dao.AnswerDAO;
import neu.edu.realtime.dao.QuestionDAO;
import neu.edu.realtime.domain.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	@Qualifier("answerDAOHibernateImpl")
	private AnswerDAO answerDAO;

	@Override
	public void addAnswer(Answer answer) {
		answerDAO.addAnswer(answer);
	}

	@Override
	public void delAnswer(Answer answer) {
		answerDAO.delAnswer(answer);
	}

	@Override
	public Collection<Answer> listAnswer() {
		return answerDAO.listAnswer();
	}

	@Override
	public void updateAnswer(Answer answer) {
		answerDAO.updateAnswer(answer);
	}

}
