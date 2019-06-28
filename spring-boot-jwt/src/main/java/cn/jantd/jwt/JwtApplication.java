package cn.jantd.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    /*@Bean
    public FilterRegistrationBean loginFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JwtLoginFilter());
        bean.addUrlPatterns("/login");
        return bean;
    }

    @Bean
    public FilterRegistrationBean authenticationFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JwtAuthenticationFilter());
//        bean.addUrlPatterns("/**");
        return bean;
    }*/

}
