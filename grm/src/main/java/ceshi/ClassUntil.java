package ceshi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import javassist.bytecode.stackmap.TypeData.ClassName;




public class ClassUntil {
	
	private static String driver =  "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/grm_self";	//数据源(mysql)的连接地址
	static String user = "root";	//用户名
	static String password = "123456";	//用户密码
	
	static String tablename="qt_cd_jl";
	
	static String className=null;
	
	static List<ZiDuan> list=new ArrayList<ZiDuan>();
	
	String orginUrl="C:\\Users\\19601\\Desktop";
	
	static {
		getClassName();
		list=main1();
		System.out.println("col size:"+list.size());
		System.out.println(className);
	}
	
	public  static List<ZiDuan> main1() {
		Connection conn = null;
        Statement stmt = null;
		
		try {
			
			
			Class.forName(driver);
			System.out.println("连接数据库...");
	        conn = DriverManager.getConnection(url, user, password);
	        
	        
	        System.out.println(" 实例化Statement对象...");
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
		String str=tablename.replace("_", "");
		String a=(str.charAt(0)+"").toUpperCase();
		str=str.substring(1,str.length());
		str=a+str;
		className=str;
	}
	
	
	public static void outClass() throws IOException {
		File file=new File("C:\\Users\\19601\\Desktop\\outclass");
		boolean bo=file.exists();
		if(!bo) {
			bo=file.mkdir();
		}
		if(bo) {
			file=new File("C:\\Users\\19601\\Desktop\\outclass\\model");
			if(!file.exists()) {
				file.mkdir();
			}
			outModelClass();
			file=new File("C:\\Users\\19601\\Desktop\\outclass\\repository");
			if(!file.exists()) {
				file.mkdir();
			}
			outRepositoryClass();
			file=new File("C:\\Users\\19601\\Desktop\\outclass\\service");
			if(!file.exists()) {
				file.mkdir();
			}
			file=new File("C:\\Users\\19601\\Desktop\\outclass\\controller");
			if(!file.exists()) {
				file.mkdir();
			}
			
		}
	}
	
	
	public static void outRepositoryClass() throws IOException {
		File file=new File("C:\\Users\\19601\\Desktop\\outclass\\repository\\"+className+"Repository.java");
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
				"     \r\n" + 
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
		
		if(tablename.endsWith("type")) {
			result=orginTypeStr.replace("**className**", className);
		}else {
			result=orginStr.replace("**classname**", className);
		}
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void outModelClass() throws IOException {
		File file=new File("C:\\Users\\19601\\Desktop\\outclass\\model\\"+className+".java");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outWriter);
		String result=null;
		String atts="";
		for(ZiDuan zd:list) {
			System.out.println(zd.columnName);
			if("id".equals(zd.columnName)) {
				continue;
			}
			String attAnotation="";
			if("MyObject".equals(zd.getType())) {
				String ana1="	@ManyToOne\r\n";
				String ana2="	@JoinColumn(name=\""+zd.columnName+"\")\r\n";
				String ana3="	@JsonView({Views.IdView.class})\r\n";
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
		
		if(tablename.endsWith("type")) {
			result=orginTypeStr.replace("**tablename**", tablename).replace("**className**", className);
		}else {
			result=orginStr.replace("**tablename**", tablename).replace("**classname**", className);
		}
		bw.write(result);
		
		bw.close();
		outWriter.close();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		outClass();
	}
	
	
	
	
	
}
