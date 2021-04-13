package com.javaweb.garbage1.service;

import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.dto.TableReqDTO;
import com.javaweb.garbage1.dto.TableRsqDTO;

public interface UserCheckService {
    /*
     * 获取注册未审核的用户的表格数据
     * */
    TableRsqDTO list4Table(TableReqDTO tableReqDTO) throws Exception;

    /*
     * 同意用户注册
     * */
    Integer updateTrue(Integer userID) throws Exception;

    /*
     * 拒绝用户注册
     * */
    Integer updateFalse(Integer userID) throws Exception;
}
