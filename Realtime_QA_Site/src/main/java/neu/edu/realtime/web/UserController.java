package neu.edu.realtime.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.Role;
import neu.edu.realtime.domain.User;
import neu.edu.realtime.service.RoleService;
import neu.edu.realtime.service.UserService;


@Controller
@RequestMapping("/home")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
//	@Autowired
//	private QuestionService questionService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user,@ModelAttribute("role")Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "home";
		}
//		userService.saveQuestion(user);
//		questionService.addQuestion(question);
		user.setEnabled(1);
		role.setRole("ROLE_USER");
		role.setUser(user);
		user.getRoles().add(role);
		userService.addUser(user);
		roleService.addRole(role);
		return "redirect:/home";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listUser(Model model) {
		User ur1 = new User();
		model.addAttribute("user", ur1);
		model.addAttribute("role",new Role());
		model.addAttribute("userList", userService.listUser());
//		model.addAttribute("questionList", questionService.listQuestion());
		return "home";
	}
}
