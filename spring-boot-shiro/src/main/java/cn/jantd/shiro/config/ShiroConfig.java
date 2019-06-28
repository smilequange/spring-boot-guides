package cn.jantd.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
    ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
    factoryBean.setSecurityManager(securityManager);
    factoryBean.setLoginUrl("/login");
    factoryBean.setUnauthorizedUrl("/unauthorized");

    Map<String,String> filterChainDefinitionMap = new HashMap<>();
    filterChainDefinitionMap.put("/login","anon");
    filterChainDefinitionMap.put("/user/**","roles[user]");
    filterChainDefinitionMap.put("/**","authc");
    factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return factoryBean;
  }

  @Bean
  public SecurityManager securityManager(){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(customRealm());
    return securityManager;
  }

  @Bean
  public CustomRealm customRealm(){
    return new CustomRealm();
  }


}
