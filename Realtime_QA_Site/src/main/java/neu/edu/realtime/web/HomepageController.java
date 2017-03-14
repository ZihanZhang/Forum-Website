package neu.edu.realtime.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/home-page")
public class HomepageController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String showHomepage(@ModelAttribute("user")User user,@ModelAttribute("question")Question question,@ModelAttribute("role")Role role,@ModelAttribute("answer")Answer answer,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "home-page";
		}

//		answerService.updateAnswer(answer.getAnswer());
/*		Answer as = new Answer();
		as.setAnswer("sd");
		as.setQuestion(question);
		question.getAnswers().add(as);
		question.setUser(user);
		user.getQuestions().add(question);
		answerService.addAnswer(as);
*/
/*		ArrayList ur = (ArrayList)userService.listUser();
		User us = (User)ur.get(0);
		Question qt = (Question)us.getQuestions().iterator().next();
		Role rl = (Role)us.getRoles().iterator().next();
		answer.setQuestion(qt);
		qt.getAnswers().add(answer);
		answerService.addAnswer(answer);
/*		answer.setQuestion(question);
		question.getAnswers().add(answer);
		answerService.addAnswer(answer);*/
//		return "redirect:/home-page";
		Role rl = new Role();
		rl.setRole("ROLE_USER");
		rl.setUser(user);
		user.getRoles().add(rl);
		user.setEnabled(1);
		roleService.addRole(rl);
		userService.addUser(user);
		return "home-page";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listQuestion(Model model) {	
		String curusername = SecurityContextHolder.getContext().getAuthentication().getName();
		User curuser = userService.query(curusername);
//		User curuser = new User();
//		curuser.setExp(40);
/*		ArrayList ur = (ArrayList)userService.listUser();
		User us = (User)ur.get(0);
		Question qt = (Question)us.getQuestions().iterator().next();
		Role rl = (Role)us.getRoles().iterator().next();
		Answer as = new Answer();
		model.addAttribute("curuser",curuser);
		model.addAttribute("user",us);
		model.addAttribute("question",qt);
		model.addAttribute("role",rl);
		model.addAttribute("answer", as);
		*/
		Answer as = new Answer();
		model.addAttribute("answer", as);
		model.addAttribute("answerList",answerService.listAnswer());
		model.addAttribute("questionList", questionService.listQuestion());
		return "home-page";
	}
}
