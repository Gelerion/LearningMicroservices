package com.gelerion.learning.microservices.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletResponse;

public class ResponseHeaderFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 100;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		HttpServletResponse resp = RequestContext.getCurrentContext().getResponse();
		resp.addHeader("X-Spring-Boot-Proxy", "Zuul");
		return null;
	}
}
