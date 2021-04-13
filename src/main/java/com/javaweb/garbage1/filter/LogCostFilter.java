package com.javaweb.garbage1.filter;


import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogCostFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Integer userType = (Integer) session.getAttribute("userType");
        String url = request.getRequestURI();
        int idx = url.lastIndexOf("/");
        String endWith = url.substring(idx + 1);





        if(!(endWith.equals("index.html") || endWith.equals("game.html") || endWith.equals("register.html") || (!endWith.contains("html")))){
            if(userType == null) {
                request.getRequestDispatcher("./errorPage.html").forward(request,response);
                System.out.println("拦截的网页:" + url);
            }else if(endWith.equals("AdminQuesKido.html") && userType != 1){
                request.getRequestDispatcher("./errorPage.html").forward(request,response);
                System.out.println("拦截的网页:" + url);
            }else{
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }



        System.out.println("Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
