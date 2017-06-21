package org.light4j.listener.servletContext;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

/**
 * ServletContextListener使用
 * 
 * @author longjiazuo
 * 
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	// 应该启动时，该方法被调用。
	public void contextInitialized(ServletContextEvent sce) {
		try {
			System.out.println("应用启动...");
			// 取得该应用的ServletContext实例
			ServletContext application = sce.getServletContext();
			// 从配置参数中获取驱动
			String driver = application.getInitParameter("driver");
			// 从配置参数中获取数据库url
			String url = application.getInitParameter("url");
			// 从配置参数中获取用户名
			String user = application.getInitParameter("user");
			// 从配置参数中获取密码
			String pass = application.getInitParameter("pass");
			// 注册驱动
			Class.forName(driver);
			// 获取数据库连接
			Connection conn = DriverManager.getConnection(url, user, pass);
			// 将数据库连接设置成application范围内的属性
			application.setAttribute("conn", conn);
		} catch (Exception ex) {
			System.out.println("Listener中获取数据库连接出现异常" + ex.getMessage());
		}
	}

	// 应该关闭时，该方法被调用。
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("应用销毁...");
		// 取得该应用的ServletContext实例
		ServletContext application = sce.getServletContext();
		Connection conn = (Connection) application.getAttribute("conn");
		// 关闭数据库连接
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}