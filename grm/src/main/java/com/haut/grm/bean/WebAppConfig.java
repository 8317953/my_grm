package com.haut.grm.bean;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter  {

    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        
    }

//    @Override
//	public void addInterceptors(InterceptorRegistry registry) {
//    	System.out.println("添加过滤器......");
//    	registry.addInterceptor(new MyAnotationInspect()).addPathPatterns("/*");
//	}
    
    
    @Override
	public void addCorsMappings(CorsRegistry registry) {
    	System.out.println("跨域。。。。");
    	registry.addMapping("/**")
        .allowCredentials(true)
        .allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .allowedHeaders("*")
        .maxAge(3600);
	}
    
}