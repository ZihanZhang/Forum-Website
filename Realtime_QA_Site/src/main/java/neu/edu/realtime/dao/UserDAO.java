package neu.edu.realtime.dao;

import java.util.Collection;
import neu.edu.realtime.domain.User;

public interface UserDAO {
	public void addUser(User user);
	public void delUser(User user);
	public User query(String usrn);
	public void userUpdate(User user);
	public Collection<User> listUser();
//	public void saveQuestion(User user);
}
