package cn.jantd.jwt.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

@Component
@WebFilter(filterName = "loginFilter",urlPatterns = "/login")
public class JwtLoginFilter implements Filter {

  public void checkUser(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if ("admin".equals(username) && "123456".equals(password)) {
      SecurityProperties.User user = new SecurityProperties.User();
      user.setName(username);
      user.setPassword(password);
      user.setRoles(Arrays.asList("role"));
      successfulAuthentication(request, response, chain, user);
    } else {
      unsuccessfulAuthentication(request, response);
    }

  }

  protected void successfulAuthentication(ServletRequest request, ServletResponse response, FilterChain chain, SecurityProperties.User user) throws IOException {
    String token = JwtTokenUtil.createToken(new ObjectMapper().writeValueAsString(user));
    write((HttpServletResponse) response, String.format("%s %s", JwtTokenUtil.getTokenPrefix(), token));
  }

  protected void unsuccessfulAuthentication(ServletRequest request, ServletResponse response) throws IOException {
    write((HttpServletResponse) response, "failure");
  }

  public static void write(HttpServletResponse response, Object result) throws IOException {
    response.setHeader("ContentType", MediaType.APPLICATION_JSON_UTF8_VALUE);
    Writer writer = response.getWriter();
    writer.write(new ObjectMapper().writeValueAsString(result));
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    if("/login".equals(((RequestFacade)request).getServletPath())){
      checkUser(request, response, filterChain);
    }else{
      filterChain.doFilter(request,response);
    }
  }
}
