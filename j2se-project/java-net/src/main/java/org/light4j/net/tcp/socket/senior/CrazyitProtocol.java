package org.light4j.net.tcp.socket.senior;

public class CrazyitProtocol {
	// 定义协议字符串的长度
	public static int PROTOCOL_LEN = 2;
	// 下面是一些协议字符串，服务器和客户端交换的信息都应该在前、后添加这种特殊字符串。
	public static String MSG_ROUND = "§γ";
	public static String USER_ROUND = "∏∑";
	public static String LOGIN_SUCCESS = "1";
	public static String NAME_REP = "-1";
	public static String PRIVATE_ROUND = "★【";
	public static String SPLIT_SIGN = "※";
}
