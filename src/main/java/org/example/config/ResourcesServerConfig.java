package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * @param http
     * @author fomeiherz
     * @date 2022/4/11 8:00 PM
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //所有的访问都需要认证访问
        http.authorizeRequests().anyRequest().authenticated();
        //唯独 user 可以访问，放行我们的资源
        http.requestMatchers().antMatchers("/user/**");
    }
}