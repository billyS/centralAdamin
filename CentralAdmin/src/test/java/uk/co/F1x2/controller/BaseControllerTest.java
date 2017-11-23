package uk.co.F1x2.controller;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import uk.co.F1x2Games.controller.BaseController;

@RunWith(MockitoJUnitRunner.class)
public class BaseControllerTest {

    private BaseController baseController;

    @Mock
    HttpServletRequest request;

    @Mock
    Model model;
    
    ModelAndView modelAndView;

    @Mock
    SessionStatus sessionStatus;

    @Before
    public void init() {
    	baseController = new BaseController();
    }

    @Test
    public void setContextPathTest() {
        when(request.getContextPath()).thenReturn("path/to/resource");
        try {
            String path = baseController.setContextPath(request);
            Assert.assertEquals("path/to/resource", path);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void setRootContextPathTest() {
        when(request.getContextPath()).thenReturn("/");
        try {
            String path = baseController.setContextPath(request);
            Assert.assertEquals("", path);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void loginTest() {
       /* String logout="";
        String error="";
        modelAndView = baseController.login(logout, error,request);
        
        Assert.assertEquals("login", modelAndView.getViewName());*/
    }

    @Test
    public void logoutTest() {
        /*boolean loggedOut = loginController.logout(sessionStatus);
        Assert.assertTrue(loggedOut);
        Mockito.verify(sessionStatus).setComplete();*/
    }
}
