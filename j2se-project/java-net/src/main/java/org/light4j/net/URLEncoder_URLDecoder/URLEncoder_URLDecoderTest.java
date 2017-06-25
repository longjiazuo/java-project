package org.light4j.net.URLEncoder_URLDecoder;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>
 * URLDecoder和URLEncoder用于完成普通字符串和application/x-www-form-urlencoded
 * MIME字符串之间的相互转换。
 * <p>
 * <p>
 * URLDecoder类包含一个decode(String s,String enc)静态方法,它可以将看上去是乱码的特殊字符串转换成特殊字符串。
 * <p>
 * <p>
 * URLEncoder类包含一个encode(String s,String
 * enc)静态方法,它可以将普通字符串转换成application/x-www-form-urlencoded MIME字符串。
 * <p>
 * <p>
 * 仅仅包含西欧字符的普通字符串和application/x-www-form-urlencoded
 * MIME字符串无须转换,而包含中文字符的普通字符串则需要转换
 * ,转换方法是每个中文字符占2个字节,每个字节可以转换成2个十六进制的数字,所以每个中文字符将转换成
 * "%XX%XX"的形式。当然,采用不同的字符集时,每个中文字符对应的字节数并不相同
 * ,所以使用URLDecoder和URLEncoder进行转换时也需要指定字符集。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月8日 下午9:34:22
 */
public class URLEncoder_URLDecoderTest {
	public static void main(String[] args) throws Exception {
		// 将application/x-www-form-urlencoded字符串转换成普通字符串
		String keyWord = URLDecoder.decode("%C8%CB%C9%FA%C9%E8%BC%C6%CA%A6",
				"GBK");
		System.out.println(keyWord);
		// 将普通字符串转换成application/x-www-form-urlencoded
		String urlStr = URLEncoder.encode("人生设计师", "GBK");
		System.out.println(urlStr);
	}
}