package com.javaweb.garbage1.mapper;

import com.javaweb.garbage1.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 获取全部用户
     * @return
     */
    @Select("select * from tb_user")
    List<User> findAll();

    /**
     * 注册用户
     *
     */
    @Insert({"<script>INSERT INTO tb_user " +
            "(userName, userPhone, userPwd, userCard, userStatus, userType) " +
            "VALUES (#{userName}, #{userPhone}, #{userPwd}, #{userCard},0, 2)" +
            "</script>"})
    int insertUser(@Param("userName") String userName, @Param("userPhone") String userPhone,
                   @Param("userPwd") String userPwd, @Param("userCard") String userCard) throws Exception;

    /**
     * 按用户名查找用户
     */
    @Select({"<script>SELECT * FROM tb_user where userName=#{userName}</script>"})
    User findUserByUserName(@Param("userName") String userName);

    /**
     * 按手机号查找用户
     */
    @Select({"<script>SELECT * FROM tb_user where userName=#{userPhone}</script>"})
    User findUserByUserPhone(@Param("userPhone") String userPhone);

    /**
     * 按身份证号查找用户
     */
    @Select({"<script>SELECT * FROM tb_user where userName=#{userCard}</script>"})
    User findUserByUserCard(@Param("userCard") String userCard);

    /**
     * 添加用户
     */


    /**
     * 删除用户
     */

    /**
     * 查找用户
     */


    /**
     * 修改用户
     */

    /**
     * 获取所有未审核用户
     */



}