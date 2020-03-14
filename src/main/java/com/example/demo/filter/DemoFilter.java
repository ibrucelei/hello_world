package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
@Order(1)
public class DemoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		log.info("httpRequest.getRequestURI(): "+httpRequest.getRequestURI());
		System.out.println("httpRequest.getRequestURI(): "+httpRequest.getRequestURI());
		chain.doFilter(request, response);
	}

}
