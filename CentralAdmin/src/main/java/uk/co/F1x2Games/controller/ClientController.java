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

import uk.co.F1x2Games.Client;
import uk.co.F1x2Games.service.ChangeLogService;
import uk.co.F1x2Games.service.ClientService;
import uk.co.F1x2Games.service.UserService;
import uk.co.F1x2Games.users.model.User;
import uk.co.F1x2Games.util.SecurityHelper;

@Controller
public class ClientController {

	private static final String VIEW_GAMES = "clients";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService service;
	@Autowired
	private ChangeLogService logService;
	@Autowired
	private SecurityHelper securityHelper;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/ajax/saveClient", method = RequestMethod.GET)
	public ModelAndView getFormData() {
		
		return new ModelAndView("client", "client", new Client());
	}
	
	/**
	 * @param client this is the client that has been modified
	 * @param result this will be used to validate the attributes of the client when a Validator has been implemented
	 * @param model data model being passed to the jsp to be displayed
	 * @return returns the client that has been modified so that the changes can be displayed in the model
	 * @throws Exception
	 * This method save a modifications made to a client in the database and logs the the event in the changeLog table
	 */
	@RequestMapping(value = "/ajax/saveClient", method = RequestMethod.POST)
	public @ResponseBody Client submit(@ModelAttribute("client") Client client, BindingResult result, ModelMap model) throws Exception{
		
		
		logger.info("[Client Controller] logged in user: "+ getLoggedInUser());
		logger.info("[Client Controller] Client Name: " + client.getClientName());
		
		User aUser = userService.getUser(getLoggedInUser());
	
		logger.info("[Client Controller] User Name from service: " + aUser.getUsername());
		
		service.saveClient(client);
		String aDescription = "Client : "+ client.getClientName() + "has been modified bu user: " + aUser.getUsername();
		
		logger.info("[Client Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(aUser, aDescription);
		model.addAttribute("clientId", client.getClientId());
		
		return client;
	 }
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getdata(Model model) {
		System.out.println("ClientController: loading clients page");
		model.addAttribute("client", new Client());
		return "clients";
	}
	
	
	@RequestMapping(value = "/getClientsTable", method = RequestMethod.GET)
	public ModelAndView getClients() {
		
		List<Client> clients = new ArrayList<Client>();
		
		clients.addAll(service.getClients());
		logger.debug("[Client Controller] getClientsTable: Button clicked on user page");
		logger.debug("[Client Controller] getClientsTable: Clients List Size= "+ clients.size());
		//return back to index.jsp
		ModelAndView model = new ModelAndView("clientsTable");
		return model.addObject("clientList", clients);
	}
	
	
	@RequestMapping(value = "clients/editClient", method = RequestMethod.POST)
	public String editClient(@ModelAttribute("client") Client client, ModelMap model) {

		logger.debug("[User Controller] users/edit-user:");
		Client aClient = service.getClient(client.getClientId());
		
		service.saveClient(aClient);
		
		model.addAttribute("client", new Client());

		return VIEW_GAMES;
	}
	
	@RequestMapping(value = "/ajax/createClient", method = RequestMethod.POST)
	public  @ResponseBody Client createClient(@ModelAttribute("client") Client client, ModelMap model) {
		
		Client aClient = service.createClient(client);
		User aUser = new User();
		
		String aDescription = "Client : "+ client.getClientName() +" was created by User: " + aUser.getUsername();
		logService.insertLog(aUser, aDescription);
		
		model.addAttribute("client", aClient);

		return client;
	}
	
	@RequestMapping(value = "/ajax/deleteClient", method = RequestMethod.POST)
	public @ResponseBody Client deleteClient(@RequestParam("id") int clientId, ModelMap model) {

		Client aClient = service.getClient(clientId);
		service.deleteClient(aClient);
		
		User aUser = new User();
		String aDescription = "Client : "+ aClient.getClientName() +"has been deleted by User: " + aUser.getUsername();
		logService.insertLog(aUser, aDescription);
		
		return aClient;
	}
	
	public String getLoggedInUser() {
		return securityHelper.getLoggedInUser();
	}
	
	@ModelAttribute("contextpath")
    public String setContextPath(HttpServletRequest request) throws Exception {
        String contextPath = request.getContextPath();
        return "/".equals(contextPath) ? "" : contextPath;
       
    }

	public String displayLoggedinUser() {
		User user = userService.getUser(getLoggedInUser());
		StringBuilder sb = new StringBuilder();
		sb.append(user.getFirstName());
		sb.append(" ");
		sb.append(user.getLastName());
		return sb.toString();
	}
}
