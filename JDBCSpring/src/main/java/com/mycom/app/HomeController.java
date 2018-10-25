package com.mycom.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.entity.Candidate;
import com.mycom.entity.CandidateState;
import com.mycom.entity.FeedBack;
import com.mycom.entity.FeedBackState;
import com.mycom.entity.Interview;
import com.mycom.entity.Skill;
import com.mycom.entity.User;
import com.mycom.entity.Vacancy;
import com.mycom.jdbc.JdbcCandidateDao;
import com.mycom.jdbc.JdbcCandidateStateDao;
import com.mycom.jdbc.JdbcFeedBackDao;
import com.mycom.jdbc.JdbcFeedBackStateDao;
import com.mycom.jdbc.JdbcInterviewDao;
import com.mycom.jdbc.JdbcSkillDao;
import com.mycom.jdbc.JdbcUserDao;
import com.mycom.jdbc.JdbcVacancyDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
	@Autowired
	private JdbcVacancyDao jdbcvacancydao;
	
	@Autowired
	private JdbcCandidateStateDao jdbccandidatestatedao;
	
	@Autowired
	private JdbcCandidateDao jdbccandidatedao;
	
	@Autowired
	private JdbcInterviewDao jdbcinterviewdao;
	
	@Autowired
	private JdbcFeedBackStateDao jdbcfeedbackstatedao;
	
	@Autowired
	private JdbcFeedBackDao jdbcfeedbackdao;
	
	@Autowired
	private JdbcSkillDao jdbcskilldao;
	
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
		
		return "home";
	}
	
	
	private String CreateInterviewForm(Model model, Interview interview) {
		Map<Long,String> candidates = new HashMap<Long,String>();
		for (Candidate i:jdbccandidatedao.findAll()) {
			candidates.put(i.getId(), i.getName()+" "+i.getSurname());
		}
		Map<Long,String> vacancys = new HashMap<Long,String>();
		for (Vacancy i:jdbcvacancydao.findAll()) {
			vacancys.put(i.getId(), i.getPosition());
		}
		model.addAttribute("candidates",candidates);
		model.addAttribute("vacancys",vacancys);
		model.addAttribute("interview",interview);
		return "InterviewForm";
	}
	
	private String CreateFeedBackForm(Model model, FeedBack feedback) {
		Map<String,String> feedbackstates = new HashMap<String,String>();
		for (FeedBackState i:jdbcfeedbackstatedao.FindAll()) {
			feedbackstates.put(i.getName(), i.getName());
		}
		Map<Long,String> interviews = new HashMap<Long,String>();
		for (Interview i:jdbcinterviewdao.findAll()) {
			interviews.put(i.getId(), i.getName());
		}
		Map<Long,String> developers = new HashMap<Long,String>();
		for (User i:jdbcuserdao.findByRole("developer")) {
			developers.put(i.getId(), i.getName()+" "+i.getSurname());
		}
		model.addAttribute("feedback",feedback);
		model.addAttribute("interviews",interviews);
		model.addAttribute("feedbackstates",feedbackstates);
		model.addAttribute("developers",developers);
		return "FeedBackForm";
	}
	
	private String CreateSkillForm(Model model,Skill skill) {
		model.addAttribute("skill",skill);
		return "SkillForm";
	}
	

	

	

	
	@RequestMapping(value="/InterviewCreate",method = RequestMethod.GET)
	public String CreateInterview(Model model) {
		return CreateInterviewForm(model,new Interview());
	}
	
	@RequestMapping(value="/FeedbackCreate", method = RequestMethod.GET)
	public String CreateFeedback(Model model) {
		return CreateFeedBackForm(model,new FeedBack());
	}
	
	@RequestMapping(value="/SkillCreate", method = RequestMethod.GET)
	public String CreateSkill(Model model) {
		return CreateSkillForm(model,new Skill());
	}
	

	

	

	
	@RequestMapping(value = "/SaveInterview", method = RequestMethod.POST)
	public String SaveInterview(@Valid Interview interview, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateInterviewForm(model,interview);
		}
		jdbcinterviewdao.insert(interview);
		return "home";
	}
	
	@RequestMapping(value = "/SaveFeedback", method = RequestMethod.POST)
	public String SaveFeedBack(@Valid FeedBack feedback, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateFeedBackForm(model,feedback);
		}
		jdbcfeedbackdao.insert(feedback);
		return "home";
	}
	
	@RequestMapping(value = "/SaveSkill", method = RequestMethod.POST)
	public String SaveSkill(@Valid Skill skill, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return CreateSkillForm(model,skill);
		}
		jdbcskilldao.insert(skill);
		return "home";
	}

	

	
}
