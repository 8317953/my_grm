package ceshi;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.msg.WriteCoilRequest;
import com.serotonin.modbus4j.msg.WriteCoilResponse;
import com.serotonin.modbus4j.msg.WriteCoilsRequest;
import com.serotonin.modbus4j.msg.WriteCoilsResponse;
import com.serotonin.modbus4j.serial.SerialPortWrapper;

/**
 * modbus通讯工具类,采用modbus4j实现
 * 
 * @author lxq
 * @dependencies modbus4j-3.0.3.jar
 * @website https://github.com/infiniteautomation/modbus4j
 */
public class Modbus4jUtils {
	/**
	 * 工厂。
	 */
	static ModbusFactory modbusFactory;
	static {
		if (modbusFactory == null) {
			modbusFactory = new ModbusFactory();
		}
	}

	/**
	 * 获取master
	 * 
	 * @return
	 * @throws ModbusInitException
	 */
	public static ModbusMaster getMaster() throws ModbusInitException {
		IpParameters params = new IpParameters();
		params.setHost("192.168.10.13");
		params.setPort(502);
		//
		// modbusFactory.createRtuMaster(wapper); //RTU 协议
		// modbusFactory.createUdpMaster(params);//UDP 协议
		// modbusFactory.createAsciiMaster(wrapper);//ASCII 协议
		ModbusMaster master = modbusFactory.createTcpMaster(params, false);// TCP 协议
		master.init();
		
		return master;
	}
	
	
	public static ModbusMaster getMaster(String ip,int port) throws ModbusInitException {
		IpParameters params = new IpParameters();
		params.setHost(ip);
		params.setPort(port);
		//
		// modbusFactory.createRtuMaster(wapper); //RTU 协议
		// modbusFactory.createUdpMaster(params);//UDP 协议
		// modbusFactory.createAsciiMaster(wrapper);//ASCII 协议
		ModbusMaster master = modbusFactory.createTcpMaster(params, false);// TCP 协议
		master.init();


		return master;
	}
	
	
	
