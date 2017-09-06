package com.situ.servlet.day34;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSessionAttributeListener.attributeAdded()");
		String name = se.getName();
		Object value = se.getValue();
		System.out.println(name + " : " + value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSessionAttributeListener.attributeRemoved()");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSessionAttributeListener.attributeReplaced()");
	}

}
