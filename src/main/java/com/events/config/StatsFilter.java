package com.events.config;

import lombok.extern.slf4j.Slf4j;
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
            stopWatch.stop();
            log.info(String.format("%s %s %s %s", request.getMethod(), request.getRequestURI(), response.getStatus(), stopWatch.getTotalTimeSeconds()));
        }
    }
    @Override
    public void destroy() {
        // empty
    }
}
