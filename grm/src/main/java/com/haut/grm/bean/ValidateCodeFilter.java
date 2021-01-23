
package com.haut.grm.bean;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.haut.grm.model.MyUser;
import com.haut.grm.model.meta.MyUserDetails;
import com.haut.grm.model.meta.User;
import com.haut.grm.repository.meta.UserRepository;
import com.haut.grm.service.AuthUserService;
import javax.servlet.http.HttpServletRequestWrapper;
 
/**
 * @author zhailiang
 *
 */
public class ValidateCodeFilter extends OncePerRequestFilter {

	@Autowired
	private UserRepository userRepo;
	
	private static Map<String, String> tmap=new HashMap<String, String>();

	
	private static final String REGEX="columns%5B\\d+%5D";
	
	private static final Pattern p = Pattern.compile(REGEX);
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		response.setHeader("Access-Control-Allow-Origin", "*");//允许所有网站跨域访问
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        
        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("content-type", "*");

		String url=request.getRequestURI();
		
		
		GetHttpServletRequestWrapper gw=new GetHttpServletRequestWrapper(request);			
		
		if(true) {
			filterChain.doFilter(gw, response);
			return;
		}
		
		
		if(url.contains("get/data/")) {
			System.out.println("构建装饰器.....");
			
//			GetHttpServletRequestWrapper gw=new GetHttpServletRequestWrapper(request);			
			
			
			filterChain.doFilter(gw, response);
			return;
		}
		
		
		if("OPTIONS".equals(request.getMethod())) {
			System.out.println("OPTIONS.........");
			response.setStatus(200);
			response.getWriter().write("111111");
			return;
		}
		
		
		if(true) {
			filterChain.doFilter(request, response);
			return;
		}
		
		if(url.contains("j_spring_security_check")) {
			System.out.println("j_spring_security_check.........");
			MyUser u=null;
			String postdata=getPostData(request);

			System.out.println("postdata:"+postdata);
			
			
			
			
			if(postdata.contains("username")&&postdata.contains("password")&&postdata.contains("&")) {
				System.out.println("&.........");
				String[] strs=postdata.split("&");
				if(strs.length>=2) {
					System.out.println(strs[0]);
					String[] strs1=strs[0].split("=");
					String[] strs2=strs[1].split("=");
					if(strs1.length==2&&strs2.length==2) {
						System.out.println(strs1[0]);
						if("username".equals(strs1[0])&&"password".equals(strs2[0])) {
							u=new MyUser();
							u.setUsername(strs1[1]);
							u.setPwd(strs2[1]);
							u.setId(System.currentTimeMillis()+"");
						}else if("username".equals(strs2[0])&&"password".equals(strs1[0])) {
							u=new MyUser();
							u.setUsername(strs2[1]);
							u.setPwd(strs1[1]);
							u.setId(System.currentTimeMillis()+"");
						}
						if(u!=null) {
							User ju=userRepo.getByUsername(u.getUsername());
							if(ju!=null) {
								if(ju.getPassword().equals(u.getPwd())) {
									
									String token=JwtUtils.encode(u,300000000);
									tmap.put(u.getUsername(), u.getId());
									
									
									response.setStatus(200);
//									response.Header().Set("Content-Type", "application/json")
//									response.getWriter().
									response.getWriter().write(token);
									return;
								}
							}
							
							
							
							
							
						}
					}
				}
			
			}else {
				if(postdata!=null) {
					Map<String,Object> jsonToMap = JSONObject.parseObject(postdata);
					if(jsonToMap!=null) {
						Object o1=jsonToMap.get("username");
						Object o2=jsonToMap.get("password");
						
						if(o1!=null&&o2!=null) {
							String username=o1.toString();
							String password=o2.toString();
							if(username!=null&&password!=null) {
								System.out.println();
								MyUser jsonu=new MyUser(username, password,System.currentTimeMillis()+"");
								String token=JwtUtils.encode(jsonu,300000000);
								tmap.put(jsonu.getUsername(), jsonu.getId());
								User ju=userRepo.getByUsername(username);
								if(ju!=null) {
									System.out.println("password:"+ju.getPassword());
									if(ju.getPassword().equals(password)) {
										System.out.println("发给客户端 token:"+token);
										response.setStatus(200);
										
										MySSToken sstoken=new MySSToken(token);
										
										String ssjson=JSONObject.toJSONString(sstoken);
										System.out.println(ssjson);
										response.getWriter().write(ssjson);
										return;
									}
								}
								
							}
						}
					}
					
				}
			}
			
			
			
			

			response.setStatus(401);
			response.getWriter().write("111111");
			return;
		}
		else if(url.contains("login")||url.contains("assets")||url.contains("page")||url.contains("assets2")) {
			System.out.println("静态资源。。。。。。。。。。。。。。。");
		}
		else {
			String token=request.getHeader("token");
			if(token!=null) {
//				System.out.println("head token not null");
//				System.out.println(url);
				System.out.println(token);
				MyUser u=JwtUtils.unsign(token);
				
				if(u!=null) {
					if(tmap.containsKey(u.getUsername())) {
						if(tmap.get(u.getUsername()).equals(u.getId())) {
							filterChain.doFilter(request, response);
							return;
						}else {
							System.out.println("token 过期");
						}
					}
				}else {
					System.out.println("未解析出来token.....");
					response.setStatus(401);
					response.getWriter().write("111111");
					return;
				}
				
			}
			System.out.println("head token null");
			response.setStatus(401);
			response.getWriter().write("111111");
			return;
		}
		filterChain.doFilter(request, response);		
	}
	
	private static String getPostData(HttpServletRequest request) {
		StringBuffer data = new StringBuffer();
		String line = null;
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			while (null != (line = reader.readLine()))
				data.append(line);
		} catch (IOException e) {
			System.out.println("读取responseBody 失败");
		} finally {
		}
		return data.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	System.out.println(postdata);
	
	
	
	
