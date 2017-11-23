package uk.co.F1x2Games.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

/**
 * When an invalid session is encountered, check whether an Ajax request was the
 * initiator. if it was ajax, respond by instructing the browser to redirect to
 * the session expired page. 
 */
public class AjaxFilter extends GenericFilterBean {

	private Logger logger = LoggerFactory.getLogger(AjaxFilter.class);
	private static final String TIMEOUT_MESSAGE = "Session Timeout";


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		boolean ajaxRequestReceived = false;

		boolean sessionExpired = false;

		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		
		if (request instanceof HttpServletRequest) {
			
			httpRequest = (HttpServletRequest) request;
			httpResponse = (HttpServletResponse) response;
			ajaxRequestReceived = "XMLHttpRequest".equalsIgnoreCase(httpRequest.getHeader("X-Requested-With"));
			sessionExpired = hasSessionExpired(httpRequest);
		}

		if (sessionExpired && ajaxRequestReceived) {
			httpResponse.sendError(408,TIMEOUT_MESSAGE);
		} else {
			chain.doFilter(request, response);
		}

	}

	private boolean hasSessionExpired(HttpServletRequest httpRequest) {
		boolean result = false;
		
		if(httpRequest.getRequestURI().contains("/login") ){
			logger.debug("User Session has timed out - sending 408 SESSION_TIMEOUT response");
			result=true;
		}
		
		if (httpRequest.getRequestedSessionId() != null && !httpRequest.isRequestedSessionIdValid()) {
			result = true;
			logger.debug("Requested session ID " + httpRequest.getRequestedSessionId() + " is invalid.");
		}
		return result;
	}
}