	public static ModbusMaster getMasterCom(String comName,int baudrate) {
		

		SerialPortWrapperImpl spw=new SerialPortWrapperImpl(comName, baudrate);
		ModbusMaster master =modbusFactory.createRtuMaster(spw);
		try {
			master.init();
			return master;
		} catch (ModbusInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	

	/**
	 * 读取[01 Coil Status 0x]类型 开关数据
	 * 
	 * @param slaveId
	 *            slaveId
	 * @param offset
	 *            位置
	 * @return 读取值
	 * @throws ModbusTransportException
	 *             异常
	 * @throws ErrorResponseException
	 *             异常
	 * @throws ModbusInitException
	 *             异常
	 */
	public static Boolean readCoilStatus(int slaveId, int offset)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 01 Coil Status
		BaseLocator<Boolean> loc = BaseLocator.coilStatus(slaveId, offset);
		Boolean value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 读取[02 Input Status 1x]类型 开关数据
	 * 
	 * @param slaveId
	 * @param offset
	 * @return
	 * @throws ModbusTransportException
	 * @throws ErrorResponseException
	 * @throws ModbusInitException
	 */
	public static Boolean readInputStatus(int slaveId, int offset)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 02 Input Status
		BaseLocator<Boolean> loc = BaseLocator.inputStatus(slaveId, offset);
		Boolean value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 读取[03 Holding Register类型 2x]模拟量数据
	 * 
	 * @param slaveId
	 *            slave Id
	 * @param offset
	 *            位置
	 * @param dataType
	 *            数据类型,来自com.serotonin.modbus4j.code.DataType
	 * @return
	 * @throws ModbusTransportException
	 *             异常
	 * @throws ErrorResponseException
	 *             异常
	 * @throws ModbusInitException
	 *             异常
	 */
	public static Number readHoldingRegister(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 03 Holding Register类型数据读取
		BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
		Number value = getMaster().getValue(loc);
		return value;
	}

	/**
	 * 读取[04 Input Registers 3x]类型 模拟量数据
	 * 
	 * @param slaveId
	 *            slaveId
	 * @param offset
	 *            位置
	 * @param dataType
	 *            数据类型,来自com.serotonin.modbus4j.code.DataType
	 * @return 返回结果
	 * @throws ModbusTransportException
	 *             异常
	 * @throws ErrorResponseException
	 *             异常
	 * @throws ModbusInitException
	 *             异常
	 */
	public static Number readInputRegisters(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 04 Input Registers类型数据读取
		BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
		Number value = getMaster().getValue(loc);
		return value;
	}
	
	public static Number readInputRegisters2(int slaveId, int offset, int dataType)
			throws ModbusTransportException, ErrorResponseException, ModbusInitException {
		// 04 Input Registers类型数据读取
		BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
		Number value = getMasterCom("COM4",9600).getValue(loc);
		return value;
	}
	

	/**
	 * 批量读取使用方法
	 * 
	 * @throws ModbusTransportException
	 * @throws ErrorResponseException
	 * @throws ModbusInitException
	 */
	public static void batchRead() throws ModbusTransportException, ErrorResponseException, ModbusInitException {

		BatchRead<Integer> batch = new BatchRead<Integer>();

		batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
		batch.addLocator(1, BaseLocator.inputStatus(1, 0));

		ModbusMaster master = getMaster();

		batch.setContiguousRequests(false);
		BatchResults<Integer> results = master.send(batch);
		System.out.println(results.getValue(0));
		System.out.println(results.getValue(1));
	}
	
	
	
	
	
	public static void writeColid() throws ModbusTransportException, ModbusInitException {
		
		boolean[] bos=new boolean[1];
		bos[0]=true;
		
		WriteCoilsRequest wcr=new WriteCoilsRequest(1,2055,bos);
		WriteCoilsResponse  response = (WriteCoilsResponse) getMaster().send(wcr);
		if (response.isException()) {
            System.out.println("异常消息:" + response.getExceptionMessage());
        } else {
            System.out.println("写入成功");
        }
	}
	
	
	
	private static void readHoldingRegistersTest(ModbusMaster master, int slaveId, int start, int len) {
        try {
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, start, len);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
            if (response.isException()) {
                System.out.println("异常消息:" + response.getExceptionMessage());
            } else {
                System.out.println(Arrays.toString(response.getShortData()));
                short[] list = response.getShortData();
                for (int i = 0; i < list.length; i++) {
                    System.out.print(list[i] + " ");
                }
            }
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        }
    }
	
	
	
	

	/**
	 * 测试
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		try {
//			// 01测试
//			Boolean v011 = readCoilStatus(1, 0);
//			Boolean v012 = readCoilStatus(1, 1);
//			Boolean v013 = readCoilStatus(1, 6);
//			System.out.println("v011:" + v011);
//			System.out.println("v012:" + v012);
//			System.out.println("v013:" + v013);
////			// 02测试
////			Boolean v021 = readInputStatus(1, 0);
////			Boolean v022 = readInputStatus(1, 1);
////			Boolean v023 = readInputStatus(1, 2);
////			System.out.println("v021:" + v021);
////			System.out.println("v022:" + v022);
////			System.out.println("v023:" + v023);
////
////			// 03测试
////			Number v031 = readHoldingRegister(1, 1, DataType.FOUR_BYTE_FLOAT);// 注意,float
////			Number v032 = readHoldingRegister(1, 3, DataType.FOUR_BYTE_FLOAT);// 同上
////			System.out.println("v031:" + v031);
////			System.out.println("v032:" + v032);
////
////			// 04测试
////			Number v041 = readInputRegisters(1, 0, DataType.FOUR_BYTE_FLOAT);//
////			Number v042 = readInputRegisters(1, 2, DataType.FOUR_BYTE_FLOAT);//
////			System.out.println("v041:" + v041);
////			System.out.println("v042:" + v042);
////			// 批量读取
////			batchRead();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	

	
	public static void main(String[] args) {
//		try {
//			Number v041 = readHoldingRegister(1, 4096, DataType.FOUR_BYTE_FLOAT);
//			Number v042 = readHoldingRegister(1, 4108, DataType.FOUR_BYTE_FLOAT);//
//			Number v043 = readHoldingRegister(1, 4109, DataType.FOUR_BYTE_FLOAT);//
//			Number v044 = readHoldingRegister(1, 4110, DataType.FOUR_BYTE_FLOAT);//
//			System.out.println("v041:" + v041.intValue());
//			System.out.println("v042:" + v042);
//			System.out.println("v043:" + v043);
//			System.out.println("v044:" + v044);
//		} catch (ModbusTransportException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ErrorResponseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ModbusInitException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//
		
		try {
			writeColid();
		} catch (ModbusTransportException | ModbusInitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			readHoldingRegistersTest(getMaster(),1,4107,4);
		} catch (ModbusInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}