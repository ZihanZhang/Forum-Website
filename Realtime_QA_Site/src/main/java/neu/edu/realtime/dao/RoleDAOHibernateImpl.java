package neu.edu.realtime.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import neu.edu.realtime.domain.Role;
import neu.edu.realtime.domain.User;

@Repository
public class RoleDAOHibernateImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public void delRole(Role role) {
		sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public Role query(String username) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Role where username=:username");
	     query.setString("username", username);
	     return (Role) query.uniqueResult();
	}

}
