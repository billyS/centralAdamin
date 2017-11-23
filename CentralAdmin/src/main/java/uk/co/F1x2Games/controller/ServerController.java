package uk.co.F1x2Games.controller;

import java.util.ArrayList;
import java.util.List;

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

import uk.co.F1x2Games.Server;
import uk.co.F1x2Games.service.ChangeLogService;
import uk.co.F1x2Games.service.ServerService;
import uk.co.F1x2Games.service.UserService;
import uk.co.F1x2Games.users.model.User;
import uk.co.F1x2Games.util.SecurityHelper;

@Controller
public class ServerController {

	private static final String VIEW_GAMES = "servers";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ServerController.class);
	
	@Autowired
	private ServerService service;
	@Autowired
	private ChangeLogService logService;
	@Autowired
	private SecurityHelper securityHelper;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getServerTable", method = RequestMethod.GET)
	public ModelAndView getServersTable() {
		
		List<Server> servers = new ArrayList<Server>();
		
		servers.addAll(service.getServers());
		logger.debug("[Server Controller] getServersTable:");
		ModelAndView model = new ModelAndView("serversTable3");
		return model.addObject("serverList", servers);
	}
	
	@RequestMapping(value = "/saveServer", method = RequestMethod.GET)
	public ModelAndView getFormData() {
		
		return new ModelAndView("servers", "server", new Server());
	}
	
	@RequestMapping(value = "/ajax/saveServer", method = RequestMethod.POST)
	public @ResponseBody Server submit(@ModelAttribute("server") Server server, BindingResult result, ModelMap model) throws Exception{
		
		logger.debug("[Server Controller] Server ID: " + server.getServerId());
		logger.debug("[Server Controller] Resin Pro Expiry Date: " + server.getServerId());
		
		User loggedinUser = userService.getUser(getLoggedInUser());
		String aDescription = "Game : "+ server.getServerId() + "has been modified by user: " + loggedinUser.getUsername();
		logService.insertLog(loggedinUser, aDescription);
		service.saveServer(server);
		
		model.addAttribute("serverId", server.getServerId());
		
		return server;
	 }
	
	@RequestMapping(value = "/servers", method = RequestMethod.GET)
	public String getdata2(Model model) {
		System.out.println("ServerController");
		model.addAttribute("server", new Server());
		return "servers";
	}
	
	
	@RequestMapping(value = "/getServersTable", method = RequestMethod.GET)
	public ModelAndView getServers() {
		
		List<Server> servers = new ArrayList<Server>();
		
		servers.addAll(service.getServers());
		logger.debug("[Server Controller] getUsersTable: Button clicked on user page");
		//return back to index.jsp
		ModelAndView model = new ModelAndView("serversTable");
		return model.addObject("serverList", servers);
	}
	
	
	@RequestMapping(value = "/ajax/createServer", method = RequestMethod.POST)
	public  @ResponseBody Server createServer(@ModelAttribute("server") Server server, ModelMap model) {
		
		logger.debug("[Server Controller] Create Server: server ID = " + server.getClientId());
		User loggedinUser = userService.getUser(getLoggedInUser());
		String aDescription = "Game : "+ server.getServerId() + "has been created by user: " + loggedinUser.getUsername();
		logService.insertLog(loggedinUser, aDescription);
		service.createServer(server);
		model.addAttribute("user", server);

		return server;
	}
	
	@RequestMapping(value = "/ajax/deleteServer", method = RequestMethod.POST)
	public @ResponseBody List<Server> deleteServer(@RequestParam("id") int serverId, ModelMap model) {

		Server aServer = service.getServer(serverId);
		User loggedinUser = userService.getUser(getLoggedInUser());
		String aDescription = "Game : "+ aServer.getServerId() + "has been deleted by user: " + loggedinUser.getUsername();
		logService.insertLog(loggedinUser, aDescription);
		service.deleteServer(aServer);
		List<Server> servers = new ArrayList<Server>();
		//servers.addAll(service.getServers());
		return servers;
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
