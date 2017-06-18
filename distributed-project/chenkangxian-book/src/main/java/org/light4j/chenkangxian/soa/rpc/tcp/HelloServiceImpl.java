package org.light4j.chenkangxian.soa.rpc.tcp;

/**
 * 服务实现类
 * 
 * @author longjiazuo
 * 
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "welcome " + name;
	}

}
