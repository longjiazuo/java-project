package org.light4j.chenkangxian.soa.rpc.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 消费消费者
 * 
 * @author longjiazuo
 * 
 */
public class Consumer {
	
	final static Map<String,Object> objMap = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		// 获取Class类
		Class<?> clazz = HelloServiceImpl.class;
		// 获取接口名称
		String interfaceName = clazz.getName();
		// 获取要访问的方法
		Method method = clazz.getMethod("sayHello", String.class);
		// 方法名称
		String methodName = method.getName();
		// 方法的参数类型
		Class<?>[] parameterTypes = method.getParameterTypes();
		// 传递的参数
		Object[] values = { "longjiazuo" };
		Socket socket = new Socket("127.0.0.1", 12345);

		// 通过socket的输出流获取对象输出流
		ObjectOutputStream output = new ObjectOutputStream(
				socket.getOutputStream());
		output.writeUTF(interfaceName);
		output.writeUTF(methodName);
		output.writeObject(parameterTypes);
		output.writeObject(values);

		// 通过socket的输入流获取对象输入流
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		// 输出响应结果
		System.out.println(input.readObject());
	}
}