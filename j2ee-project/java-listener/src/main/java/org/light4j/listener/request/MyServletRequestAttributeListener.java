package org.light4j.listener.request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletRequestAttributeListener使用
 * 
 * @author longjiazuo
 * 
 */

@WebListener
public class MyServletRequestAttributeListener implements
		ServletRequestAttributeListener {

	// 当程序向request范围添加属性时触发该方法
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		ServletRequest request = event.getServletRequest();
		// 获取添加的属性名和属性值
		String name = event.getName();
		Object value = event.getValue();
		System.out
				.println(request + "范围内添加了名为" + name + "，值为" + value + "的属性!");
	}

	// 当程序从request范围删除属性时触发该方法
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		ServletRequest request = event.getServletRequest();
		// 获取被删除的属性名和属性值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(request + "范围内名为" + name + "，值为" + value
				+ "的属性被删除了!");
	}

	// 当request范围的属性被替换时触发该方法
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		ServletRequest request = event.getServletRequest();
		// 获取被替换的属性名和属性值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(request + "范围内名为" + name + "，值为" + value
				+ "的属性被替换了!");
	}
}