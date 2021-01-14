package ceshi;

import java.util.HashMap;

import java.util.Map;

import com.haut.grm.model.DeviceCamera;
import com.haut.grm.model.ies.GrainTraffic;
import com.haut.grm.model.ies.IesCameraRegistry;
import com.haut.grm.model.ies.VehicleTraffic;
import com.haut.grm.repository.ies.IesCameraImageRepository;
import com.haut.grm.repository.ies.VehicleTrafficRepository;
import com.sun.jna.Pointer;

import alarmjavademo.FMSGCallBack_V31;
import alarmjavademo.FMSGCallBack_V32;
import alarmjavademo.HCNetSDK;
import alarmjavademo.HCNetSDK.NET_DVR_BARRIERGATE_CFG;




public class MyShoot {
	
	
	static {
		
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_Init();
		if(bo) {
			System.out.println("海康抓拍SDK初始化成功");
		}else {
			System.out.println("海康抓拍SDK初始化err");
		}
	}
	
	
//	public static FMSGCallBack_V31 fMSFCallBack_V31=null;
	
	
//	public static int myceshi=0;
	
	public static void myInit() {
		System.out.println("...");
	}
	
	
	public static Map<String,Map<String,Integer>> map=new HashMap<String,Map<String,Integer>>();
	
	
	
	
//	IesCameraRegistry cr, GrainTraffic gt,IesCameraImageRepository iesCameraImageRepository,int uid,String ipaddress


	
	
	
	
	
	public static int myLogin(String ipaddress,String port,String username,String password) {
		
		if(map.containsKey(ipaddress)) {
			return map.get(ipaddress).get("lUserID");
		}
		
		
		HCNetSDK.NET_DVR_USER_LOGIN_INFO m_strLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();//设备登录信息
		HCNetSDK.NET_DVR_DEVICEINFO_V40 m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();//设备信息
		
		String m_sDeviceIP = ipaddress;//设备ip地址  
        m_strLoginInfo.sDeviceAddress = new byte[HCNetSDK.NET_DVR_DEV_ADDRESS_MAX_LEN];
        System.arraycopy(m_sDeviceIP.getBytes(), 0, m_strLoginInfo.sDeviceAddress, 0, m_sDeviceIP.length());
        
        String m_sUsername = username;//设备用户名
        m_strLoginInfo.sUserName = new byte[HCNetSDK.NET_DVR_LOGIN_USERNAME_MAX_LEN];
        System.arraycopy(m_sUsername.getBytes(), 0, m_strLoginInfo.sUserName, 0, m_sUsername.length());
        
        String m_sPassword = password;//设备密码
        m_strLoginInfo.sPassword = new byte[HCNetSDK.NET_DVR_LOGIN_PASSWD_MAX_LEN];
        System.arraycopy(m_sPassword.getBytes(), 0, m_strLoginInfo.sPassword, 0, m_sPassword.length());
        
        m_strLoginInfo.wPort = (short)Integer.parseInt(port);
        
        m_strLoginInfo.bUseAsynLogin = false; //是否异步登录：0- 否，1- 是
        
        m_strLoginInfo.write();
        
        
        int lUserID = HCNetSDK.INSTANCE.NET_DVR_Login_V40(m_strLoginInfo, m_strDeviceInfo);

        if(lUserID>=0) {
        	
        	Map m1=new HashMap<String,Integer>();
			m1.put("lUserID", lUserID);
			map.put(ipaddress, m1);
		}
		return lUserID;
	}
	
//	VehicleTraffic vt=null;
//	VehicleTrafficRepository myvtRe=null;
	public static void myShoot(IesCameraRegistry cr, GrainTraffic gt,IesCameraImageRepository iesCameraImageRepository,int lUserID,String ipaddress,String path,VehicleTraffic vt,VehicleTrafficRepository myvtRe,DeviceCamera camera) {
		
		if(!map.containsKey(ipaddress)) {
			System.out.println("myShoot未包含该ip");
			return;
		}
		Map<String,Integer> m1=map.get(ipaddress);
		int lAlarmHandle=-1;
		if(!m1.containsKey("lAlarmHandle")) {
			//设防
			HCNetSDK.NET_DVR_SETUPALARM_PARAM m_strAlarmInfo = new HCNetSDK.NET_DVR_SETUPALARM_PARAM();
	        m_strAlarmInfo.dwSize=m_strAlarmInfo.size();
	        m_strAlarmInfo.byLevel=1;//智能交通布防优先级：0- 一等级（高），1- 二等级（中），2- 三等级（低）
	        m_strAlarmInfo.byAlarmInfoType=1;//智能交通报警信息上传类型：0- 老报警信息（NET_DVR_PLATE_RESULT），1- 新报警信息(NET_ITS_PLATE_RESULT)
	        m_strAlarmInfo.byDeployType =1; //布防类型(仅针对门禁主机、人证设备)：0-客户端布防(会断网续传)，1-实时布防(只上传实时数据)
	        m_strAlarmInfo.write();
	        lAlarmHandle = HCNetSDK.INSTANCE.NET_DVR_SetupAlarmChan_V41(lUserID, m_strAlarmInfo);
	        if(lAlarmHandle<0) {
	        	System.out.println("布防失败");
	        	return;
	        }
	        m1.put("lAlarmHandle", lAlarmHandle);
		}else {
			lAlarmHandle=m1.get("lAlarmHandle");
		}
		
		
        
        //设置回调函数
        //后期根据不同的ipaddress 设置不同的逻辑  尽可能少的设置回调函数
		FMSGCallBack_V31 fMSFCallBack_V31= new FMSGCallBack_V31(cr, gt, iesCameraImageRepository, 1, null,path,vt,myvtRe,camera);
		
		Pointer pUser = null;
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_SetDVRMessageCallBack_V31(fMSFCallBack_V31, pUser);
		System.out.println(bo);
		if(!bo) {
			System.out.println("回调函数设置失败");
			return;
		}
		
		
		
//		开始抓拍
		HCNetSDK.NET_DVR_SNAPCFG struSnapCfg = new HCNetSDK.NET_DVR_SNAPCFG();
        struSnapCfg.dwSize=struSnapCfg.size();
        struSnapCfg.bySnapTimes =1;
        struSnapCfg.wSnapWaitTime =1000;
        struSnapCfg.write();

        bo = HCNetSDK.INSTANCE.NET_DVR_ContinuousShoot(lUserID, struSnapCfg);
		System.out.println("抓拍:"+bo);
		
	}
	
	
	
	
	public static void myShootCeshi(String ipaddress,String port,String username,String password) {
		
		
		
		int lAlarmHandle=-1;
		
		
		HCNetSDK.NET_DVR_USER_LOGIN_INFO m_strLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();//设备登录信息
		HCNetSDK.NET_DVR_DEVICEINFO_V40 m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();//设备信息
		
		String m_sDeviceIP = ipaddress;//设备ip地址  
        m_strLoginInfo.sDeviceAddress = new byte[HCNetSDK.NET_DVR_DEV_ADDRESS_MAX_LEN];
        System.arraycopy(m_sDeviceIP.getBytes(), 0, m_strLoginInfo.sDeviceAddress, 0, m_sDeviceIP.length());
        
        String m_sUsername = username;//设备用户名
        m_strLoginInfo.sUserName = new byte[HCNetSDK.NET_DVR_LOGIN_USERNAME_MAX_LEN];
        System.arraycopy(m_sUsername.getBytes(), 0, m_strLoginInfo.sUserName, 0, m_sUsername.length());
        
        String m_sPassword = password;//设备密码
        m_strLoginInfo.sPassword = new byte[HCNetSDK.NET_DVR_LOGIN_PASSWD_MAX_LEN];
        System.arraycopy(m_sPassword.getBytes(), 0, m_strLoginInfo.sPassword, 0, m_sPassword.length());
        
        m_strLoginInfo.wPort = (short)Integer.parseInt(port);
        
        m_strLoginInfo.bUseAsynLogin = false; //是否异步登录：0- 否，1- 是
        
        m_strLoginInfo.write();
        
        
        int lUserID = HCNetSDK.INSTANCE.NET_DVR_Login_V40(m_strLoginInfo, m_strDeviceInfo);
        
        
//        设防
        
        
        
        
        HCNetSDK.NET_DVR_SETUPALARM_PARAM m_strAlarmInfo = new HCNetSDK.NET_DVR_SETUPALARM_PARAM();
        m_strAlarmInfo.dwSize=m_strAlarmInfo.size();
        m_strAlarmInfo.byLevel=1;//智能交通布防优先级：0- 一等级（高），1- 二等级（中），2- 三等级（低）
        m_strAlarmInfo.byAlarmInfoType=1;//智能交通报警信息上传类型：0- 老报警信息（NET_DVR_PLATE_RESULT），1- 新报警信息(NET_ITS_PLATE_RESULT)
        m_strAlarmInfo.byDeployType =1; //布防类型(仅针对门禁主机、人证设备)：0-客户端布防(会断网续传)，1-实时布防(只上传实时数据)
        m_strAlarmInfo.write();
        lAlarmHandle = HCNetSDK.INSTANCE.NET_DVR_SetupAlarmChan_V41(lUserID, m_strAlarmInfo);
        
        if(lAlarmHandle<0) {
        	System.out.println("布防失败");
        	return;
        }
        
        
        
        FMSGCallBack_V32 fMSFCallBack_V32= new FMSGCallBack_V32();
        
        Pointer pUser = null;
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_SetDVRMessageCallBack_V31(fMSFCallBack_V32, pUser);
		System.out.println(bo);
		if(!bo) {
			System.out.println("回调函数设置失败");
			return;
		}
		
		
		
		
//		开始抓拍
		HCNetSDK.NET_DVR_SNAPCFG struSnapCfg = new HCNetSDK.NET_DVR_SNAPCFG();
        struSnapCfg.dwSize=struSnapCfg.size();
        struSnapCfg.bySnapTimes =1;
        struSnapCfg.wSnapWaitTime =1000;
        struSnapCfg.write();

        bo = HCNetSDK.INSTANCE.NET_DVR_ContinuousShoot(lUserID, struSnapCfg);
		System.out.println("抓拍:"+bo);
        
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		
//
//		int lUserID =myLogin("192.168.1.64", "8000", "admin", "gd123456");
//		System.out.println("lUserID:"+lUserID);
//		
//		
//		
//		myShoot(null, null,null,lUserID,"192.168.1.64");
//		
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//    
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	 public int dwSize;
//     public int dwChannel; //通道号
//     public byte byLaneNo;  //道闸号（0-表示无效值(设备需要做有效值判断),1-道闸1）
//   /*
//   若老的平台不支持byUnlock字段，该字段将赋值为0，通过“0-关闭道闸,1-开启道闸,2-停止道闸”中的任何一种操作皆可进行解锁。
//   若新平台支持byUnlock字段，需byUnlock字段赋值为1，并结合4~解锁道闸来进行解锁。byUnlock字段赋值为1后，“0-关闭道闸,1-开启道闸,2-停止道闸”操作将不可用于解锁。
//   */
//     public byte byBarrierGateCtrl;//0-关闭道闸,1-开启道闸,2-停止道闸 3-锁定道闸,4~解锁道闸
//     public byte byEntranceNo;//出入口编号 [1,8]
//     public byte byUnlock;//启用解锁使能，0~为不启用，1~启用
//     public byte[] byRes = new byte[12];
	
	public static void daoZhaControllerLock(int lUserID) {

		NET_DVR_BARRIERGATE_CFG daozha=new NET_DVR_BARRIERGATE_CFG();
		daozha.dwSize=daozha.size();
		daozha.dwChannel=1;//通道号
		daozha.byLaneNo=1;//道闸号（0-表示无效值(设备需要做有效值判断),1-道闸1）
		daozha. byBarrierGateCtrl=3;
		daozha.byUnlock=1;
		daozha.write();//类似memset
		
		int dwCommand=3128;
		
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_RemoteControl(lUserID, dwCommand, daozha.getPointer(), daozha.size());
		System.out.println(bo);
	}
	
	
	public static void daoZhaControllerOpen(int lUserID) {

		NET_DVR_BARRIERGATE_CFG daozha=new NET_DVR_BARRIERGATE_CFG();
		daozha.dwSize=daozha.size();
		daozha.dwChannel=1;//通道号
		daozha.byLaneNo=1;//道闸号（0-表示无效值(设备需要做有效值判断),1-道闸1）
		daozha. byBarrierGateCtrl=1;
		daozha.byUnlock=1;
		daozha.write();//类似memset
		
		int dwCommand=3128;
		
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_RemoteControl(lUserID, dwCommand, daozha.getPointer(), daozha.size());
		System.out.println(bo);
	}
	
	
	public static void daoZhaControllerClose(int lUserID) {

		NET_DVR_BARRIERGATE_CFG daozha=new NET_DVR_BARRIERGATE_CFG();
		daozha.dwSize=daozha.size();
		daozha.dwChannel=1;//通道号
		daozha.byLaneNo=1;//道闸号（0-表示无效值(设备需要做有效值判断),1-道闸1）
		daozha. byBarrierGateCtrl=0;
		daozha.byUnlock=1;
		daozha.write();//类似memset
		
		int dwCommand=3128;
		
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_RemoteControl(lUserID, dwCommand, daozha.getPointer(), daozha.size());
		System.out.println(bo);
	}
	
	
	public static void daoZhaControllerUnLock(int lUserID) {

		NET_DVR_BARRIERGATE_CFG daozha=new NET_DVR_BARRIERGATE_CFG();
		daozha.dwSize=daozha.size();
		daozha.dwChannel=1;//通道号
		daozha.byLaneNo=1;//道闸号（0-表示无效值(设备需要做有效值判断),1-道闸1）
		daozha. byBarrierGateCtrl=4;
		daozha.byUnlock=1;
		daozha.write();//类似memset
		
		int dwCommand=3128;
		
		boolean bo=HCNetSDK.INSTANCE.NET_DVR_RemoteControl(lUserID, dwCommand, daozha.getPointer(), daozha.size());
		System.out.println(bo);
	}
	
	
	
	
	public static void main(String[] args) {
		int lUserID =myLogin("192.168.20.13", "8000", "admin", "gd123456");
		System.out.println("lUserID:"+lUserID);
		daoZhaControllerLock(lUserID);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		daoZhaControllerUnLock(lUserID);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		daoZhaControllerClose(lUserID);
		daoZhaControllerClose(lUserID);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		myShootCeshi("192.168.20.21", "8000", "admin", "gd123456");
		
		try {
			Thread.sleep(20000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
