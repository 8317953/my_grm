package alarmjavademo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.haut.grm.model.DeviceCamera;
import com.haut.grm.model.ies.GrainTraffic;
import com.haut.grm.model.ies.IesCameraImage;
import com.haut.grm.model.ies.IesCameraRegistry;
import com.haut.grm.model.ies.VehicleTraffic;
import com.haut.grm.repository.ies.IesCameraImageRepository;
import com.haut.grm.repository.ies.VehicleTrafficRepository;
import com.sun.jna.Pointer;

import ceshi.Base64;

public class FMSGCallBack_V31 implements HCNetSDK.FMSGCallBack_V31 {

	
	//自定义参数
	private IesCameraRegistry cr;
	private GrainTraffic gt;
	private IesCameraImageRepository iesCameraImageRepository;
	private int uid;
	private String ipaddress;
	private String path;
	private VehicleTraffic vt;
	private VehicleTrafficRepository myvtRe;
	private DeviceCamera camera;
	
	
	
	public FMSGCallBack_V31(IesCameraRegistry cr, GrainTraffic gt,IesCameraImageRepository iesCameraImageRepository,int uid,String ipaddress,String path,VehicleTraffic vt,VehicleTrafficRepository myvtRe,DeviceCamera camera) {
		this.cr=cr;
		this.gt=gt;
		this.iesCameraImageRepository=iesCameraImageRepository;
		this.uid=uid;
		this.ipaddress=ipaddress;
		this.path=path;
		this.vt=vt;
		this.myvtRe=myvtRe;
		this.camera=camera;
	}
    //报警信息回调函数

    public boolean invoke(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser)
    {
        AlarmDataHandle(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
        return true;
    }
    
    
    public void AlarmDataHandle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser)
    {
        switch (lCommand)
        {
            case HCNetSDK.COMM_ITS_PLATE_RESULT:
                HCNetSDK.NET_ITS_PLATE_RESULT strItsPlateResult = new HCNetSDK.NET_ITS_PLATE_RESULT();
                strItsPlateResult.write();
                Pointer pItsPlateInfo = strItsPlateResult.getPointer();
                pItsPlateInfo.write(0, pAlarmInfo.getByteArray(0, strItsPlateResult.size()), 0, strItsPlateResult.size());
                strItsPlateResult.read();
                try {
                    String srt3=new String(strItsPlateResult.struPlateInfo.sLicense,"GBK");
//                    sAlarmType = sAlarmType + ",车辆类型："+strItsPlateResult.byVehicleType + ",交通抓拍上传，车牌："+ srt3;
                    System.out.println(srt3);
                }
                catch (UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
           

                for(int i=0;i<strItsPlateResult.dwPicNum;i++)
                {
                    if(strItsPlateResult.struPicInfo[i].dwDataLen>0&&strItsPlateResult.struPicInfo[i].byType==1)//0是车牌照片暂时不需要
                    {
                        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
                        String newName = sf.format(new Date());
                        FileOutputStream fout;
                        try {
//                        	"mypic\\"+
                        	String filename1 = new String(pAlarmer.sDeviceIP).trim() + "_"
                                    + newName+"_type["+strItsPlateResult.struPicInfo[i].byType+"]_ItsPlate.jpg";
                            String filename =path+ filename1;
                            
                            System.out.println("filename:"+filename);
                            fout = new FileOutputStream(filename);
                            //将字节写入文件
                            long offset = 0;
                            ByteBuffer buffers = strItsPlateResult.struPicInfo[i].pBuffer.getByteBuffer(offset, strItsPlateResult.struPicInfo[i].dwDataLen);
                            byte [] bytes = new byte[strItsPlateResult.struPicInfo[i].dwDataLen];
                            buffers.rewind();
                            buffers.get(bytes);
                            fout.write(bytes);
                            fout.close();
                            
                            
//                            存储照片信息
                            
                            if(gt!=null&&cr!=null&&iesCameraImageRepository!=null) {
                            	IesCameraImage image = new IesCameraImage();
            					image.setGrainTraffic(gt);
            					image.setRegistry(cr);
            					image.setImagePath(filename1);
            					iesCameraImageRepository.save(image);
            					if(vt!=null&&myvtRe!=null&&this.camera!=null) {
            						vt.setIn(Boolean.valueOf(true));
            						vt.setInTime(new Date());
            						InputStream mystream=new FileInputStream(filename);
            						byte[] data = new byte[mystream.available()];
            						mystream.read(data);
            						mystream.close();
            						
            						vt.setImage(data);
            						vt.setCamera(camera);
            						myvtRe.save(vt);
            					}
                            }
                            
                            
                            
                            
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                break;
            default:
                break;
        }
        
        setNull();
    }
    
    
    
    
    
    public void setNull() {
    	this.cr=null;
		this.gt=null;
		this.iesCameraImageRepository=null;
		this.uid=-1;
		this.ipaddress=null;
		this.path=null;
		this.vt=null;
		this.myvtRe=null;
    }
    
}
