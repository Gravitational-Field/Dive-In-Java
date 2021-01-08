package com.lzj.filter;


import com.lzj.util.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName TransactionFilter
 * @Description: 通过该过滤器，统一给多个聚合到一块的数据操作的Service来进行一致的数据管理
 * @Author Keen
 * @DATE 2021/1/4 20:15
 * @Version 1.0
 **/
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    /**
    * @Author: Keen
    * @Date:  20:18  2021/1/4
    * @Description:  拦截所有请求，检查，若出现异常，则进行回滚，保证数据的一致性
    * @param: null
    * @Return 
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行到TransactionFilter的doFilter中");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e); //将异常抛给tomcat服务器
        }
    }

    @Override
    public void destroy() {

    }
}
