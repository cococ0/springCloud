package com.example.servicezuul.common;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * zuulFilter 过滤并安全验证
 * */
public class MyFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(MyFilter.class);
    /**
     * filter返回字符串代表过滤器类型
     * pre:路由之前
     * routing:路由之时
     * post:路由之后
     * error:发送错误调用
     * */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * filterOrder：过滤的顺序
     * */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * shouldFilter：这里可以写逻辑判断 true表示永久过滤
     * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑，可用很复杂，
     * 包括查sql，nosql去判断该请求有没有访问权限
     * */
    @Override
    public Object run() throws ZuulException {
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();
        logger.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURI()));
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            logger.warn("token is empty");
            cxt.setSendZuulResponse(false);
            cxt.setResponseStatusCode(401);
            try {
                cxt.getResponse().getWriter().write("token is empty");
            }catch (Exception e){

            }
        }
        return null;
    }
}
