package com.kruf.wow.filter;


import com.alibaba.fastjson.JSON;
import com.kruf.wow.util.ipUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Slf4j
public class AccessLogFilter implements Filter {
    private static final String LOG_FORMATTER_IN = "请求路径：{}，请求方法：{}，param参数：{}，ip地址:{}" +
            "-----------------";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String accessUrl = request.getRequestURI();
        String method = request.getMethod();
        String requestParameter = "";
        String requestBodyJson = "";
        String requestedIP = ipUtil.getIpAddr(request);
        requestParameter = getRequestParameter(request);
        log.info(LOG_FORMATTER_IN, accessUrl, method, requestParameter, requestedIP);
        //跳转请求
        filterChain.doFilter(request, servletResponse);
    }


    private String getRequestParameter(HttpServletRequest request) {
        return JSON.toJSONString(request.getParameterMap());
    }


}
