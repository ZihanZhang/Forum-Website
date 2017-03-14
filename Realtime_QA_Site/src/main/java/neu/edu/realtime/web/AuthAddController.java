package neu.edu.realtime.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import neu.edu.realtime.domain.Role;
import neu.edu.realtime.service.AnswerService;
import neu.edu.realtime.service.QuestionService;
import neu.edu.realtime.service.RoleService;
import neu.edu.realtime.service.UserService;

@Controller
@RequestMapping("/admin-manage/administration/auth")
public class AuthAddController {
	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;

	@RequestMapping(method=RequestMethod.POST)
	public String adminAdd(@RequestParam("userna")String userna,Model model){
		Role rl = new Role();
		rl.setRole("ROLE_ADMIN");
		rl.setUser(userService.query(userna));
		roleService.addRole(rl);
		model.addAttribute("userList",userService.listUser());
		return "promotesuccess";
	}
}
