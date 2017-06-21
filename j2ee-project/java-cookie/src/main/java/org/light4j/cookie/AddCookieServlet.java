package org.light4j.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加cookie
 * 
 * @author longjiazuo
 * 
 */
@WebServlet(name = "addCookie", urlPatterns = { "/addCookie" })
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取请求参数
		String name = request.getParameter("name");
		// 以获取到的请求参数为值，创建一个Cookie对象
		Cookie c = new Cookie("username", name);
		// 设置Cookie对象的生存期限,如果不设置，则cookie将会随浏览器的关闭而自动消失
		c.setMaxAge(24 * 3600);
		// 向客户端增加Cookie对象
		response.addCookie(c);
	}
}