//	if(postdata.contains("username")&&postdata.contains("password")&&postdata.contains("&")) {
//		System.out.println("&.........");
//		String[] strs=postdata.split("&");
//		if(strs.length>=2) {
//			System.out.println(strs[0]);
//			String[] strs1=strs[0].split("=");
//			String[] strs2=strs[1].split("=");
//			if(strs1.length==2&&strs2.length==2) {
//				System.out.println(strs1[0]);
//				if("username".equals(strs1[0])&&"password".equals(strs2[0])) {
//					u=new MyUser();
//					u.setUsername(strs1[1]);
//					u.setPwd(strs2[1]);
//				}else if("username".equals(strs2[0])&&"password".equals(strs1[0])) {
//					u=new MyUser();
//					u.setUsername(strs2[1]);
//					u.setPwd(strs1[1]);
//				}
//				if(u!=null) {
//					String token=JwtUtils.encode(u,300000000);
//					response.setStatus(200);
//					response.getWriter().write(token);
//					return;
//				}
//			}
//		}
//		
//	}else {
//		
//		
//		System.out.println("json.........");
//		
//		System.out.println("postdata:"+postdata);
//		
//		if(postdata!=null) {
//			Map<String,Object> jsonToMap = JSONObject.parseObject(postdata);
//			if(jsonToMap!=null) {
//				Object o1=jsonToMap.get("username");
//				Object o2=jsonToMap.get("password");
//				
//				if(o1!=null||o2!=null) {
//					String username=o1.toString();
//					String password=o2.toString();
//					if(username!=null&&password!=null) {
//						System.out.println();
//						MyUser jsonu=new MyUser(username, password);
//						String token=JwtUtils.encode(jsonu,300000000);
//						System.out.println("发给客户端 token:"+token);
//						response.setStatus(200);
//						response.getWriter().write(token);
//						return;
//					}
//				}
//			}
//			
//		}
//		
//		
//		
//	}
	
}

