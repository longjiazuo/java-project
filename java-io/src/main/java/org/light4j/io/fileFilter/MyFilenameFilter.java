package org.light4j.io.fileFilter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 自定义文件名过滤器
 * 
 * @author longjiazuo
 * 
 */
public class MyFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		// 如果文件以.xml结尾则符合条件返回true
		return name.endsWith(".xml");
	}
}
