package com.situ.servlet.day33;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter{
	public HelloFilter() {
		System.out.println("HelloFilter.HelloFilter()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("HelloFilter1.init()");
		/*String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);
		//获得所有的param-name
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		//遍历所有的name，根据name得到value
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + " : " + value);
		}*/
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);
		String uri = httpServletRequest.getRequestURI();
		System.out.println(uri);*/
		System.out.println("Filter1 before");
		//执行下一个过滤器或放行（访问servlet） 
		chain.doFilter(request, response);
		System.out.println("Filter1 after");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter1.destroy()");
	}

}
