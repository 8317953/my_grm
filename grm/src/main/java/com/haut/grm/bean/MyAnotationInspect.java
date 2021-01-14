package com.haut.grm.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;//真踏马大坑  jar包可能会导入错误
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyAnotationInspect implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		System.out.println("+++++++++++++++++++++");
//		boolean ishasAnotation=handler.getClass().isAssignableFrom(HandlerMethod.class);
//		System.out.println("当前方法是否含有注解:"+ishasAnotation);
//		if(ishasAnotation) {
//			RolerController rolerCtrl=((HandlerMethod)handler).getMethodAnnotation(RolerController.class);
//			
//			if(rolerCtrl==null) {
//				System.out.println("无该注解");
//			}else {
//				System.out.println(Arrays.toString(rolerCtrl.getRoles()));
//			}
//		}
		
//		
		
		String result = buildLimitInfo(handler);
        if (StringUtils.isEmpty(result)) {
//            System.out.println("empty");
        } else {
            System.out.println(result);
        }
//        System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffffff");
        return true;
	}
	
	private String buildLimitInfo(Object handler) {
        if (handler instanceof HandlerMethod) {
//        	System.out.println("asdsfsdg");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            handlerMethod.get
            Method m = handlerMethod.getMethod();
            Annotation[] as= m.getAnnotations();
            
            for(Annotation a:as) {
//            	System.out.println(a.annotationType().getName());
            	if("com.haut.grm.bean.RolerController".equals(a.annotationType().getName())) {
            		RolerController r=(RolerController)a;
            		System.out.println(Arrays.toString(r.getRoles())+","+r.onlyLoginCanAccess());
            	}
            }
            
//            if(as!=null) {
//            	System.out.println(as.length);
//            }
            
           
            
        }
        return null;
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
