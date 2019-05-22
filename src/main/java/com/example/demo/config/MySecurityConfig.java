package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.example.demo.security.MyAccessDecisionManager;
import com.example.demo.security.MyAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	private MyAuthenticationProvider myAuthenticationProvider;
	
	@Autowired
	private MyAccessDecisionManager myAccessDecisionManager;
	
	/*
	 * @Autowired public void configUser(AuthenticationManagerBuilder builder)
	 * throws Exception { builder .inMemoryAuthentication()
	 * //创建用户名为user，密码为password的用户 .passwordEncoder(new
	 * BCryptPasswordEncoder()).withUser("user").password(new
	 * BCryptPasswordEncoder().encode("123456")).roles("USER"); }
	 */
    
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
    	 //.csrf().disable()
         .authorizeRequests()
             .antMatchers("/", "/home").permitAll()
             .anyRequest().authenticated()
             .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
 				//通过spring secuirty提供的后处理bean的方式
 				//往FilterSecurityInterceptor中注入自定义的AccessDecisionManager
 				@Override
 				public <O extends FilterSecurityInterceptor> O postProcess(O filterSecurity) {
 					filterSecurity.setAccessDecisionManager(myAccessDecisionManager);
 					return filterSecurity;
 				}
 			}) 
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
             .authenticationProvider(myAuthenticationProvider)
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