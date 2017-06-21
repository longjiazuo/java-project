package org.light4j.servlet.parameterConfig;

import java.sql.*;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

/**
 * 访问Servlet配置参数
 * 
 * @author longjiazuo
 * 
 */
@WebServlet(name = "testServlet", urlPatterns = { "/testServlet" }, initParams = {
		@WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/test"),
		@WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "pass", value = "123456") })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 重写init方法，
	public void init(ServletConfig config) throws ServletException {
		// 重写该方法，应该首先调用父类的init方法
		super.init(config);
	}

	// 响应客户端请求的方法
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {
			// 获取ServletConfig对象，取得当前servlet的配置参数
			ServletConfig config = getServletConfig();
			// 通过ServletConfig对象获取配置参数：dirver
			String driver = config.getInitParameter("driver");
			// 通过ServletConfig对象获取配置参数：url
			String url = config.getInitParameter("url");
			// 通过ServletConfig对象获取配置参数：user
			String user = config.getInitParameter("user");
			// 通过ServletConfig对象获取配置参数：pass
			String pass = config.getInitParameter("pass");
			// 注册驱动
			Class.forName(driver);
			// 获取数据库驱动
			Connection conn = DriverManager.getConnection(url, user, pass);
			// 创建Statement对象
			Statement stmt = conn.createStatement();
			// 执行查询，获取ResuletSet对象
			ResultSet rs = stmt.executeQuery("select * from customer");
			response.setContentType("text/html;charSet=utf-8");
			// 获取页面输出流
			PrintStream out = new PrintStream(response.getOutputStream());
			// 输出HTML标签
			out.println("<html>");
			out.println("<head>");
			out.println("<title>访问Servlet初始化参数测试</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table bgcolor=\"#9999dd\" border=\"1\""
					+ "width=\"480\">");
			// 遍历结果集
			while (rs.next()) {
				// 输出结果集内容
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}