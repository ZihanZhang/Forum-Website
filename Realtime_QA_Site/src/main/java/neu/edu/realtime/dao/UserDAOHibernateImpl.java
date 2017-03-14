package neu.edu.realtime.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.User;

@Repository
public class UserDAOHibernateImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user){
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Collection<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User query(String usrn) {
		 Query query=sessionFactory.getCurrentSession().createQuery("from User where username=:username");
	     query.setString("username", usrn);
	     return (User) query.uniqueResult();
	     
	}

	@Override
	public void userUpdate(User user) {
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	@Override
	public void saveQuestion(User user) {
		Question qc = new Question();
		qc.question = user.getQuestion();
		user.getQuestions().add(qc);
	}
	*/
	
}
