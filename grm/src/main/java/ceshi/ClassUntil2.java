package ceshi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.Nhdata;
import com.haut.grm.model.QtCdModel;
import com.haut.grm.model.QtSj;

import io.swagger.annotations.ApiOperation;
import javassist.bytecode.stackmap.TypeData.ClassName;




public class ClassUntil2 {
	
	private static String driver =  "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/grm_self";	//数据源(mysql)的连接地址
	static String user = "root";	//用户名
	static String password = "123456";	//用户密码
	
//	static String[] attributes=null;
	
	static String[] attributes=new String[] {"store.id*Long,s"};
	
	
	
	static String tablename="qt_fm_model";
	//static String tablename=null;
	
	static String className="QtCdModel";
//    static String className=null;
	
	static String objName=null;
	
	static List<ZiDuan> list=new ArrayList<ZiDuan>();
	
	public static String desUrl="C:\\Users\\19601\\Desktop\\";
	
	static {
		getClassName();
		list=main1();
//		System.out.println("col size:"+list.size());
		System.out.println("classname:"+className);
	}
	
	public  static List<ZiDuan> main1() {
		if(tablename==null) {
			return null;
		}
		Connection conn = null;
        Statement stmt = null;
		
		try {
			
			
			Class.forName(driver);
			System.out.println("连接数据库...");
	        conn = DriverManager.getConnection(url, user, password);
	        
	        
//	        System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
        
            String sql = "SELECT * FROM "+tablename;
            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//            	
//            	
//            	
//                // 通过字段检索
//                int id  = rs.getInt("id");
//                String name = rs.getString("name");
//                String url = rs.getString("url");
//    
//                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", 站点名称: " + name);
//                System.out.print(", 站点 URL: " + url);
//                System.out.print("\n");
//            }
            
            
            ResultSetMetaData data = rs.getMetaData();
            List<ZiDuan> li=new ArrayList<ZiDuan>();
            for (int i = 1; i <= data.getColumnCount(); i++) {
            	
            	// 获得指定列的列名
            	String columnName = data.getColumnName(i);
            	
            	// 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);
                
//                System.out.println("字段:"+columnName+","+columnTypeName);
                ZiDuan z=new ZiDuan();
                z.columnName=columnName;
                z.columnTypeName=columnTypeName;
                li.add(z);
            }
            return li;
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // 打开链接
        return null;
	}
	
	
	public static void getClassName() {
		String str=null;
		if(tablename!=null) {
			str=tablename.replace("_", "");
//			objName=str;
			String a=(str.charAt(0)+"").toUpperCase();
			str=str.substring(1,str.length());
			str=a+str;
		}
		
		if(className==null&&str!=null) {
			className=str;
		}
		if(className!=null) {
			objName=className.toLowerCase();
		}
		
	}
	
	
	
	
	
	public static void outClass() throws IOException {
		if(className==null) {
			return;
		}
		File file=new File(desUrl+"outclass");
		boolean bo=file.exists();
		if(!bo) {
			bo=file.mkdir();
		}
		if(bo) {
			file=new File(desUrl+"outclass\\model");
			if(!file.exists()) {
				file.mkdir();
			}
			outModelClass();
			file=new File(desUrl+"outclass\\repository");
			if(!file.exists()) {
				file.mkdir();
			}
			outRepositoryClass();
			file=new File(desUrl+"outclass\\datatables");
			if(!file.exists()) {
				file.mkdir();
			}
			outDatablesClass();
			file=new File(desUrl+"outclass\\service");
			if(!file.exists()) {
				file.mkdir();
			}
			outServiceClass();
			file=new File(desUrl+"outclass\\controller");
			if(!file.exists()) {
				file.mkdir();
			}
			outControllerClass();
			outViewClass();
			System.out.println("完成");
		}
	}
	
	
	
	
	
	public static void outViewClass() throws IOException {
		
		if(className.endsWith("type")) {
			return;
		}
		
		File file=new File("src\\main\\java\\com\\haut\\grm\\json\\view\\"+"Views.java");
		
		BufferedReader in=new BufferedReader(new FileReader(file));
		String line=null;
		line=in.readLine();
		
		String strRe="";
		while (line!=null) {
			strRe=strRe+line+"\r\n";
			line=in.readLine();
			if(line!=null) {
				if(line.contains("//"+className+"View")) {
					in.close();
					return;
				}
				if(line.contains("//end")) {
					System.out.println(line);
					
					String myView="	//"+className+"View\r\n" + 
							"	public static interface "+className+"View extends com.haut.grm.json.view.Views.IdView {\r\n" + 
							"    }\r\n" + 
							"	\r\n" + 
							"	public static interface "+className+"DatableView extends com.haut.grm.json.view.Views."+className+"View, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View{\r\n" + 
							"		\r\n" + 
							"	}\r\n" + 
							"	//end\r\n" + 
							"	";
					line=myView;
				}
			}
			
		}
		
		System.out.println(strRe);
		
		in.close();
		
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
//		
//		String result=null;
//		
//		String orginStr="package com.haut.grm.json.view;\r\n" + 
//				"\r\n" + 
//				"public class Views {\r\n" + 
//				"\r\n" + 
//				"    public static interface **classname**View extends com.haut.grm.json.view.Views.IdView {\r\n" + 
//				"    }\r\n" + 
//				"	\r\n" + 
//				"	public static interface **classname**DatableView extends com.haut.grm.json.view.Views.**classname**View, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View{\r\n" + 
//				"		\r\n" + 
//				"	}\r\n" + 
//				"\r\n" + 
//				"}";
//
//		
//		result=orginStr.replace("**classname**", className).replace("**objname**", objName);
		bw.write(strRe);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	public static void outSearchClass(File file,String insert) throws IOException {
		
		if(className.endsWith("type")) {
			return;
		}
		
		BufferedReader in=new BufferedReader(new FileReader(file));
		String line=null;
		line=in.readLine();
		
		String strRe="";
		while (line!=null) {
			strRe=strRe+line+"\r\n";
			line=in.readLine();
			if(line!=null) {
				for(String att:attributes) {
					if(line.contains("//"+att)) {
						in.close();
						System.out.println("含有已写过的标识符");
						return;
					}
				}
				if(line.contains("//end")) {
					System.out.println(line);
					
					
					line=insert;
				}
			}
			
		}
		
		System.out.println(strRe);
		
		in.close();
		
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);

		bw.write(strRe);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void outControllerClass() throws IOException {
		
		if(className.endsWith("type")) {
			return;
		}
		
		File file=new File("src\\main\\java\\com\\haut\\grm\\controller\\"+className+"Controller.java");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
		
		String result=null;
		
		String orginStr="package com.haut.grm.controller;\r\n" + 
				"\r\n" + 
				"import java.text.SimpleDateFormat;\r\n" + 
				"import java.util.Date;\r\n" + 
				"import java.util.List;\r\n" + 
				"import java.util.Set;\r\n" + 
				"\r\n" + 
				"import javax.validation.Valid;\r\n" + 
				"\r\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
				"import org.springframework.data.jpa.datatables.mapping.DataTablesInput;\r\n" + 
				"import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;\r\n" + 
				"import org.springframework.web.bind.annotation.PathVariable;\r\n" + 
				"import org.springframework.web.bind.annotation.RequestBody;\r\n" + 
				"import org.springframework.web.bind.annotation.RequestMapping;\r\n" + 
				"import org.springframework.web.bind.annotation.RequestMethod;\r\n" + 
				"import org.springframework.web.bind.annotation.RestController;\r\n" + 
				"\r\n" + 
				"import com.fasterxml.jackson.annotation.JsonView;\r\n" + 
				"import com.haut.grm.json.view.Views;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.**classname**;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.service.**classname**Service;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"import io.swagger.annotations.Api;\r\n" + 
				"import io.swagger.annotations.ApiOperation;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@Api(tags=\"\")\r\n" + 
				"@RestController\r\n" + 
				"public class **classname**Controller {\r\n" + 
				"	\r\n" + 
				"	@Autowired\r\n" + 
				"	private **classname**Service **objname**Service;\r\n" + 
				"\r\n" + 
				"	\r\n" + 
				"	@ApiOperation(value = \"\")\r\n" + 
				"	@RequestMapping(value={\"/v1/save**objname**\"}, method={RequestMethod.PUT})\r\n" + 
				"	public void save**classname**(@RequestBody **classname** **objname**) {\r\n" + 
				"		**objname**Service.save**classname**(**objname**);\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	@ApiOperation(value = \"\")\r\n" + 
				"	@RequestMapping(value={\"/v1/find**objname**ById/{**objname**Id}\"}, method={RequestMethod.GET})\r\n" + 
				"	@JsonView({Views.**classname**View.class})\r\n" + 
				"	public **classname** get**classname**ById(@PathVariable(\"**objname**Id\") Long **objname**Id){\r\n" + 
				"		return **objname**Service.get**classname**ById(**objname**Id);\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	@ApiOperation(value = \"\")\r\n" + 
				"	@RequestMapping(value={\"/v1/del**objname**/{**objname**Id}\"}, method={RequestMethod.DELETE})\r\n" + 
				"	public void Delete**classname**ById(@PathVariable(\"**objname**Id\") Long **objname**Id){\r\n" + 
				"		**objname**Service.delete**classname**ById(**objname**Id);\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"\r\n" + 
				"	@ApiOperation(value = \"\")\r\n" + 
				"	@RequestMapping(value={\"/v1/getall/**objname**\"}, method={RequestMethod.GET})\r\n" + 
				"	@JsonView({Views.**classname**View.class})\r\n" + 
				"	public List<**classname**> getAll**classname**s(){\r\n" + 
				"		return **objname**Service.getAll**classname**s();\r\n" + 
				"\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	@RequestMapping(value={\"/get/data/all/**objname**\"}, method={RequestMethod.GET})\r\n" + 
				"	@JsonView({Views.**classname**DatableView.class})\r\n" + 
				"	public DataTablesOutput<**classname**> getAllData**classname**s(@Valid DataTablesInput input){\r\n" + 
				"		return **objname**Service.getAll**classname**Table(input);\r\n" + 
				"\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"\r\n" + 
				"	\r\n"  +
				"    //end\r\n" +
				"}";

		
		result=orginStr.replace("**classname**", className).replace("**objname**", objName);
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	
	public static void outServiceClass() throws IOException {
		
		if(className.endsWith("type")) {
			return;
		}
		
		File file=new File("src\\main\\java\\com\\haut\\grm\\service\\"+className+"Service.java");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
		
		String result=null;
		
		String orginStr="package com.haut.grm.service;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.datatables.repository.**classname**DataTablesRepository;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.Q**classname**;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.**classname**;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"import com.haut.grm.repository.**classname**Repository;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"import java.util.List;\r\n" + 
				"\r\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
				"import org.springframework.data.jpa.datatables.mapping.DataTablesInput;\r\n" + 
				"import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;\r\n" + 
				"import org.springframework.stereotype.Service;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@Service\r\n" + 
				"public class **classname**Service\r\n" + 
				"{\r\n" + 
				"	\r\n" + 
				"	@Autowired\r\n" + 
				"	private **classname**Repository **objname**Repo;\r\n" + 
				"		\r\n" + 
				"\r\n" + 
				"	@Autowired\r\n" + 
				"	private **classname**DataTablesRepository **objname**DatableRepo;\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	public List<**classname**> getAll**classname**s(){\r\n" + 
				"		return **objname**Repo.findAll();\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	public **classname** save**classname**(**classname** **objname**) {\r\n" + 
				"		return **objname**Repo.save(**objname**);\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	public DataTablesOutput<**classname**> getAll**classname**Table(DataTablesInput input){\r\n" + 
				"		return **objname**DatableRepo.findAll(input);\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	public **classname** get**classname**ById(Long **objname**Id) {\r\n" + 
				"		return **objname**Repo.findOne(**objname**Id);\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	public void delete**classname**ById(Long **objname**Id) {\r\n" + 
				"		**objname**Repo.delete(**objname**Id);\r\n" + 
				"	}\r\n" + 
				"	\r\n"  +
				"    //end\r\n" +
				"}";

		
		result=orginStr.replace("**classname**", className).replace("**objname**", objName);
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	public static void outDatablesClass() throws IOException {
		
		if(className.endsWith("type")) {
			return;
		}
		
		File file=new File("src\\main\\java\\com\\haut\\grm\\datatables\\repository\\"+className+"DataTablesRepository.java");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
		
		String result=null;
		
		String orginStr="package com.haut.grm.datatables.repository;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.**classname**;\r\n" + 
				"\r\n" + 
				"public abstract interface **classname**DataTablesRepository\r\n" + 
				"  extends QDataTablesRepository<**classname**, Long>\r\n" + 
				"{}";

		
		result=orginStr.replace("**classname**", className);
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	public static void outRepositoryClass() throws IOException {
		
		
		File file=null;
		
		if(className.endsWith("type")) {
			file=new File("src\\main\\java\\com\\haut\\grm\\repository\\type\\"+className+"Repository.java");
		}else {
			file=new File("src\\main\\java\\com\\haut\\grm\\repository\\"+className+"Repository.java");
		}
		
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
		
		String result=null;
		
		String orginStr="package com.haut.grm.repository;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"import java.util.List;\r\n" + 
				"\r\n" + 
				"import org.springframework.data.querydsl.QueryDslPredicateExecutor;\r\n" + 
				"import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;\r\n" + 
				"import org.springframework.data.querydsl.binding.QuerydslBindings;\r\n" + 
				"\r\n" + 
				"import org.springframework.data.rest.core.annotation.RepositoryRestResource;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.Q**classname**;\r\n" + 
				"import com.haut.grm.model.**classname**;\r\n" + 
				"import com.haut.grm.repository.base.BaseEntityRepository;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@RepositoryRestResource\r\n" + 
				"public interface **classname**Repository extends BaseEntityRepository<**classname**,Long>, QueryDslPredicateExecutor<**classname**>, QuerydslBinderCustomizer<Q**classname**> {\r\n" + 
				"    default void customize(QuerydslBindings bindings, Q**classname** obj) { /* compiled code */ }\r\n" + 
				"\r\n" + 
				"     \r\n"  +
				"    //end\r\n" +
				
				"}";
		
		
		
		String orginTypeStr="package com.haut.grm.repository.type;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.type.**classname**;\r\n" + 
				"import com.haut.grm.repository.base.BaseTypeRepository;\r\n" + 
				"import org.springframework.data.rest.core.annotation.RepositoryRestResource;\r\n" + 
				"\r\n" + 
				"@RepositoryRestResource\r\n" + 
				"public abstract interface **classname**Repository\r\n" + 
				"  extends BaseTypeRepository<**classname**>\r\n" + 
				"{}";
		
		if(className.endsWith("type")) {
			result=orginTypeStr.replace("**classname**", className);
		}else {
			result=orginStr.replace("**classname**", className);
		}
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void outModelClass() throws IOException {
		File file=null;
		
		if(className.endsWith("type")) {
			file=new File("src\\main\\java\\com\\haut\\grm\\model\\type\\"+className+".java");
		}else {
			file=new File("src\\main\\java\\com\\haut\\grm\\model\\"+className+".java");
		}
		
		
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
		String result=null;
		String atts="";
		for(ZiDuan zd:list) {
//			System.out.println(zd.columnName);
			if("id".equals(zd.columnName)) {
				continue;
			}
			String attAnotation="";
			if("MyObject".equals(zd.getType())) {
				String ana1="	@ManyToOne\r\n";
				String ana2="	@JoinColumn(name=\""+zd.columnName+"\")\r\n";
				String ana3="	@JsonView({Views."+className+"View.class})\r\n";
				String ana4="	\r\n";
				
				attAnotation=attAnotation+ana4+ana1+ana2+ana3;
			}else {
				String ana1="	@Column(name=\""+zd.columnName+"\")\r\n";
				String ana2="	@JsonView({Views.IdView.class})\r\n";
				String ana3="	\r\n";
				
				attAnotation=attAnotation+ana3+ana1+ana2;
			}
			
			
			
			
			String att=attAnotation+"	private "+zd.getType()+" "+zd.getAttributeName()+";\r\n";
			atts=atts+att;
		}
		
		String orginStr="package com.haut.grm.model;\r\n" + 
				"\r\n" + 
				"import javax.persistence.Column;\r\n" + 
				"import javax.persistence.Entity;\r\n" + 
				"import javax.persistence.JoinColumn;\r\n" + 
				"import javax.persistence.OneToMany;\r\n" + 
				"import javax.persistence.ManyToOne;\r\n" + 
				"import javax.persistence.OneToOne;\r\n" + 
				"import javax.persistence.Table;\r\n" + 
				"import java.util.Date;\r\n" + 
				"\r\n" + 
				"import com.fasterxml.jackson.annotation.JsonView;\r\n" + 
				"import com.haut.grm.json.view.Views;\r\n" + 
				"import com.haut.grm.model.base.AbstractEntity;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"@Entity\r\n" + 
				"@Table(name=\"**tablename**\")\r\n" + 
				"public class **classname**  extends AbstractEntity<Long>{\r\n" + 
				"	\r\n" + 
				atts + 
				"\r\n" + 
				"}";
		
		
		
		String orginTypeStr="package com.haut.grm.model.type;\r\n" + 
				"\r\n" + 
				"import com.haut.grm.model.base.AbstractType;\r\n" + 
				"import javax.persistence.Entity;\r\n" + 
				"import javax.persistence.Table;\r\n" + 
				"\r\n" + 
				"@Entity\r\n" + 
				"@Table(name=\"**tablename**\")\r\n" + 
				"public class **className**\r\n" + 
				"  extends AbstractType\r\n" + 
				"{\r\n" + 
				"  \r\n" + 
				"}";
		
		if(className.endsWith("type")) {
			result=orginTypeStr.replace("**tablename**", tablename).replace("**className**", className);
		}else {
			result=orginStr.replace("**tablename**", tablename).replace("**classname**", className);
		}
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	public static void writeSearch() throws IOException {
		
		if(className.endsWith("type")) {
			return;
		}

		String strRes="";
		
		String strService="";
		
		String strController="";
		
		for(String stra:attributes) {
			String att="";
			
			String[] ass=stra.split("\\*");
			String str=ass[0];
			
			String []typess=ass[1].split(",");
			
			String attType=typess[0];
			
			String attService="";
			
			String attController="";
			if(str.contains(".")) {
//				System.out.println("com----------");
				String[] strs=str.split("\\.");
				String str1F=(strs[0].charAt(0)+"").toUpperCase();
				
				String str1=strs[0].substring(1, strs[0].length());
				str1=str1F+str1;
				String str2F=(strs[1].charAt(0)+"").toUpperCase();
				String str2=strs[1].substring(1, strs[1].length());
				str2=str2F+str2;
				att=str1+"_"+str2;
//				System.out.println(att);
			}else {
				String strF=(str.charAt(0)+"").toUpperCase();
				
				att=strF+str.substring(1,str.length());
			}
			
			String attLow=att.toLowerCase();
			
			String insert="";
			if(stra.endsWith("s")) {
				
				if("String".equals(attType)) {
					insert=
							"    //"+stra+"\r\n"+
							"    \r\n" + 
							"    List<"+className+"> findBy"+att+"Like("+attType+" "+attLow+");\r\n" + 
							"     \r\n"+
							"    \r\n" + 
							"    List<"+className+"> findBy"+att+"("+attType+" "+attLow+");\r\n" + 
							"     \r\n";
					
					
					attService=
							"    //"+stra+"\r\n"+
							"	public List<"+className+"> get"+className+"By"+att+"("+attType+" "+attLow+") {\r\n" + 
							"		return "+objName+"Repo.findBy"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n" + 
							"	\r\n" + 
							"	public List<"+className+"> get"+className+"ByLike"+att+"("+attType+" "+attLow+") {\r\n" + 
							"		return "+objName+"Repo.findBy"+att+"Like(\"%\"+"+attLow+"+\"%\");\r\n" + 
							"	}";
					
					
					
					attController=
							"    //"+stra+"\r\n"+
							"	@ApiOperation(value = \"\")\r\n" + 
							"	@RequestMapping(value={\"/v1/find"+objName+"By"+attLow+"/{"+attLow+"}\"}, method={RequestMethod.GET})\r\n" + 
							"	@JsonView({Views."+className+"View.class})\r\n" + 
							"	public List<"+className+"> get"+className+"By"+att+"(@PathVariable(\""+attLow+"\") "+attType+" "+attLow+"){\r\n" + 
							"		return "+objName+"Service.get"+className+"By"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n" + 
							"	@ApiOperation(value = \"\")\r\n" + 
							"	@RequestMapping(value={\"/v1/get"+objName+"/like"+attLow+"/{"+attLow+"}\"}, method={RequestMethod.GET})\r\n" + 
							"	@JsonView({Views."+className+"View.class})\r\n" + 
							"	public List<"+className+"> get"+className+"ByLike"+att+"(@PathVariable(\""+attLow+"\") "+attType+" "+attLow+"){\r\n" + 
							"		return "+objName+"Service.get"+className+"ByLike"+att+"("+attLow+");\r\n" + 
							"	}";
				}else {
					insert=
							"    //"+stra+"\r\n"+
							"    \r\n" + 
							"    List<"+className+"> findBy"+att+"("+attType+" "+attLow+");\r\n" + 
							"     \r\n";
					
					
					attService=
							"    //"+stra+"\r\n"+
							"	public List<"+className+"> get"+className+"By"+att+"("+attType+" "+attLow+") {\r\n" + 
							"		return "+objName+"Repo.findBy"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n";
					
					
					
					attController=
							"    //"+stra+"\r\n"+
							"	@ApiOperation(value = \"\")\r\n" + 
							"	@RequestMapping(value={\"/v1/find"+objName+"By"+attLow+"/{"+attLow+"}\"}, method={RequestMethod.GET})\r\n" + 
							"	@JsonView({Views."+className+"View.class})\r\n" + 
							"	public List<"+className+"> get"+className+"By"+att+"(@PathVariable(\""+attLow+"\") "+attType+" "+attLow+"){\r\n" + 
							"		return "+objName+"Service.get"+className+"By"+att+"("+attLow+");\r\n" + 
							"	}\r\n";
				}
				
				
				
				
				
			}else {
				
				
				if("String".equals(attType)) {
					insert=
							"    //"+stra+"\r\n"+
							"    \r\n" + 
							"    List<"+className+"> findBy"+att+"Like("+attType+" "+attLow+");\r\n" + 
							"     \r\n"+
							"    \r\n" + 
							"    "+className+" findBy"+att+"("+attType+" "+attLow+");\r\n" + 
							"     \r\n";
					
					
					
					attService=
							"    //"+stra+"\r\n"+
							"	public "+className+" get"+className+"By"+att+"("+attType+" "+attLow+") {\r\n" + 
							"		return "+objName+"Repo.findBy"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n" + 
							"	\r\n" + 
							"	public List<"+className+"> get"+className+"ByLike"+att+"("+attType+" "+attLow+") {\r\n" + 
							"		return "+objName+"Repo.findBy"+att+"Like(\"%\"+"+attLow+"+\"%\");\r\n" + 
							"	}";
					
					
					attController=
							"    //"+stra+"\r\n"+
							"	@ApiOperation(value = \"\")\r\n" + 
							"	@RequestMapping(value={\"/v1/find"+objName+"By"+attLow+"/{"+attLow+"}\"}, method={RequestMethod.GET})\r\n" + 
							"	@JsonView({Views."+className+"View.class})\r\n" + 
							"	public "+className+" get"+className+"By"+att+"(@PathVariable(\""+attLow+"\") "+attType+" "+attLow+"){\r\n" + 
							"		return "+objName+"Service.get"+className+"By"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n" + 
							"	@ApiOperation(value = \"\")\r\n" + 
							"	@RequestMapping(value={\"/v1/get"+objName+"/like"+attLow+"/{"+attLow+"}\"}, method={RequestMethod.GET})\r\n" + 
							"	@JsonView({Views."+className+"View.class})\r\n" + 
							"	public List<"+className+"> get"+className+"ByLike"+att+"(@PathVariable(\""+attLow+"\") "+attType+" "+attLow+"){\r\n" + 
							"		return "+objName+"Service.get"+className+"ByLike"+att+"("+attLow+");\r\n" + 
							"	}";
				}else {
					insert=
							"    //"+stra+"\r\n"+
							"    \r\n" + 
							"    "+className+" findBy"+att+"("+attType+" "+attLow+");\r\n" + 
							"     \r\n";
					
					
					
					attService=
							"    //"+stra+"\r\n"+
							"	public "+className+" get"+className+"By"+att+"("+attType+" "+attLow+") {\r\n" + 
							"		return "+objName+"Repo.findBy"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n";
					
					
					attController=
							"    //"+stra+"\r\n"+
							"	@ApiOperation(value = \"\")\r\n" + 
							"	@RequestMapping(value={\"/v1/find"+objName+"By"+attLow+"/{"+attLow+"}\"}, method={RequestMethod.GET})\r\n" + 
							"	@JsonView({Views."+className+"View.class})\r\n" + 
							"	public "+className+" get"+className+"By"+att+"(@PathVariable(\""+attLow+"\") "+attType+" "+attLow+"){\r\n" + 
							"		return "+objName+"Service.get"+className+"By"+att+"("+attLow+");\r\n" + 
							"	}\r\n" + 
							"	\r\n";
				}
				
				
				
				
				
			}
			
			
			
			strRes=strRes+insert;
			
			strService=strService+attService;
			
			strController=strController+attController;
			
			
		}
//		if(true) {
//			return;
//		}
		
		String end=
				"\r\n"+
				"    //end\r\n";
		strRes=strRes+end;
		strService=strService+end;
		strController=strController+end;
		
		File file=new File("src\\main\\java\\com\\haut\\grm\\repository\\"+className+"Repository.java");
		outSearchClass(file,strRes);
		file=new File("src\\main\\java\\com\\haut\\grm\\service\\"+className+"Service.java");
		outSearchClass(file,strService);
		
		file=new File("src\\main\\java\\com\\haut\\grm\\controller\\"+className+"Controller.java");
		outSearchClass(file,strController);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		writeSearch();
//		outClass();
	}
	
	
	
}
