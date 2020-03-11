package com.hhw.javaleaning.mapper;

import com.hhw.javaleaning.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @author hhw
 * @date 2020/2/26 上午11:59
 */

@Mapper
public interface UserMapper {

    @Insert("insert into public.user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values ('hhw','125081','1',1,1)")
    void insertTest();

    @Select("select * from user where token=#{token}")
    User findByToken(String token);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(String accountId);

    @Update("update user set token=#{token} where account_id=#{accountId}")
    Integer updateUserByAccountId(String token, String accountId);
}
