package com.example.demo.mapper.file;

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

import com.example.demo.domain.StateEntity;
@Mapper
public interface StateMapper {
	@Select("SELECT * FROM state")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	List<StateEntity> getAll();
	
	@Select("SELECT * FROM state WHERE id = #{id}")
	@Results({
		//@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		//@Result(property = "nickName", column = "nick_name")
	})
	StateEntity getOne(String id);
 
	@SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
	@Insert("INSERT INTO state(id,state,population) VALUES(#{id},#{state}, #{population})")
	int insert(StateEntity state);
 
	@Update("UPDATE state SET state=#{state.state},population=#{state.population} WHERE id =#{state.id}")
	int update(StateEntity state);
 
	@Delete("DELETE FROM state WHERE id =#{id}")
	int delete(String id);

}
