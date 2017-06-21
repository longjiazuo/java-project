package org.light4j.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取cookie
 * 
 * @author longjiazuo
 * 
 */
@WebServlet(name = "readCookie", urlPatterns = { "/readCookie" })
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取本站在客户端上保留的所有Cookie
		Cookie[] cookies = request.getCookies();
		// 遍历客户端上的每个Cookie
		for (Cookie c : cookies) {
			// 如果Cookie的名为username，表明该Cookie是我们需要访问的Cookie
			if (c.getName().equals("username")) {
				System.out.println(c.getValue());
			}
		}
	}
}
