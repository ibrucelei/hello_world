package com.example.demo.mapper.file;

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

import com.example.demo.domain.Media;
import com.example.demo.domain.State;
@Mapper
@CacheNamespace
public interface MediaMapper {
	@Select("SELECT * FROM media")
	@Results({
		@Result(javaType = Media.class)
	})
	List<Media> getAll();
	
	@Select("SELECT * FROM media WHERE id = #{id}")
	@Results({
		@Result(javaType = Media.class)
	})
	Media getOne(String id);
 
	@SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
	@Insert("INSERT INTO media(id,state,population) VALUES(#{id},#{state}, #{population})")
	int insert(Media media);
 
	@Update("UPDATE media SET media=#{state.state},population=#{state.population} WHERE id =#{state.id}")
	int update(Media media);
 
	@Delete("DELETE FROM media WHERE id =#{id}")
	int delete(String id);

	
}
