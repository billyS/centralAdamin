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

import uk.co.F1x2Games.Game;
import uk.co.F1x2Games.service.ChangeLogService;
import uk.co.F1x2Games.service.GameService;
import uk.co.F1x2Games.service.UserService;
import uk.co.F1x2Games.users.model.User;
import uk.co.F1x2Games.util.SecurityHelper;

@Controller
public class GameController {

	private static final String VIEW_GAMES = "games";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(GameController.class);
	
	@Autowired
	private GameService service;
	@Autowired
	private ChangeLogService logService;
	@Autowired
	private SecurityHelper securityHelper;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/saveGame", method = RequestMethod.GET)
	public ModelAndView getFormData() {
		logger.debug("[Game Controller]  save game method called");
		return new ModelAndView("game", "game", new Game());
	}
	
	@RequestMapping(value = "/ajax/saveGame", method = RequestMethod.POST)
	public @ResponseBody Game submit(@ModelAttribute("game") Game game, BindingResult result, ModelMap model) throws Exception{
		
		logger.debug("[Game Controller]  save game method 2 called");
		
		User loggedinUser = userService.getUser(getLoggedInUser());
		
		String aDescription = "Game : "+ game.getGameName() + "has been modified by user: " + loggedinUser.getUsername();
		
		logger.info("[Game Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(loggedinUser, aDescription);
		service.saveGame(game);
		
		model.addAttribute("gameId", game.getGameId());
		model.addAttribute("gameId", game.getGameName());
		model.addAttribute("gameId", game.getGameType());
		model.addAttribute("gameId", game.getGameGroup());
		model.addAttribute("gameId", game.getGameSubGroup());
		model.addAttribute("gameId", game.getGameStatus());
		model.addAttribute("gameId", game.getGameReleaseDate());
		model.addAttribute("gameId", game.getVersion());
		model.addAttribute("gameId", game.getSupplierId());
		model.addAttribute("gameId", game.getEstimatedDevCost());
		model.addAttribute("gameId", game.getEstimatedTestingCost());
		model.addAttribute("gameId", game.getExpectedMargin());
		model.addAttribute("gameId", game.getRangeMargin());
		model.addAttribute("gameId", game.isHtml5());
		model.addAttribute("gameId", game.isFlash());
		model.addAttribute("gameId", game.isDesktop());
		model.addAttribute("gameId", game.isMobile());
		model.addAttribute("gameId", game.isMiniGame());
		
		return game;
	 }
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public String getdata2(Model model) {
		System.out.println("GameController load game page");
		model.addAttribute("game", new Game());
		return "games";
	}
	
	@RequestMapping(value = "/getGamesTable", method = RequestMethod.GET)
	public ModelAndView getGames() {
		
		List<Game> games = new ArrayList<Game>();
		
		games.addAll(service.getGames());
		logger.debug("[Game Controller] getUsersTable: Button clicked on user page");
		//return back to index.jsp
		ModelAndView model = new ModelAndView("gamesTable");
		return model.addObject("gameList", games);
	}
	
	@RequestMapping(value = "/ajax/editGame", method = RequestMethod.POST)
	public String editGame(@ModelAttribute("game") Game game, ModelMap model) {

		logger.debug("[Game Controller] /editGame:");
		Game aGame = service.getGame(game.getGameId());
		
		service.saveGame(aGame);
		
		model.addAttribute("game", new Game());

		return VIEW_GAMES;
	}
	
	@RequestMapping(value = "/ajax/createGame", method = RequestMethod.POST)
	public @ResponseBody Game createGame(@ModelAttribute("game") Game game, ModelMap model) {
		
		System.out.println("create game mothod called");
		
		User loggedinUser = userService.getUser(getLoggedInUser());
		
		String aDescription = "Game : "+ game.getGameName() + "has been created by user: " + loggedinUser.getUsername();
		
		logger.info("[Game Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(loggedinUser, aDescription);
		service.createGame(game);
		
		model.addAttribute("game", game);

		return game;
	}
	
	@RequestMapping(value = "/ajax/deleteGame", method = RequestMethod.POST)
	public @ResponseBody Game deleteGame(@RequestParam("id") int gameId, ModelMap model) {
		
		Game aGame = service.getGame(gameId);
		User loggedinUser = userService.getUser(getLoggedInUser());
		String aDescription = "Game : "+ aGame.getGameName() + "has been deleted by user: " + loggedinUser.getUsername();
		
		logger.info("[Game Controller] Description of event being stored in the db: " + aDescription);
		
		logService.insertLog(loggedinUser, aDescription);
		service.deleteGame(aGame);
		return aGame;
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
