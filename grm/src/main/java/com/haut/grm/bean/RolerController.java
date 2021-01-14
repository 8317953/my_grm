package com.haut.grm.bean;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface RolerController {
	
	
	public String[] getRoles();
	
	boolean onlyLoginCanAccess() default true;

}
