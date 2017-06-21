package org.light4j.servlet.lifecycle;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

/**
 * Servlet生命周期
 * 
 * <p>
 * 配置loadOnStartup = 1，系统启动的时候servlet进行初始化
 * <p>
 * 下面的注解如果不添加urlPatterns={"/timerServlet"}，则定时器不起作用。
 * 
 * @author longjiazuo
 * 
 */
@WebServlet(urlPatterns = { "/timerServlet" }, loadOnStartup = 1)
public class TimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Timer t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(new Date());
			}
		});
		t.start();
	}
}