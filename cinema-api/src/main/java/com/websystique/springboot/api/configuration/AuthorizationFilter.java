package com.websystique.springboot.api.configuration;

import com.websystique.springboot.api.model.User;
import com.websystique.springboot.api.service.UserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationFilter implements Filter {

    private final UserService userService;

    @Autowired
    public AuthorizationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String email = request.getHeader(HttpHeaders.FROM);

        User user = userService.getByEmail(email);
        request.setAttribute(User.CURRENT_USER, user);

        chain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
