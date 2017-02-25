package com.gui.star_zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author wuhoujian 2017/02/20
 * 
 *         1. 服务过滤 ZuulFilter过滤器起到一个前门保护的作用，实现对服务访问的安全控制。
 * 
 *         2.自定义过滤器的实现 需要继承ZuulFilter，需要重写实现下面四个方法:
 *         (1)filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 *         pre：可以在请求被路由之前调用 routing：在路由请求时候被调用 post：在routing和error过滤器之后被调用
 *         error：处理请求时发生错误时被调用
 * 
 *         (2)filterOrder：通过int值来定义过滤器的执行顺序
 * 
 *         (3)shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效。
 * 
 *         (4)run：过滤器的具体逻辑
 */
public class AccessFilter extends ZuulFilter {

	/**
	 * 安全过滤模拟：只允许两个正整数相加，否则报错返回
	 */

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		Integer valA = Integer.parseInt(request.getParameter("a")), valB = Integer.parseInt(request.getParameter("b"));

		if (!(valA > 0 && valB > 0)) {
			System.out.println("the value of a and b must be greater than 0...");

			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("the value of a and b must be greater than 0...");
			return null;
		}

		System.out.println("a and b is ok...");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}
}
