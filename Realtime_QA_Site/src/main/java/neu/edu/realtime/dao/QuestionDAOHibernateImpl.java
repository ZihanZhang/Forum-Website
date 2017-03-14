package neu.edu.realtime.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import neu.edu.realtime.domain.Question;

@Repository
public class QuestionDAOHibernateImpl implements QuestionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addQuestion(Question question) {
		sessionFactory.getCurrentSession().save(question);
	}

	@Override
	public void delQuestion(Question question) {
		sessionFactory.getCurrentSession().delete(question);
	}

	@Override
	public Collection<Question> listQuestion() {
		return sessionFactory.getCurrentSession().createQuery("from Question").list();
	}

	@Override
	public void updateQuestion(Question question) {
		sessionFactory.getCurrentSession().update(question);
	}

	@Override
	public Question query(int id) {
		Question question = (Question)sessionFactory.getCurrentSession().get(Question.class, id);
		return question;
	}

}
