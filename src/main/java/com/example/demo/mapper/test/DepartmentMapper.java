package com.example.demo.mapper.test;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Department;
import com.example.demo.domain.StateEntity;

@Mapper
public interface DepartmentMapper {
	@Select("SELECT * FROM department")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	List<Department> getAll();
	
	@Select("SELECT * FROM department WHERE id = #{id}")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	Department getOne(String id);
 
	@SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
	@Insert("INSERT INTO department(id,name,employer_id) VALUES(#{id},#{name}, #{employerId})")
	int insert(Department department);
 
	@Update("UPDATE states SET name=#{name},population=#{employerId} WHERE id =#{id}")
	int update(Department department);
 
	@Delete("DELETE FROM states WHERE id =#{id}")
	int delete(String id);

}
