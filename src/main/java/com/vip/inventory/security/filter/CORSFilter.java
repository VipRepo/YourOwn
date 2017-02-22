package com.vip.inventory.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class CORSFilter extends GenericFilterBean{

	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println(req.getHeader("Authorization"));
		 HttpServletResponse response = (HttpServletResponse) res;
		 response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
	        response.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	        response.addHeader("Access-Control-Max-Age", "3600");
	        response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, X-Auth-Token, authorization");
	        response.addHeader("Access-Control-Allow-Credentials", "true");
	        response.addHeader("Access-Control-Expose-Headers", "Authorization");
		 
		 if(req.getMethod().equalsIgnoreCase("options")){
			 return;
		 }
		chain.doFilter(request, response);
	}

}
