package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.anno.EntityLog;

@Aspect
@Component
public class LogAspct {

	@Pointcut("@annotation(com.example.demo.anno.EntityLog)")
	public void entityLogPC() {
		
	}
	@After(value = "entityLogPC()")
	public void after(JoinPoint joinPoint) {
		Signature s=joinPoint.getSignature();
		//Class<?> className=joinPoint.getClass();   不对
		Class<?> className=s.getClass();// 也不对
		String methodName=s.getName();
		@SuppressWarnings("rawtypes")
		Class[] parameterTypes=((MethodSignature)s).getParameterTypes();
		try {
			Method method=className.getMethod(methodName, parameterTypes);
			if(method.isAnnotationPresent(EntityLog.class)) {
				EntityLog entityLog=method.getAnnotation(EntityLog.class);
				Logger logger=LoggerFactory.getLogger(entityLog.getClass());
				logger.info(entityLog.operateType()+" "+entityLog.desc());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
}
