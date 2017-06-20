package org.light4j.consistency.hash.one;

import lombok.Data;

/**
 * 机器结点类，封装了机器节点的信息 ，如name、password、ip、port等
 * 
 * @author longjiazuo
 * 
 */
@Data
public class Machine {

	public Machine() {
	}

	public Machine(String name, String password, String ip, Integer port) {
		this.name = name;
		this.password = password;
		this.ip = ip;
		this.port = port;
	}

	// 机器名称
	private String name;
	// 机器密码
	private String password;
	// 机器ip
	private String ip;
	// 机器端口
	private Integer port;
}