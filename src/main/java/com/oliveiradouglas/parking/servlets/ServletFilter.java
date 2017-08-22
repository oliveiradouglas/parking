package com.oliveiradouglas.parking.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oliveiradouglas.parking.models.Alert;

@WebFilter(urlPatterns="/*")
public class ServletFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();
		
	    String alertAttributeName = "alert";
	    Alert alert = (Alert) session.getAttribute(alertAttributeName);
	    if (alert != null) {
	    	req.setAttribute(alertAttributeName, alert);
	    	session.removeAttribute(alertAttributeName);
	    }
	    
	    chain.doFilter(req, response);
	}

	@Override
	public void destroy() {}
}
