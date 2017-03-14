package neu.edu.realtime;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnswerService answerService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
/*		ArrayList ur = (ArrayList)userService.listUser();
		User us = (User)ur.get(0);
		Question qt = (Question)us.getQuestions().iterator().next();
		Role rl = (Role)us.getRoles().iterator().next();
		Answer as = new Answer();
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
