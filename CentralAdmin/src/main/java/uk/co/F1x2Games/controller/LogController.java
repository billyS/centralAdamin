package uk.co.F1x2Games.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uk.co.F1x2Games.ChangeLog;
import uk.co.F1x2Games.service.ChangeLogService;
import uk.co.F1x2Games.util.SecurityHelper;

@Controller
public class LogController {
	
	@Autowired
	ChangeLogService service;
	
	@Autowired
	private ChangeLogService logService;
	@Autowired
	private SecurityHelper securityHelper;
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LogController.class);

	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public String  showLogs() {
		
		return "logs";
	}
	
	@RequestMapping(value = "/getLogsTable", method = RequestMethod.GET)
	public ModelAndView getlogs(){
		
		logger.debug("[Log Controller] getLogsTable");
		
		List<ChangeLog> logs = new ArrayList<ChangeLog>();
		logs.addAll(service.getlogs());
		
		ModelAndView model = new ModelAndView("logsTable");
		return model.addObject("logList", logs);
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
