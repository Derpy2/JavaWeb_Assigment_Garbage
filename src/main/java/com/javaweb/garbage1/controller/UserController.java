package com.javaweb.garbage1.controller;

import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.dto.UserDTO;
import com.javaweb.garbage1.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ResponseBody
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin


    /**
     * 按用户名查找用户
     * @param userName 用户名
     * @return
     */
    /*
    @RequestMapping("findUserByNmae")
    public Map findUserByName(String userName){
        Map map = new HashMap();
        User user = userMapper.findUserByUserName(userName);
        if(user == null) {
            map.put("code", 200);
            map.put("message", "not found");
        }
        else{
            map.put("userID", user.getUserID());
            map.put("userName", user.getUserName());
            map.put("userCard", user.getUserCard());
            map.put("userPwd", user.getUserPwd());
            map.put("userPhone", user.getUserPhone());
            map.put("userStatus", user.getUserStatus());
            map.put("userType", user.getUserType());
        }
        return map;
    }
    */

    /**
     * 登陆验证
     * @param userName
     * @param userPwd
     * @param vertifyCode
     * @param session
     * @return
     */
    @RequestMapping("login")
    public OpResultDTO login(@RequestParam String userName, @RequestParam String userPwd,@RequestParam String vertifyCode, HttpSession session){

        OpResultDTO res = new OpResultDTO();
        res.setIntResult(0);
        String href = new String("./pages/mainPage.html");
        res.setObjResult(href);
        try {
            res.setIntResult(userService.loginCheck(userName, userPwd, vertifyCode, session));
            if(res.getIntResult() == 1){
                res.setObjResult((String)"./pages/AdminQuesKido.html");
            }
            logger.info(res.getIntResult().toString()+"     "+res.getObjResult().toString());
        }catch (Exception e){
            logger.error(e.toString());
        }
        return res;
    }

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("registeUser")
    public Integer registerUser(UserDTO registerUser){
        Integer res = new Integer(0);
        try{
            res = userService.registerUser(registerUser);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return res;
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     */
    @RequestMapping("getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            userService.getVerify(request, response);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    /**
     * 获得当前登录用户的用户名以及权限
     *
     */
    @RequestMapping("getUserNameFromSession")
    public OpResultDTO getUserNameFromSession(HttpSession session){
        OpResultDTO result = null;
        try{
            result = userService.getUserNameFromSession(session);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return result;
    }
}
