package org.light4j.listener.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * HttpSessionAttributeListener使用
 * 
 * @author longjiazuo
 * 
 */
@WebListener
public class MyHttpSessionAttributeListener implements
		HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		// 获取添加的属性名和属性值
		String name = event.getName();
		Object value = event.getValue();
		System.out
				.println(session + "范围内添加了名为" + name + "，值为" + value + "的属性!");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		// 获取被删除的属性名和属性值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(session + "范围内名为" + name + "，值为" + value
				+ "的属性被删除了!");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		// 获取被替换的属性名和属性值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(session + "范围内名为" + name + "，值为" + value
				+ "的属性被替换了!");
	}
}