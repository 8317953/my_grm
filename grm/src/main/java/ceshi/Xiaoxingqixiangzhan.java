package ceshi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Xiaoxingqixiangzhan {
	public static void main(String[] args) {
		
		
//		192.168.10.253:18898
		
		try{
            //向本机的4700端口发出客户请求
			System.out.println("向192.168.10.254:18898 请求连接");
            Socket socket=new Socket("192.168.10.254",18898);
            System.out.println("连接完成");
            
            
            
//            InputStream inputStream = socket.getInputStream();
//            // 得到一个输入流，接收客户端传递的信息
//            InputStreamReader inputStreamReader = new InputStreamReader(
//                    inputStream);// 提高效率，将自己字节流转为字符流
//            BufferedReader bufferedReader = new BufferedReader(
//                    inputStreamReader);// 加入缓冲区
//            String temp = null;
////            String info = "";
//            while ((temp = bufferedReader.readLine()) != null) {
////                info += temp;
//                System.out.println("已接收到客户端连接");
//                System.out.println("服务端接收到客户端信息：" + temp + ",当前客户端ip为："
//                        + socket.getInetAddress().getHostAddress());
//            }

            OutputStream outputStream = socket.getOutputStream();// 获取一个输出流，向服务端发送信息
            PrintWriter printWriter = new PrintWriter(outputStream);// 将输出流包装成打印流
            
            int[] is=new int[9];
            is[0]=0xaa;
            is[1]=0x1;
            
            printWriter.print("00000000000900100000000102000B");
            printWriter.flush();
            socket.shutdownOutput();// 关闭输出流

            // 关闭相对应的资源
//            bufferedReader.close();
//            inputStream.close();
            printWriter.close();
            outputStream.close();


            
            
            
            
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();//出错，打印出错信息
        }
	}
}
