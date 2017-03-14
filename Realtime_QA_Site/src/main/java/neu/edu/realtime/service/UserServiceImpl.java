package neu.edu.realtime.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.realtime.dao.UserDAO;
import neu.edu.realtime.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userDAOHibernateImpl")
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void addUser(User user){
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void delUser(User user) {
		userDAO.delUser(user);
	}

	@Override
	@Transactional
	public Collection<User> listUser() {
		return userDAO.listUser();
	}
/*
	@Override
	@Transactional
	public void saveQuestion(User user) {
		userDAO.saveQuestion(user);
	}
	*/

	@Override
	public User query(String usrn) {
		return userDAO.query(usrn);
	}

	@Override
	public void userUpdate(User user) {
		userDAO.userUpdate(user);
	}
}
