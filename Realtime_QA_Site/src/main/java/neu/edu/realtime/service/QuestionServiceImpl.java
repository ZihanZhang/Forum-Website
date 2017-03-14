package neu.edu.realtime.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import neu.edu.realtime.dao.QuestionDAO;
import neu.edu.realtime.dao.UserDAO;
import neu.edu.realtime.domain.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	@Qualifier("questionDAOHibernateImpl")
	private QuestionDAO questionDAO;

	@Override
	public void addQuestion(Question question) {
		questionDAO.addQuestion(question);
	}

	@Override
	public void delQuestion(Question question) {
		questionDAO.delQuestion(question);
	}

	@Override
	public Collection<Question> listQuestion() {
		return questionDAO.listQuestion();
	}

	@Override
	public void updateQuestion(Question question) {
		questionDAO.updateQuestion(question);
	}

	@Override
	public Question query(int id) {
		return questionDAO.query(id);
	}

}
