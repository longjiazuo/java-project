package org.light4j.tool.system;

import java.io.IOException;

/**
 * <p>
 * Runtime类还有一个功能就是它可以直接启动一个进程来运行操作系统的命令
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月2日 下午10:22:08
 */
public class ExecTest {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		// 运行记事本程序
		rt.exec("notepad.exe");
	}
}
