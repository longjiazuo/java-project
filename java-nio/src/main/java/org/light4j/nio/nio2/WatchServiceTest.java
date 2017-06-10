package org.light4j.nio.nio2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * WatchService测试
 * 
 * @author longjiazuo
 * 
 */
public class WatchServiceTest {
	public static void main(String[] args) {
		// 获取FileSystem对象
		FileSystem fileSystem = FileSystems.getDefault();
		try (
		// 获取WatchService对象
		WatchService watchService = fileSystem.newWatchService();) {
			// 为C盘根路径注册监听
			Paths.get("c:").register(watchService,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);
			while (true) {
				// 获取下一个文件变化事件
				WatchKey key = watchService.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					System.out.println(event.context() + " 文件发生了 "
							+ event.kind() + " 事件!");
				}
				// 重置WatchKey
				boolean valid = key.reset();
				// 如果失败，退出监听
				if (!valid) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}