package com.itheima.client.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2019/8/11
 * @Author: itheima
 */
@Slf4j
public class MyPreZuulFilter extends ZuulFilter {
    /**
     * 声明是哪种过滤器类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器要执行的方法
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String method = request.getMethod();
        int localPort = request.getLocalPort();
        log.info("method===="+method+"============port"+localPort);
        return null;
    }
}
