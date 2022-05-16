package com.events.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            MDC.put("method",request.getMethod());
            MDC.put("path", request.getRequestURI());
            MDC.put("statusCode", String.valueOf(response.getStatus()));
            stopWatch.stop();
            MDC.put("executionTime", String.valueOf(stopWatch.getTotalTimeSeconds()));
            log.info("");
        }
    }
    @Override
    public void destroy() {
        // empty
    }
}
