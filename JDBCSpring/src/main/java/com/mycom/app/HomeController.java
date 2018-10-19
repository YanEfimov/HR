package com.mycom.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.entity.User;
import com.mycom.jdbc.JdbcUserDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
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
	
	@RequestMapping(value = "/UserCreate",method = RequestMethod.GET)
	public String CreateUser(Model model) {
		Map< String, String > map = new HashMap<String, String>();
		map.put("manager", "manager");
		map.put("developer", "developer");
		User user=new User();
		model.addAttribute("user",user);
		model.addAttribute("map",map);
		
		return "UserCreate";
	}
	
	@RequestMapping(value = "/SaveUser", method = RequestMethod.POST)
	public String SaveUser(@ModelAttribute User user) {
		jdbcuserdao.insert(user);
		return "home";
	}
	
}
