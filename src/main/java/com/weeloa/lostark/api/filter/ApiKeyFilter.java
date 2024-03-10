package com.weeloa.lostark.api.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = "/api/*")
public class ApiKeyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("----- api_key filter on");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String apiKey =  ((HttpServletRequest) request).getHeader("Authorization");
        log.info("api_key : " + apiKey);
    }


    @Override
    public void destroy() {
        log.info("----- api_key filter off");
    }
}
