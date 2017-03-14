package neu.edu.realtime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import neu.edu.realtime.dao.QuestionDAO;
import neu.edu.realtime.dao.RoleDAO;
import neu.edu.realtime.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	@Qualifier("roleDAOHibernateImpl")
	private RoleDAO roleDAO;
	@Override
	public void addRole(Role role) {
		roleDAO.addRole(role);
	}

	@Override
	public void delRole(Role role) {
		roleDAO.delRole(role);
	}

	@Override
	public Role query(String username) {
		return roleDAO.query(username);
	}

}
