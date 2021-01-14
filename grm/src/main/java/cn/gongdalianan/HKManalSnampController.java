//package cn.gongdalianan;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.haut.grm.model.ies.GrainTraffic;
//import com.haut.grm.model.ies.IesCameraImage;
//import com.haut.grm.model.ies.IesCameraRegistry;
//import com.haut.grm.repository.ies.IesCameraImageRepository;
//
//public class HKManalSnampController {
//
////	JniHKManalSnamp
//	
//	public static Map<String,List<Integer>> map=new HashMap<String,List<Integer>>();
//	static {
//		
//		System.loadLibrary("JniHKManalSnamp");
//		HKManalSnampController.capInit();
//		HKManalSnampController.setPicPath(null);
//	}
//	
//	
//
//	public static int myCaplogin(String ipaddress,String username,String password) {
//		if(map.containsKey(ipaddress)) {
//			return map.get(ipaddress).get(0);
//		}
//		int uid=HKManalSnampController.capLogin(ipaddress,username,password);
//		if(uid>=0) {
//			List<Integer> list=new ArrayList<Integer>();
//			list.add(uid);
//			map.put(ipaddress, list);
//		}
//		return uid;
//		
//	}
//	
//	public static void mySnampPicture(IesCameraRegistry cr, GrainTraffic gt,IesCameraImageRepository iesCameraImageRepository,int uid,String ipaddress) {
//		
//		
////		str:unsuc_0110_黄粤K26869_0110_testITSpic0_0_2020_9_29_21_01_06.jpg_0110_
////		str:unsuc_0110_黄粤K26869_0110_testITSpic0_0_2020_9_29_21_01_06.jpg_0110_
////		str:unsuc_0110_黄粤K26869_0110_testITSpic0_0_2020_9_29_21_01_06.jpg_0110_
////		str:suc_0110_黄粤K26869_0110_testITSpic0_0_2020_9_29_21_01_06.jpg_0110_testPicPlate1_3_2020_9_29_21_01_06.jpg
//		CallInter c=new CallInter() {
//
//			@Override
//			public void send(String str) {
//				
//				String[] strs=str.split("_0110_");
//				if(strs.length>=3) {
//					IesCameraImage image = new IesCameraImage();
//					image.setGrainTraffic(gt);
//					image.setRegistry(cr);
//					image.setImagePath(strs[2]);
//					iesCameraImageRepository.save(image);
//				}
//			}
//			
//		};
//		HKManalSnampController.myCallBack(c);
//		int bu=bufang(uid);
//		
//		if(map.containsKey(ipaddress)) {
//			List<Integer> list=map.get(ipaddress);
//			if(list.size()==1) {
//				
//			}
//		}
//		if(bu>=0) {
//			
//		}
//		
//		String str=capSnap(uid);
//		System.out.println(str);
//		capStart(uid);
//	}
//	
//	
//	
//	
//	public native static int myCallBack(CallInter call);
//	
//	
//	public native static String DebugString(String str);
//	
//	public native static int capInit();
//	
//	public native static int capLogin(String ip,String username,String password);
//	
//	
//	public native static int bufang(int uid);
//	
//	public native static int capStart(int uid);
//
//	public native static int chefang(int lHandle);
//	
//	public native static String capSnap(int uid);
//	
//	public native static void mylaout(int uid);
//	
//	public native static void releace();
//	
//	public native static int setPicPath(String path);//必须先设置文件夹 否则直接return;
//	
//	public static void main(String[] args) {
//		
//		capInit();
//		String disr=null;
//		
//		int i=setPicPath(disr);
//		System.out.println(i);
//		int uid=capLogin("192.168.1.64","admin","gd123456");
//		
//		CallInter c=new CallInter() {
//			
//			@Override
//			public void send(String str) {
//				System.out.println("str:"+str);
//			}
//		};
//		
//		HKManalSnampController.myCallBack(c);
//		
//		
//		int bu=bufang(uid);
//		String str=capSnap(uid);
//		System.out.println(str);
//		capStart(uid);
//		
//		
//		
//		
//		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(123);
//		chefang(bu);
//		mylaout(uid);
//		
//		releace();
//	}
//}
