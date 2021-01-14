package ceshi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Dibang {

	
	public static final ArrayList<String> findPorts() {
        // 获得当前所有可用串口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        ArrayList<String> portNameList = new ArrayList<String>();
        // 将可用串口名添加到List并返回该List
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        return portNameList;
    }
	
	
	private String weightNum(){
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
//		System.out.println();
		int flag=1;
		String data=null;
		CommPortIdentifier portId = null;
		InputStream inputStream=null;//串口输入流
		SerialPort serialPort=null;//串口对象
		String str1=null;//缓冲区字节码转换后的字符串
		byte[] readBuffer = new byte[4096];//用于存放串口输入流中读取的字节缓冲区
		StringBuffer buffer = new StringBuffer();//将字节缓冲区的值拼接成字符串
		try{
			Enumeration en = CommPortIdentifier.getPortIdentifiers();
			if(en.hasMoreElements()){
				portId=(CommPortIdentifier)en.nextElement();
				
				if(portId.getPortType()!=CommPortIdentifier.PORT_SERIAL){
				}
			}
			if(portId!=null){//如果有端口对象，打开端口，得到数据流
               
                   	serialPort = (SerialPort) portId.open("wData", 1000);//portId.open("串口所有者名称", 超时等待时间);
                   	inputStream = serialPort.getInputStream();//获取端口数据流
                   	serialPort.setSerialPortParams(9600,//波特率-9600
                   			SerialPort.DATABITS_8,//数据位数-8
                   			SerialPort.STOPBITS_1,//停止位-1
                   			SerialPort.PARITY_NONE);//校验-无
               
			}
			if(flag==1){
                   	Thread.sleep(1000);
                   	while(inputStream.available() > 0) {
                   		inputStream.read(readBuffer);
                   		buffer.append(new String(readBuffer).trim());//去除数据中间空格
                   		str1=buffer.toString();//将拼接的字符串转换成用于分离的字符串
                   		data=str1;
                   		buffer.delete(0, buffer.length());//清空字符串拼接缓存区
                   	}
			}
			inputStream.close();
			serialPort.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return data;
	}
	
	
	public static void main(String[] args) {
//		String wNum = new Dibang().weightNum();
//        String wData = "";
//        if(null != wNum){
////            String str = wNum.substring(wNum.indexOf("=")+2,wNum.indexOf("=")+8);
////            wData = Integer.valueOf(new StringBuffer(str).reverse().toString()).toString();
//        	System.out.println(wNum);
//        }
		List<String> li=findPorts();
		System.out.println(li.size());
		for(String name:li) {
			System.out.println(name);
		}
	}
	
	
	
}
