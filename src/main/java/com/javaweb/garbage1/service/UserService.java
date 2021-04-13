package com.javaweb.garbage1.service;


import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.dto.UserDTO;
import com.javaweb.garbage1.entity.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {

    /**
     * 按用户名查找用户
     */
    User findUserByUserName(String userName)throws Exception;

    /**
     * 用户登录
     */
    Integer loginCheck(String userName, String userPwd, String vertifyCode, HttpSession session) throws Exception;

    /**
     * 用户注册
     */
    Integer registerUser(UserDTO registerUser)throws Exception;

    /**
     * 生成验证码图片
     */
    void getVerify(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * 获得当前登录用户的用户名以及权限
     */
    OpResultDTO getUserNameFromSession(HttpSession session)throws Exception;

}
