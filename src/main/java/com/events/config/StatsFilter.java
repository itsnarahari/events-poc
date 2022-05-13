package com.events.config;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Slf4j
public class StatsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        StopWatch stopWatch=new StopWatch();
        try {
            stopWatch.start();
            filterChain.doFilter(request, response);
        } finally {
//
            stopWatch.stop();
            log.info("{}: {} {} {} ms ", ((HttpServletRequest) request).getRequestURI(),request.getMethod() ,request.getQueryString(), stopWatch.getTotalTimeSeconds());
        }
    }

    @Override
    public void destroy() {
        // empty
    }
}
