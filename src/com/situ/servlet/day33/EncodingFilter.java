package com.situ.servlet.day33;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String method = httpServletRequest.getMethod();
		if (method.equalsIgnoreCase("get")) {
			EnhancedRequest enhancedRequest = new EnhancedRequest(httpServletRequest);
			chain.doFilter(enhancedRequest, response);
		} else {
			request.setCharacterEncoding("utf-8");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}

class EnhancedRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	
	public EnhancedRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String nameValue = request.getParameter(name);//得到的还是乱码
		if (nameValue != null && !nameValue.equals("")) {
			try {
				nameValue = new String(nameValue.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return nameValue;
	}
	
}
