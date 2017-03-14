package neu.edu.realtime.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import neu.edu.realtime.domain.User;
import neu.edu.realtime.service.AnswerService;
import neu.edu.realtime.service.QuestionService;
import neu.edu.realtime.service.RoleService;
import neu.edu.realtime.service.UserService;

@Controller
@RequestMapping("/admin-manage/administration")
public class AdminController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String adminPage(Model model){
		model.addAttribute("userList",userService.listUser());
		return "/admin-manage/administration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String adminForm(@RequestParam("usern")String usern,Model model){
		User user = userService.query(usern);
		userService.delUser(user);
		model.addAttribute("userList",userService.listUser());
		return "/admin-manage/administration";
	}
}
