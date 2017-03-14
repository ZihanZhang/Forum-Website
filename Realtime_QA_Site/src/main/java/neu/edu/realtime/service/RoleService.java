package neu.edu.realtime.service;

import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.Role;

public interface RoleService {
	public void addRole(Role role);
	public void delRole(Role role);
	public Role query(String username);
}
