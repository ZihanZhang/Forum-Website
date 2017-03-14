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
import org.springframework.web.bind.annotation.RequestParam;

import neu.edu.realtime.domain.Answer;
import neu.edu.realtime.domain.Question;
import neu.edu.realtime.domain.Role;
import neu.edu.realtime.domain.User;
import neu.edu.realtime.service.AnswerService;
import neu.edu.realtime.service.QuestionService;
import neu.edu.realtime.service.RoleService;
import neu.edu.realtime.service.UserService;

@Controller
@RequestMapping("/submission")
public class AnswerSubmitController {	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitPro(Model model,@RequestParam("questionid")int questionid,@ModelAttribute("answer")Answer answer,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "home-page";
		}
		
		UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User curuser = userService.query(userdetails.getUsername());
		curuser.setExp(curuser.getExp()+30);
		userService.userUpdate(curuser);
		answer.setQuestion(questionService.query(questionid));
		answerService.addAnswer(answer);
		
		model.addAttribute("curuser",curuser);
		model.addAttribute("answerList",answerService.listAnswer());
		model.addAttribute("questionList", questionService.listQuestion());
		return "home-page";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomepage(){
		return "test";
	}

}
