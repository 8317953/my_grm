package ceshi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import sun.misc.BASE64Encoder;

public class Base64 {

	public static String ImageToBase64(String imgPath) {
	    byte[] data = null;
	    // 读取图片字节数组
	    try {
	        InputStream in = new FileInputStream(imgPath);
	        data = new byte[in.available()];
	        in.read(data);
	        in.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // 对字节数组Base64编码
	    BASE64Encoder encoder = new BASE64Encoder();
	    // 返回Base64编码过的字节数组字符串
	    return encoder.encode(Objects.requireNonNull(data));
	}
	public static void main(String[] args) {
//		C:\Users\10231\Desktop
		String str=ImageToBase64("C:\\Users\\10231\\Desktop\\1.bmp");
		System.out.println(str);
	}
}
