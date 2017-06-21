package org.light4j.listener.session;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.*;

/**
 * HttpSessionListener使用
 * 
 * @author longjiazuo
 * 
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	// 当用户与服务器之间开始session时触发该方法
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("创建session...");
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		// 获取session ID
		String sessionId = session.getId();
		// 如果是一次新的会话
		if (session.isNew()) {
			String user = (String) session.getAttribute("user");
			// 未登录用户当游客处理
			user = (user == null) ? "游客" : user;
			@SuppressWarnings("unchecked")
			Map<String, String> online = (Map<String, String>) application
					.getAttribute("online");
			if (online == null) {
				online = new Hashtable<String, String>();
			}
			// 将用户在线信息放入Map中
			online.put(sessionId, user);
			application.setAttribute("online", online);
		}
	}

	// 当用户与服务器之间session断开时触发该方法
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("销毁session...");
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		String sessionId = session.getId();
		@SuppressWarnings("unchecked")
		Map<String, String> online = (Map<String, String>) application
				.getAttribute("online");
		if (online != null) {
			// 删除该用户的在线信息
			online.remove(sessionId);
		}
		application.setAttribute("online", online);
	}
}