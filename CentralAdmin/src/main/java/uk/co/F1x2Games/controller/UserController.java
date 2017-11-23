package uk.co.F1x2Games.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.co.F1x2Games.users.model.User;
import uk.co.F1x2Games.util.SecurityHelper;
import uk.co.F1x2Games.service.ChangeLogService;
import uk.co.F1x2Games.service.UserService;


@Controller
public class UserController {

	private static final String VIEW_USER = "users";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService service;
	@Autowired
	private ChangeLogService logService;
	@Autowired
	private SecurityHelper securityHelper;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView getFormData() {
		
		logger.debug("[User Controller] loading users page");
		return new ModelAndView("users", "user", new User());
	}
	
	@RequestMapping(value = "ajax/save", method = RequestMethod.POST)
	public @ResponseBody User submit(@ModelAttribute("user") User user, BindingResult result, ModelMap model) throws Exception{
		
		logger.debug("[User Controller] save User POST");
		
		User aUser = service.getUser(getLoggedInUser());
		String aDescription = "User : "+ user.getUsername() + "has been modified by user: " + aUser.getUsername();
		
		logger.info("[User Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(aUser, aDescription);
		
		service.saveUser(user);
		
		model.addAttribute("userid", user.getUserId());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("firstname", user.getFirstName());
		model.addAttribute("lastname", user.getLastName());
		model.addAttribute("emailaddress", user.getEmailAddress());
		model.addAttribute("enabled", user.getEnabled());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("password", user.getPassword());
		
		return user;
	 }
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getdata(Model model) {
	
		logger.debug("[User Controller] loading users page");
		model.addAttribute("user", new User());
		return VIEW_USER;
	}
	
	@RequestMapping(value = "/getUsersTable", method = RequestMethod.GET)
	public ModelAndView getUsers() {
		
		List<User> users = new ArrayList<User>();
		users.addAll(service.getUsers());
		
		logger.debug("[User Controller] getUsersTable: Button clicked on user page");
		//return back to index.jsp
		ModelAndView model = new ModelAndView("usersTable");
		return model.addObject("userList", users);
	}
	
	
	@RequestMapping(value = "users/edit-user", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") User user, ModelMap model) {

		logger.debug("[User Controller] users/edit-user:");
		User aUser = service.getUser(user.getUserId());

		aUser.setEmailAddress(user.getEmailAddress());
		aUser.setFirstName(user.getFirstName());
		aUser.setLastName(user.getLastName());
		aUser.setPassword(service.hashPassword(user.getPassword(), service.getNextSalt().toString()));
		aUser.setUsername(user.getUsername());
		
		service.saveUser(aUser);
		
		model.addAttribute("user", new User());

		return VIEW_USER;
	}
	
	@RequestMapping(value = "/ajax/createUser", method = RequestMethod.POST)
	public  @ResponseBody User createUser(@ModelAttribute("user") User user, ModelMap model) {

		logger.debug("[User Controller] create User POST");
		User aUser = service.getUser(getLoggedInUser());
		String aDescription = "User : "+ user.getUsername() + "has been created by user: " + aUser.getUsername();
		
		logger.info("[User Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(aUser, aDescription);
		service.createUser(user);
		
		model.addAttribute("user", user);

		return user;
	}
	
	@RequestMapping(value = "/ajax/unlockUser", method = RequestMethod.POST)
	public @ResponseBody User unlockUser(@RequestParam("id") int userId, ModelMap model) {

		logger.debug("[User Controller] unlock users User POST");
		User aUser = service.getUser(userId);
		User loggedinUser = service.getUser(getLoggedInUser());
		String aDescription = "User : "+ aUser.getUsername() + "has been created by user: " + loggedinUser.getUsername();
		
		logger.info("[User Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(loggedinUser, aDescription);
		
		service.unlockUser(aUser);

		return aUser;
	}
	
	@RequestMapping(value = "/ajax/deleteUser", method = RequestMethod.POST)
	public @ResponseBody User deleteUser(@RequestParam("id") int userId, ModelMap model) {

		User aUser = service.getUser(userId);
		User loggedinUser = service.getUser(getLoggedInUser());
		String aDescription = "User : "+ aUser.getUsername() + "has been deleted by user: " + loggedinUser.getUsername();
		
		logger.info("[User Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(loggedinUser, aDescription);
		service.deleteUser(aUser);
		return aUser;
	}
	
	
	@ModelAttribute("contextpath")
    public String setContextPath(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        return "/".equals(contextPath) ? "" : contextPath;
        
    }
	
	public String getLoggedInUser() {
		return securityHelper.getLoggedInUser();
	}
}
