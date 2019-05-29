package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Department;
import com.example.demo.domain.MyGrantedAuthority;
import com.example.demo.domain.User;
import com.example.demo.mapper.test.DepartmentMapper;
import com.example.demo.mapper.test.UserMapper;
import com.example.demo.security.MyUserDetails;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/add")
	public int add( User user ) {//@RequestParam
		int result=userMapper.insert(user);
		return result;
	}
	@RequestMapping("/get")
	public List<User> get( ) {
		List<User> result=userMapper.getAll();
		return result;
	}
	@RequestMapping("/update")
	public int update( User user ) {
		int result=userMapper.update(user);
		return result;
	}
	/**
	 *获取登录用户名
	 */
	@RequestMapping("/showLoginName")
    public String showName(){
		//
		WebAuthenticationDetails o=(WebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		System.out.println(o.getSessionId());
		//用户
		MyUserDetails userDetail=(MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("userName"+"  "+userDetail.getUsername()+"  " +userDetail.getPassword());
        //密码
        System.out.println("password"+SecurityContextHolder.getContext().getAuthentication().getCredentials());
        //用户名
        String name = SecurityContextHolder.getContext()
              .getAuthentication().getName();
        //权限
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities();
        authorities.forEach(a->System.out.println(a.getAuthority()));
        return name;
    }

}
