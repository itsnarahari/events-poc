package com.events.config;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class StatsFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // empty
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        long time = System.currentTimeMillis();
        StopWatch stopWatch=new StopWatch();
        try {
            stopWatch.start();
            chain.doFilter(req, resp);
        } finally {
//            time = System.currentTimeMillis() - time;
            stopWatch.stop();
            LOGGER.trace("{}: {} ms ", ((HttpServletRequest) req).getRequestURI(),  stopWatch.prettyPrint());
        }
    }

    @Override
    public void destroy() {
        // empty
    }
}
