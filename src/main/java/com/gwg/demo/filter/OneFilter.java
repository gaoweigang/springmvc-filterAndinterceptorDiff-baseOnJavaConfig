package com.gwg.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器：如果没有session状态直接跳转到/user/login_view地址也就是我们对应的login.jsp页面
 *
 */
public class OneFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(OneFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		logger.info("############OneFilter doFilterInternal executed############");
		filterChain.doFilter(request, response);
		//在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
		logger.info("############OneFilter doFilter after############");

	}
}
