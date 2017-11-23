package uk.co.F1x2Games.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.co.F1x2Games.ResetToken;
import uk.co.F1x2Games.ResetTokenGenerator;
import uk.co.F1x2Games.service.ChangeLogService;
import uk.co.F1x2Games.service.PasswordResetService;
import uk.co.F1x2Games.service.UserService;
import uk.co.F1x2Games.service.UserSessionService;
import uk.co.F1x2Games.users.model.User;
import uk.co.F1x2Games.util.SecurityHelper;
import uk.co.F1x2Games.util.SessionHelper;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	private UserService service;
	
	@Autowired
	private ChangeLogService logService;
	
	@Autowired
	private UserSessionService sessionService;

	@Autowired
	protected SessionHelper sessionHelper;

	@Autowired
	public SecurityHelper securityHelper;
	
	/*@Autowired
	ResetTokenGenerator resetTokenGen;*/
	
	@Autowired 
	private PasswordResetService resetService;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		//model.addObject("title", "Spring Security Login Form - Database Authentication");
		//model.addObject("message", "This is default page!");
		
		User aUser = service.getUser(getLoggedInUser());
		String sessionToken = request.getSession().getId();
		sessionService.insertUserSessionStart(aUser, sessionToken);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("loggedin", true);
	
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login( @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		//User aUser = service.getUser(getLoggedInUser());
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			//request.getSession(false).invalidate();
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public  @ResponseBody User passwordReminder(@RequestParam("email") String email, ModelMap model) {

		logger.debug("[Base Controller] Password Reminder POST");
		
		User aUser = service.getUser(email);
		
		if (aUser == null) {
	        try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		
		//ResetToken token = resetTokenGen.nextResetToken();
		
		
		model.addAttribute("user", aUser);

		return aUser;
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public  @ResponseBody User resetPassword(@RequestParam("token") String token, ModelMap model) {

		logger.debug("[Base Controller] Password Reminder POST");
		//ResetToken rToken = service.getResteToken();
	

		return null;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	//customize the error message
	private String getErrorMessage(HttpServletRequest request, String key){

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		}else if(exception instanceof LockedException) {
			error = exception.getMessage();
		}else{
			error = "Invalid username and password!";
		}

		return error;
	}

	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}
		model.setViewName("403");
		return model;

	}

	@ModelAttribute("loggedInUser")
	public String getLoggedInUser() {
		return securityHelper.getLoggedInUser();
	}
	
	@ModelAttribute("contextpath")
    public String setContextPath(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        return "/".equals(contextPath) ? "" : contextPath;
       
    }

	/*@ModelAttribute("userDisplayName")
	public String displayLoggedinUser() {
		User user = service.getUser(getLoggedInUser());
		StringBuilder sb = new StringBuilder();
		sb.append(user.getFirstName());
		sb.append(" ");
		sb.append(user.getLastName());
		return sb.toString();
	}*/
}
