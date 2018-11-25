package com.fh.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.fh.bean.log.LogBean;
import com.fh.service.log.ILogService;



@Aspect
@Component
public class LogAspect
{
	@Autowired
	private ILogService loginService;
	
	@Pointcut("execution(* com.fh.controller..*.*(..))")
	private void doMethod(){
		
	}
	
	@Before("doMethod()")
	public void beforeAdvice(JoinPoint joinPoint,LogBean log){
		HttpServletRequest request = 
				((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 请求的IP
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		try {
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String params = "";
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				params = Arrays.toString(joinPoint.getArgs());
			}
			Object[] arguments = joinPoint.getArgs();
			String logName = "";
			String modelName = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length){
						if (method.getAnnotation(ILogAcpect.class) != null) {
							logName = method.getAnnotation(ILogAcpect.class).methodInfo();
							modelName = method.getAnnotation(ILogAcpect.class).modelName();
						}
						break;
					}
				}
			}
			log.setCmethodname(methodName);
			log.setClogname(logName);
			log.setCip(ip);
			loginService.addLog(log);
			// 通过类路径获取所有的方法
			System.out.println("日志输出的明细为:" + logName);
			System.out.println("日志输出访问模块:" + modelName);
			System.out.println("访问参数:" + params);
			System.out.println("访问的类路径:" + targetName);
			System.out.println("访问的方法名:" + methodName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	} 
	
	
	@After("doMethod()")
	public void afterAdvice(){
		System.out.println("afterAdvice");
	}
	
	@AfterThrowing(pointcut = "doMethod()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.err.println("异常通知:" + e.getMessage());
	}
	
	
	
	
	
	
	
	
	
	
}
