package com.example.demo.mapper.test;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.User;

@Mapper
@CacheNamespace
public interface UserMapper {
	//@Select("SELECT id,user_name userName,password,create_date createDate,modify_date modifyDate  FROM user")
	@Select("SELECT * FROM user")
	@Results({
		@Result(property = "userName",  column = "user_name"),
		@Result(property = "createDate", column = "create_date"),
		@Result(property = "modifyDate", column = "modify_date")
	})
	List<User> getAll();
	
	@Select("SELECT id,user_name userName,password,create_date createDate,modify_date modifyDate  FROM user WHERE id = #{id}")
	User getOne(String id);
 
	@SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
	@Insert("INSERT INTO user(id,user_name,password) VALUES(#{id},#{userName}, #{password})")
	int insert(User user);
 
	/*
	 * 时间不对，原因未知
	 * @SelectKey(keyProperty = "modifyDate",resultType = Date.class, before = true,
	 * statement = "select now()")
	 */
	@Update("UPDATE user SET user_name=#{userName},password=#{password},modify_date=#{modifyDate} WHERE id =#{id}")
	int update(User user);
 
	@Delete("DELETE FROM states WHERE id =#{id}")
	int delete(String id);

	@Select("SELECT id,user_name userName,password,create_date createDate,modify_date modifyDate FROM user where user_name =#{userName}")
	User getByUsername(String userName);

	
}
