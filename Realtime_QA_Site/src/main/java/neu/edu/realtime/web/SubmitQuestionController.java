package neu.edu.realtime.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/questionsubmission")
public class SubmitQuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String submitQuestion(Model model){
		Question question = new Question();
		model.addAttribute(question);
		return "questionsubmission";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitted(Model model,@ModelAttribute("question")Question question,@RequestParam("userlog")String userlog,BindingResult bindingResult){
		String curusername = SecurityContextHolder.getContext().getAuthentication().getName();
		User curuser = userService.query(curusername);
		User user = userService.query(userlog);
		Answer answer = new Answer();
		question.setUser(user);
		questionService.addQuestion(question);
		model.addAttribute("curuser",curuser);
		model.addAttribute("questionList",questionService.listQuestion());
		model.addAttribute("answerList",answerService.listAnswer());
		model.addAttribute("answer",answer);
		return "home-page";
	}
}
