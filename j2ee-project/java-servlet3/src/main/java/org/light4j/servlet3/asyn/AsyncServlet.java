package org.light4j.servlet3.asyn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<title>异步调用示例</title>");
		out.println("进入Servlet的时间：" + new java.util.Date() + ".<br/>");
		out.flush();
		// 创建AsyncContext，开始异步调用
		AsyncContext actx = request.startAsync();
		// 为该异步调用注册监听器
		actx.addListener(new MyAsyncListener());
		// 设置异步调用的超时时长
		actx.setTimeout(30 * 1000);
		// 启动异步调用的线程
		actx.start(new Executor(actx));
		out.println("结束Servlet的时间：" + new java.util.Date() + ".<br/>");
		out.flush();
	}
}
