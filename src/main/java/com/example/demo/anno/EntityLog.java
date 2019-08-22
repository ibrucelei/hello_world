package com.example.demo.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.demo.constant.OperateType;

@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface EntityLog {
	String desc();
	Class<?> entity();
	OperateType operateType();
}
