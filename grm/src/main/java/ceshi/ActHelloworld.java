package ceshi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.Task;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.junit.Test;





public class ActHelloworld {

	//我严重怀疑 虚拟货位只是为了Activity流程准备的
	
	
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();//默认从classpath下 找activiti.cfg.xml init()方法中写的有加载xml的文件名
	
//	SessionFactoryImplementor s
	@Test
	public void getPng() throws IOException {
		
		String deploymentId = "562501";
		List<String> names = processEngine.getRepositoryService()
				.getDeploymentResourceNames(deploymentId);
		for (String name : names) {
			System.out.println(name);
			InputStream in = processEngine.getRepositoryService()
					.getResourceAsStream(deploymentId, name);
			// 将文件保存到本地磁盘
			/*
			 * OutputStream out = new FileOutputStream(new File("d:\\" + name));
			 * byte[] b = new byte[1024]; int len = 0; while((len =
			 * in.read(b))!=-1) { out.write(b, 0, len); } out.close();
			 */
		
			 OutputStream out = new FileOutputStream(new File("D:\\" + name));
			 byte[] b = new byte[1024]; int len = 0;
			 while((len =in.read(b))!=-1) {
				 out.write(b, 0, len); 
			 }
			 out.close();
			 
			

		}
	}
	
	@Test
	public void test() {                                      //部署创建表
		org.activiti.engine.repository.Deployment dpt= processEngine.getRepositoryService().createDeployment().name("申请货位")//流程引擎 所有操作都要用
		.addClasspathResource("diagrams/workload.bpmn")
		.addClasspathResource("diagrams/workload.png")//注意这里产出的新流程是按照单独配置的的配置文件产出的 这点要注意
		.deploy();
		System.out.println(dpt.getName());
		System.out.println(dpt.getId());
		
		
	}
//	qingjia:2:475004 qingjia:3:480004
//	http://localhost:8080/grm/repository/process-definitions?key=paitaProcess&latest=true
	@Test
	public void testStart() {
		String processKey="paitaProcess";
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		processEngine.getIdentityService().setAuthenticatedUserId("老八");
		map.put("business", "18237488407");
		ProcessInstance pi=processEngine.getRuntimeService().startProcessInstanceById("paitaProcess:7:455004",map);
//		ProcessInstance pi=processEngine.getRuntimeService().startProcessInstanceByKey(processKey);
		System.out.println("流程实例ID:"+pi.getId());
		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());
	}
	
	
	
	@Test
	public void findMyPersonalTast() {
		
//		String user="ZHAO_LIU";//
		List<String> Canlist=new ArrayList<String>();
//		Canlist.add("ZHAO_LIU");
//		Canlist.add("TIAN_QI");//注意 这里 用户和用户组不能够共存
//		Canlist.add("NEW_DEBUG_HQ");//注意 这里 用户和用户组不能够共存
		Canlist.add("NEW_DEBUG_XZ");//注意 这里 用户和用户组不能够共存
		Canlist.add("NEW_DEBUG_ZJL");
//		List<org.activiti.engine.task.Task> list=processEngine.getTaskService().createTaskQuery().taskCandidateGroupIn(Canlist).list();
		List<org.activiti.engine.task.Task> list=processEngine.getTaskService().createTaskQuery().taskAssignee("toyla").list();
		System.out.println(list.size());
		
		
		
		if(list!=null) {
			if(list.size()>0) {
				System.out.println("有");
				for(org.activiti.engine.task.Task task:list) {
					System.out.println(task.getAssignee());
					System.out.println(task.getId());
					System.out.println(task.getName());
//					System.out.println(task.getVariable());
				}
			}
		}
	}
	
	
//	赵六
//	415005
//	货位申请
//	赵六
//	417509
//	货位申请
//	赵六
//	420005
//	货位申请
	
	
	@Test
	public void CommitTask() {
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("agree", false);
		
		String taskid="415005";
		processEngine.getTaskService().complete(taskid,map);
		System.out.println("完成任务ID:"+taskid);
	}
	
	
	public static void main(String[] args) throws IOException {
		new ActHelloworld().getPng();
	}
	
	
	
}
