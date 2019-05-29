package com.example.demo.mapper.file;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

import com.example.demo.domain.Media;
import com.example.demo.domain.State;
@Mapper
@CacheNamespace
public interface MediaMapper {
	@Select("SELECT * FROM media")
	@Results({
		@Result(property = "contentType", column = "content_type"),
		@Result(property = "userId", column = "user_id"),
		@Result(property = "categoryId", column = "category_id"),
		@Result(property = "labelId", column = "label_id"),
		@Result(property = "createDate", column = "create_date"),
		@Result(property = "modifyDate", column = "modify_date")
	})
	List<Media> getAll();
	
	@SelectProvider(type = MediaQueryDaoProvider.class, method = "query")
	List<Media> query();
	
	@Select("SELECT * FROM media WHERE id = #{id}")
	@Results({
		@Result(property = "contentType", column = "content_type"),
		@Result(property = "userId", column = "user_id"),
		@Result(property = "categoryId", column = "category_id"),
		@Result(property = "labelId", column = "label_id"),
		@Result(property = "createDate", column = "create_date"),
		@Result(property = "modifyDate", column = "modify_date")
	})
	Media getOne(String id);
 
	/*
	 * @SelectKey(keyProperty = "id",resultType = String.class, before = true,
	 * statement = "select replace(uuid(), '-', '')")
	 * 
	 * @Insert("INSERT INTO media(id,state,population) VALUES(#{id},#{state}, #{population})"
	 * ) int insert(Media media);
	 */
 
	@Insert("insert into media(id,name, path, content_type, content, user_id,description,title,category_id,label_id,nRemark,nLike,nStore,nBrowse,create_date,modify_date) " +
	            "values(#{id},#{name}, #{path}, #{contentType}, #{content},#{userId},#{description},#{title},#{categoryId},#{labelId},#{nRemark},#{nLike},#{nStore},#{nBrowse},#{createDate},#{modifyDate})")
	//@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id") 有问题，null
	@SelectKey(keyProperty = "id",resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	public int insert(Media media);

	   
	@Update("UPDATE media SET name=#{name},path= #{path}, content_type=#{contentType}, content=#{content},user_id= #{userId},description=#{description},title=#{title},category_id=#{categoryId},label_id=#{labelId},nRemark=#{nRemark},nLike=#{nLike},nStore=#{nStore},nBrowse=#{nBrowse},create_date=#{createDate},modify_date=#{modifyDate} WHERE id =#{id}")
	int update(Media media);
 
	@Delete("DELETE FROM media WHERE id =#{id}")
	int delete(String id);
	
	class MediaQueryDaoProvider {
        public String query(Media media) {
        	return new SQL(){{      
                SELECT("id,name");
                SELECT("path,type");
                FROM("media"); 
                if(media.getId()!=null){
                    WHERE("id = #{id}");
                }
                if(media.getName()!=null){
                    WHERE("name = #{name}");
                }
            //从这个toString可以看出，其内部使用高效的StringBuilder实现SQL拼接      
            }}.toString();
        }  
    }  
	
}
