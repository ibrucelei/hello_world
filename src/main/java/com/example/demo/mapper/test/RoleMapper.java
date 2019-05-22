package com.example.demo.mapper.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import com.example.demo.domain.Department;
import com.example.demo.domain.Role;

@Mapper
@CacheNamespace
public interface RoleMapper {
	@Select("SELECT id,role_name roleName,create_date createDate,modify_date modifyDate FROM role")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	List<Role> getAll();
	
	@Select("SELECT id,role_name roleName,create_date createDate,modify_date modifyDate FROM role WHERE id = #{id}")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	Role getOne(String id);
 
	@SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
	@Insert("INSERT INTO role(id,role_name) VALUES(#{id},#{roleName})")
	int insert(Role role);
 
	@SelectKey(keyProperty = "modifyDate",resultType = Date.class, before = true,
            statement = "select now()")
	@Update("UPDATE states SET role_name=#{roleName},modify_date=#{modifyDate} WHERE id =#{id}")
	int update(Role role);
 
	@Delete("DELETE FROM role WHERE id =#{id}")
	int delete(String id);

	@Select("SELECT r.role_name roleName,r.id from user_role ur,role r where ur.user_id=r.id and ur.user_id=#{userId}")
	List<Role> listByUserId(String userId);

}
