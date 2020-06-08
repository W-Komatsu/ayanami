package pers.wk.ayanami.orm.mapper;

import org.apache.ibatis.annotations.*;
import pers.wk.ayanami.orm.model.User;

/**
 * @author wangxiaosong
 * @date 2020/4/16
 */
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getUserById(Long id);

    @Insert({"insert into user(name, age, address, create_time, update_time) values(#{name}, #{age}, #{address}, #{createTime}, #{updateTime})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Long addUser(User user);

    @Update("update user set name=#{name}, age=#{age}, address=#{address}, update_time=#{updateTime} where id=#{id}")
    Integer updateUserById(User user);

    @Delete("delete from user where id=#{id}")
    Integer deleteUserById(Integer id);
}
