package neu.edu.realtime.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.realtime.domain.Answer;
import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.Role;
import neu.edu.realtime.domain.User;
import neu.edu.realtime.service.AnswerService;
import neu.edu.realtime.service.QuestionService;
import neu.edu.realtime.service.RoleService;
import neu.edu.realtime.service.UserService;

@Controller
@RequestMapping("/init")
public class InitController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String initSite(){
/*		User ur1 = new User();
		Question qt1 = new Question();
		Role rl1 = new Role();
		Answer as = new Answer();
		ur1.setUsername("usernametest");
		ur1.setPassword("passwordtest");
		ur1.setEnabled(1);
		rl1.setRole("ROLE_USER");
		rl1.setUser(ur1);
		qt1.setQuestion("questiontest");
		qt1.setUser(ur1);
		as.setAnswer("answertest");
		as.setQuestion(qt1);
		qt1.getAnswers().add(as);
		ur1.getRoles().add(rl1);
		ur1.getQuestions().add(qt1);
		userService.addUser(ur1);
		roleService.addRole(rl1);
		questionService.addQuestion(qt1);
		answerService.addAnswer(as);*/
/*		User ur = new User();
		Role rl = new Role();
		rl.setUser(ur);
		rl.setRole("ROLE_ADMIN");
		ur.setUsername("administrator");
		ur.setPassword("password");
		ur.getRoles().add(rl);
		userService.addUser(ur);
		roleService.addRole(rl);
*/
/*		User us = userService.query("administrator");
		Role rl = new Role();
		rl.setRole("ROLE_USER");
		rl.setUser(us);
		us.getRoles().add(rl);
		roleService.addRole(rl);
*/
/*		User us = userService.query("administrator");
		userService.delUser(us);
*/
/*		User us = new User();
		us.setUsername("admin");
		us.setPassword("admin");
		us.setEnabled(1);
		Role rl1 = new Role();
		rl1.setRole("ROLE_USER");
		rl1.setUser(us);
		Role rl2 = new Role();
		rl2.setRole("ROLE_ADMIN");
		rl2.setUser(us);
		us.getRoles().add(rl1);
		us.getRoles().add(rl2);
		userService.addUser(us);
		roleService.addRole(rl1);
		roleService.addRole(rl2);
*/
/*		User us = userService.query("zhangzihan");
		Role rl = new Role();
		rl.setRole("ROLE_USER");
		rl.setUser(us);
		roleService.addRole(rl);
		*/
/*		User us = userService.query("zihan");
		userService.delUser(us);
	*/	
		return "test";

	}
}
