package neu.edu.realtime.dao;

import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.Role;

public interface RoleDAO {
	public void addRole(Role role);
	public void delRole(Role role);
	public Role query(String username);
}
