package org.light4j.io.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter类的使用
 * <p>
 * 使用FileReader读取自身文件的内容，然后使用FileWriter写入到一个新的文件里面
 * </p>
 * 
 * @author longjiazuo
 * 
 */
public class FileWiter1Test {
	public static void main(String[] args) {
		try
		(
				//新建文件字节输出流,文件内容写入到newWriterFile2.java
				FileWriter fw = new FileWriter("newWriterFile2.java");
		)
		{
			fw.write("忆高考\r\n");
			fw.write("年年忆今朝，忙忙赶国考；\r\n");
			fw.write("不成真秀才，只图纸逍遥。\r\n");
			System.out.println("操作结束....");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}