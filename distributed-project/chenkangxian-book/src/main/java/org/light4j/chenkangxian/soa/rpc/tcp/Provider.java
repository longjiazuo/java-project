package org.light4j.chenkangxian.soa.rpc.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务发布者
 * 
 * @author longjiazuo
 * 
 */
public class Provider {
	public static void main(String[] args) throws Exception {
		// 新建服务端socket
		ServerSocket serverSocket = new ServerSocket(12345);
		while (true) {
			// 获取Socket
			Socket socket = serverSocket.accept();
			ObjectInputStream input = new ObjectInputStream(
					socket.getInputStream());
			// 获取接口名称
			String interfaceName = input.readUTF();
			// 获取方法名称
			String methodName = input.readUTF();
			// 获取方法参数类型
			Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
			// 获取方法参数值
			Object[] values = (Object[]) input.readObject();
			// 加载初始化
			Class<?> service = Class.forName(interfaceName);
			Method method = service.getMethod(methodName, parameterTypes);
			// 反射执行方法
			Object result = method.invoke(service.newInstance(), values);

			ObjectOutputStream output = new ObjectOutputStream(
					socket.getOutputStream());
			output.writeObject(result);
		}
	}
}