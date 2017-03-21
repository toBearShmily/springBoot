package com.shmily.util;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware{
	 private static ApplicationContext applicationContext = null;
	 //private static final Logger logger = LogManager.getLogger(SpringContextHolder.class);
	 
	 public void setApplicationContext(ApplicationContext applicationContext) {
	  //logger.debug("注入ApplicationContext到SpringContextHolder:" + applicationContext);
		 System.out.println("注入ApplicationContext到SpringContextHolder:" + applicationContext);
	  if (SpringContextHolder.applicationContext != null) {
	   //logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
	     //+ SpringContextHolder.applicationContext);
		  System.out.println("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
		  + SpringContextHolder.applicationContext);
	  }
	  SpringContextHolder.applicationContext = applicationContext; //NOSONAR
	 }
	 
	 public void destroy() throws Exception {
	  SpringContextHolder.clear();
	 }
	 
	 public static ApplicationContext getApplicationContext() {
	  assertContextInjected();
	  return applicationContext;
	 }
	 
	 @SuppressWarnings("unchecked")
	 public static <T> T getBean(String name) {
	  assertContextInjected();
	  return (T) applicationContext.getBean(name);
	 }
	 
	 public static <T> T getBean(Class<T> requiredType) {
	  assertContextInjected();
	  return applicationContext.getBean(requiredType);
	 }
	 
	 public static void clear() {
	  //logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		 System.out.println("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
	  applicationContext = null;
	 }
	 
	 private static void assertContextInjected() {
	  if (applicationContext == null) {
	   throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
	  }
	 }
	}
