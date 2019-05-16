package com.example.demo.mapper.file;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.StateEntity;
//@Repository
@Mapper
public interface StateMapper {
	@Select("SELECT * FROM states")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	List<StateEntity> getAll();
	
	@Select("SELECT * FROM states WHERE id = #{id}")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	StateEntity getOne(String id);
 
	@Insert("INSERT INTO states(state,population) VALUES(#{state}, #{population})")
	void insert(StateEntity state);
 
	@Update("UPDATE states SET state=#{state},population=#{population} WHERE id =#{id}")
	void update(StateEntity state);
 
	@Delete("DELETE FROM states WHERE id =#{id}")
	void delete(String id);

}
