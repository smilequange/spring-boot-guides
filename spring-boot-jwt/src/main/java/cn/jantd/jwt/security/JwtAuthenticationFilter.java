package cn.jantd.jwt.security;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName = "authenticationFilter", urlPatterns = "/**")
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    if(request.getServletPath().equals("/login")){
      chain.doFilter(request,response);
      return;
    }
    String token = request.getParameter("token");
    if (!StringUtils.isEmpty(token)) {
      SecurityProperties.User authenticationToken = JwtTokenUtil.getAuthentication(token);
      if (null != authenticationToken) {
        chain.doFilter(request, response);
        return;
      }
    }
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized");
  }

}
