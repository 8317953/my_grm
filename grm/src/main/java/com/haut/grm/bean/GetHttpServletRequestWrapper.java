package com.haut.grm.bean;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper{

	
	private static final String REGEX="columns%5B\\d+%5D";
	
	private static final Pattern p = Pattern.compile(REGEX);
	
	public GetHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public String getQueryString() {
        String str=((HttpServletRequest) super.getRequest()).getQueryString();
        
//        draw=1&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=asc&start=0&length=5&search%5Bvalue%5D=&search%5Bregex%5D=false&_=1611300782178
        if(str==null) {
        	return null;
        }
        String[] strs=str.split("&");
        
        String res="";
        for(String re:strs) {
        	if(MyContain(re)) {
        		String[] as=re.split(REGEX);
        		int len=as[1].length();
        		String ass=as[1].replace("%5B", ".").replace("%5D", "");
        		String resu=re.substring(0,re.length()-len)+ass;
        		res=res+resu+"&";
        	}else {
        		res=res+re+"&";
        	}
        }
        System.out.println("res:"+res);
        return res;
    }
	
	
	
	
	
	
	
	
	
	
	
	@Override
    public String getParameter(String name) {
        if("newParam".equals(name)){
            return "这是我新增加的参数";
        }
        return super.getParameter(name);
    }
    @Override
    public Map<String, String[]> getParameterMap() {
    	System.out.println("------");
        HashMap<String, String[]> newMap = new HashMap<>();
        newMap.putAll(super.getParameterMap());
        newMap.put("newParam",new String[]{"这是我新增加的参数"}) ;
        return Collections.unmodifiableMap(newMap);
    }
    @Override
    public String[] getParameterValues(String name) {
        if("newParam".equals(name)){
            return new String[]{"这是我新增加的参数"};
        }
        return super.getParameterValues(name);
    }
	
	
	
	
	
	
	
	
	
	
	
//	public static String getCeshiString() {
//        String str="draw=1&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=asc&start=0&length=5&search%5Bvalue%5D=&search%5Bregex%5D=false&_=1611300782178";
//        
////        draw=1&columns%5B0%5D%5Bdata%5D=id&columns%5B0%5D%5Bname%5D=&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=true&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=asc&start=0&length=5&search%5Bvalue%5D=&search%5Bregex%5D=false&_=1611300782178
//        
//        String[] strs=str.split("&");
//        String res="";
//        for(String re:strs) {
//        	if(MyContain(re)) {
//        		String[] as=re.split(REGEX);
//        		int len=as[1].length();
//        		String ass=as[1].replace("%5B", ".").replace("%5D", "");
//        		String resu=re.substring(0,re.length()-len)+ass;
//        		res=res+resu+"&";
//        	}else {
//        		res=res+re+"&";
//        	}
//        }
//        
//        return res;
//    }
	
	public static boolean MyContain(String str) {
		Matcher m = p.matcher(str);
		if(m.find()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
//	public static void main(String[] args) {
////		String str="columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=";
////		String[] strs=str.split(REGEX);
////		System.out.println(strs[1]);
////		String re=strs[1].replace("%5B", ".").replace("%5D", "");
////		System.out.println(re);
////		
////		String st=str.substring(0, str.length()-strs[1].length())+re;
////		System.out.println(st);
//		
//		System.out.println(getCeshiString());
//		
//	}
}