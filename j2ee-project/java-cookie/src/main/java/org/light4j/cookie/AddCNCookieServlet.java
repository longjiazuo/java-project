package org.light4j.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加中文字符的cookie
 * <p>
 * 默认情况下，Cookie值不允许出现中文字符，如果需要值为中文的内容，则需要进行编解码操作
 * 
 * @author longjiazuo
 * 
 */
@WebServlet(name = "addCNCookie", urlPatterns = { "/addCNCookie" })
public class AddCNCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 以编码后的字符串为值，创建一个Cookie对象
		Cookie c = new Cookie("cnName",
				java.net.URLEncoder.encode("人生设计师", "utf-8"));
		// 设置Cookie对象的生存期限,如果不设置，则cookie将会随浏览器的关闭而自动消失
		c.setMaxAge(24 * 3600);
		// 向客户端增加Cookie对象
		response.addCookie(c);

		// 获取本站在客户端上保留的所有Cookie
		Cookie[] cookies = request.getCookies();
		// 遍历客户端上的每个Cookie
		for (Cookie cookie : cookies) {
			// 如果Cookie的名为username，表明该Cookie是我们需要访问的Cookie
			if (cookie.getName().equals("cnName")) {
				// 使用java.util.URLDecoder对Cookie值进行解码
				System.out
						.println(java.net.URLDecoder.decode(cookie.getValue()));
			}
		}
	}
}