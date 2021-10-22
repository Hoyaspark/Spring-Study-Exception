package hello.exception.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute("uuid", uuid);


        log.info("REQUEST [{}] {} {} [{}]", uuid, method, requestURI, request.getDispatcherType());
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        if (ex != null) {
            log.error("afterCompletion Error!!",ex);
        }
        log.info("RESPONE [{}] {} {} [{}]", request.getAttribute("uuid"), request.getMethod(), request.getRequestURI(), request.getDispatcherType());

    }
}
