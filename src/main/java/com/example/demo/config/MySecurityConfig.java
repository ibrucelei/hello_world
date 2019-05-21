package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    public void configUser(AuthenticationManagerBuilder builder) throws Exception {
        builder
            .inMemoryAuthentication()
                //创建用户名为user，密码为password的用户
            .passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }
    
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("user") .password("password")
	 * .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .authorizeRequests()
             .antMatchers("/", "/home").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
             .permitAll();
    }
    @Override
	public void configure(WebSecurity web) throws Exception {
		//配置不受secuirty拦截的路径
		web.ignoring()
		.antMatchers("/**/*.scss")
		.antMatchers("/**/*.jpg")
		.antMatchers("/**/*.gif")
		.antMatchers("/**/*.css")
		.antMatchers("/**/*.ico")
		.antMatchers("/**/*.js")
		.antMatchers("/**/*.ttf")
		.antMatchers("/**/*.svg")
		.antMatchers("/**/*.htm")
		.antMatchers("/**/*.html")
		.antMatchers("/**/*.eot")
		.antMatchers("/**/*.woff*")
		.antMatchers("/**/*.less")
		.antMatchers("/**/*.map")
		.antMatchers("/error")
		.antMatchers("/index")
		.antMatchers("/404")
		.antMatchers("/500")
		.antMatchers("/sessionTimeout")
		.antMatchers("/timeout")
		.antMatchers("/html/**")
		.antMatchers("/**/*.png")
		.antMatchers("/")
		.antMatchers("/jquery/**");
	}
}