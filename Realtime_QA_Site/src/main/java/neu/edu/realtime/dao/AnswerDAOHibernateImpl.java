package neu.edu.realtime.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import neu.edu.realtime.domain.Answer;

@Repository
public class AnswerDAOHibernateImpl implements AnswerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAnswer(Answer answer) {
		sessionFactory.getCurrentSession().save(answer);
	}

	@Override
	public void delAnswer(Answer answer) { 
		sessionFactory.getCurrentSession().delete(answer);
	}

	@Override
	public Collection<Answer> listAnswer() {
		return sessionFactory.getCurrentSession().createQuery("from Answer").list();
	}

	@Override
	public void updateAnswer(Answer answer) {
//		String hql="update Answer answer set answer.answer='sdfds' where answer.id=1";
//		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		sessionFactory.getCurrentSession().update(answer);
	}
}
