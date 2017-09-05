package com.situ.servlet.day33;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HelloFilter2 implements Filter{

	public HelloFilter2() {
		System.out.println("HelloFilter2.HelloFilter2()");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("HelloFilter2.init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("HelloFilter2.doFilter()");
		/*HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);
		String uri = httpServletRequest.getRequestURI();
		System.out.println(uri);*/
		System.out.println("Filter2 before");
		//执行下一个过滤器或放行（访问servlet） 
		chain.doFilter(request, response);
		System.out.println("Filter2 after");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter2.destroy()");
	}

}
