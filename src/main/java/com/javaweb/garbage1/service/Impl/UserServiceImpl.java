package com.javaweb.garbage1.service.Impl;

import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.dto.UserDTO;
import com.javaweb.garbage1.entity.User;
import com.javaweb.garbage1.mapper.UserMapper;
import com.javaweb.garbage1.service.UserService;
import com.javaweb.garbage1.utils.MD5Util;
import com.javaweb.garbage1.utils.VertifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String userName) throws Exception{
        User user = userMapper.findUserByUserName(userName);
        return user;
    }

    @Override
    public Integer loginCheck(String userName, String userPwd, String vertifyCode, HttpSession session) throws Exception{

        //检测验证码
        String realVertifyCode = (String)session.getAttribute("RANDOMVALIDATECODEKEY");
        if(!(realVertifyCode.equals(vertifyCode))) {
            return 0;
        }
        //检测用户密码
        User realUser = userMapper.findUserByUserName(userName);
        if(realUser == null) realUser = userMapper.findUserByUserPhone(userName);
        if(realUser == null) realUser = userMapper.findUserByUserCard(userName);
        if(realUser != null && userPwd.equalsIgnoreCase(realUser.getUserPwd()) && realUser.getUserStatus() != 0) {
            session.setAttribute("userID", realUser.getUserID());
            session.setAttribute("userName", realUser.getUserName());
            session.setAttribute("userType", realUser.getUserType());
            return realUser.getUserType();
        }
        return 0;
    }

    @Override
    public Integer registerUser(UserDTO registerUser)throws Exception{

        User user = userMapper.findUserByUserName(registerUser.getUserName());
        if(user != null) return 0;
        String md5Pwd = MD5Util.getMD5Str(registerUser.getUserPwd());
        userMapper.insertUser(registerUser.getUserName(), registerUser.getUserPhone(), md5Pwd, registerUser.getUserCard());
        return 1;
    }

    @Override
    public void getVerify(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        VertifyCodeUtil randomValidateCode = new VertifyCodeUtil();
        randomValidateCode.getRandcode(request, response);//输出验证码图片方法
    }

    @Override
    public OpResultDTO getUserNameFromSession(HttpSession session)throws Exception{
        Integer userID = (Integer)session.getAttribute("userID");
        String userName = (String)session.getAttribute("userName");
        Integer userType = (Integer)session.getAttribute("userType");
        Map p = new HashMap();
        p.put("userID", userID);
        p.put("userName", userName);
        //Pair<Integer,String> p = new Pair<Integer, String>(userID, userName);
        OpResultDTO result = new OpResultDTO();
        result.setIntResult(userType);
        result.setObjResult(p);
        return result;
    }
}
