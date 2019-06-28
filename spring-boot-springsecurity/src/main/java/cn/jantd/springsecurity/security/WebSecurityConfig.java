package cn.jantd.springsecurity.security;

import cn.jantd.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;
  @Autowired
  private AccessDeniedHandler requestAccessDeniedHandler;
  @Autowired
  private UsernameAuthenticationManager usernameAuthenticationManager;
  @Autowired
  private AuthenticationEntryPoint authenticationFailureEntryPoint;
  @Autowired
  private FilterInvocationSecurityMetadataSource uriSecurityMetadataSource;
  @Autowired
  private AccessDecisionManager roleAccessDecisionManager;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new MD5PasswordEncoder();
  }

  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return this.usernameAuthenticationManager;
  }

  @Override
  public UserDetailsService userDetailsServiceBean() throws Exception {
    return this.userService;
  }

  @Autowired
  public void configureAuthentication(AuthenticationManagerBuilder builder) throws Exception {
    builder.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(
            "/v2/api-docs",
            "/swagger-resources/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/configuration/security",
            "/swagger-ui.html");
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.cors().and()
            // 由于使用的是JWT,这里不需要csrf
            .csrf().disable()
            .formLogin().loginProcessingUrl("/login").and()
            //不需要验证
            .authorizeRequests()
            .antMatchers("/html/**").permitAll()
            //全部需要验证//todo FilterSecurityInterceptor 配置起作用 会使 anyRequest().authenticated() 失效
            .anyRequest().authenticated()//.withObjectPostProcessor(new FilterSecurityInterceptorProcessor())
            .and()
            .exceptionHandling().accessDeniedHandler(this.requestAccessDeniedHandler).and()
            .exceptionHandling().authenticationEntryPoint(authenticationFailureEntryPoint);

  }

  class FilterSecurityInterceptorProcessor implements ObjectPostProcessor<FilterSecurityInterceptor> {
    @Override
    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
      o.setSecurityMetadataSource(uriSecurityMetadataSource);
      o.setAccessDecisionManager(roleAccessDecisionManager);
      return o;
    }
  }

  @Override
  public void setAuthenticationConfiguration(AuthenticationConfiguration authenticationConfiguration) {
    super.setAuthenticationConfiguration(authenticationConfiguration);
  }
}
