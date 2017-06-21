package org.light4j.listener.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试属性Servlet
 * 
 * @author longjiazuo
 * 
 */
@WebServlet(name = "testServlet", urlPatterns = { "/testServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("操作request范围的属性");
		// 添加ServletContext属性
		req.setAttribute("request", "request");
		// 添加ServletContext属性
		req.setAttribute("request", "request+1");
		// 添加ServletContext属性
		req.removeAttribute("request");

		System.out.println("操作session范围的属性");
		HttpSession session = req.getSession();
		session.setAttribute("session", "session");
		// 添加ServletContext属性
		session.setAttribute("session", "session+1");
		// 添加ServletContext属性
		session.removeAttribute("session");

		System.out.println("操作ServletContext范围的属性");
		ServletContext servletContext = req.getServletContext();
		// 添加ServletContext属性
		servletContext.setAttribute("servletContext", "servletContext");
		// 修改ServletContext属性
		servletContext.setAttribute("servletContext", "servletContext+1");
		// 移除ServletContext属性
		servletContext.removeAttribute("servletContext");
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}