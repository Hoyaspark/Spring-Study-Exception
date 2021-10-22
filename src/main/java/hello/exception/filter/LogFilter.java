package hello.exception.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("로그 필터 초기화");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("로그 필터 시작");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        String uuid = UUID.randomUUID().toString();

        try {
            log.info("{} [{}][{}][{}]", request.getDispatcherType(),uuid, requestURI, method);
            chain.doFilter(request,response);
        } catch (Exception e) {
            throw e;
        }finally {
            log.info("로그 필터 종료");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
