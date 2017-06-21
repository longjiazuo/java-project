package org.light4j.listener.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * ServletRequestListener使用
 * 
 * @author longjiazuo
 * 
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

	// 当用户请求到达、被初始化时触发该方法
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre
				.getServletRequest();
		System.out.println("----发向" + request.getRequestURI() + "请求被初始化----");
	}

	// 当用户请求结束、被销毁时触发该方法
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre
				.getServletRequest();
		System.out.println("----发向" + request.getRequestURI() + "请求被销毁----");
	}
}