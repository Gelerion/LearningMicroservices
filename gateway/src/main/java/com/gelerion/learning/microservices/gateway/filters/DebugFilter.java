package com.gelerion.learning.microservices.gateway.filters;

import java.lang.invoke.MethodHandles;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class DebugFilter extends ZuulFilter {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 10_000;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest req = ctx.getRequest();
		log.info(String.format("%s,%s,%s", req.getMethod(), req.getRequestURI(), req.getProtocol()));
		return null;
	}
}
