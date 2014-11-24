package com.mingda.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SeesionFilter
 */
@WebFilter("/page/*")
public class SeesionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SeesionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("rawtypes")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request1 = (HttpServletRequest) request;
		HttpServletResponse response1 = (HttpServletResponse) response;
		HttpSession session = request1.getSession();
		HashMap map = (HashMap) session.getAttribute("map");
		if (null == map) {
			System.out.println("Îª¿Õ");
			String contextPath = request1.getContextPath();
			System.out.println(contextPath);
			response1.sendRedirect(contextPath+"/logout.jsp");
		} else {
			System.out.println("²»Îª¿Õ");
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
