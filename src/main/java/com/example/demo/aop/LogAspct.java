package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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

	Logger logger=LoggerFactory.getLogger(LogAspct.class);
	
	@Pointcut("@annotation(com.example.demo.anno.EntityLog)")
	public void entityLogPC() {
		
	}
	@Around(value = "entityLogPC()")
	public Object around(ProceedingJoinPoint  joinPoint) {
		Signature signature=joinPoint.getSignature();
		/*
		 * String joinPointClassName=joinPoint.getClass().getName(); String
		 * signatureclassName=signature.getClass().getName();
		 * logger.info("signatureclassName : "+signatureclassName);
		 * logger.info("joinPointClassName : "+joinPointClassName); Class<?>
		 * className=joinPoint.getTarget().getClass();
		 * logger.info("targetClassName : "+className); String
		 * thisName=joinPoint.getThis().getClass().getName();
		 * logger.info("thisName : "+thisName);
		 */
		String methodName=signature.getName();
		logger.info("methodName : "+methodName);
		Class<?> signatureDeclaringType=signature.getDeclaringType();
		logger.info("signatureDeclaringTypeName : "+signatureDeclaringType);
		@SuppressWarnings("rawtypes")
		Class[] parameterTypes=((MethodSignature)signature).getParameterTypes();
		Object result=null;
		try {
			Method method=signatureDeclaringType.getMethod(methodName, parameterTypes);
			if(method.isAnnotationPresent(EntityLog.class)) {
				EntityLog entityLog=method.getAnnotation(EntityLog.class);
				Logger loggerLog=LoggerFactory.getLogger(signatureDeclaringType);
				loggerLog.info(entityLog.operateType()+" "+entityLog.desc()+" begin!--------------------");
				Object[] args = joinPoint.getArgs();
				result=joinPoint.proceed(args);
				loggerLog.info("result："+result.toString());
				loggerLog.info(entityLog.operateType()+" "+entityLog.desc()+" end!--------------------");
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
