package com.kruf.wow.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

@Slf4j
public class ipUtil {


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        log.debug("X-Forwarded-For  ip="+ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.debug("Proxy-Client-IP  ip="+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.debug("WL-Proxy-Client-IP  ip="+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.debug("HTTP_CLIENT_IP  ip="+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.debug("HTTP_X_FORWARDED_FOR  ip="+ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.debug("request.getRemoteAddr() ip="+ip);
        }
        if(null!=ip&&!ip.equals(ip)){
            ip=ip.split(",")[0];
        }
        return ip;
    }

    public static String getLocalIpAddr(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
//            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
//            log.debug("本机名称是："+ localname);
//            log.debug("本机的ip是 ："+localip);
            return localip;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }


}
