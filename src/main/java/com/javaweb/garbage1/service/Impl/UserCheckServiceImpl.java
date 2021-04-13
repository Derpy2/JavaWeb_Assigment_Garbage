package com.javaweb.garbage1.service.Impl;

import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.dto.TableReqDTO;
import com.javaweb.garbage1.dto.TableRsqDTO;
import com.javaweb.garbage1.dto.UserDTO;
import com.javaweb.garbage1.mapper.UserCheckMapper;
import com.javaweb.garbage1.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCheckServiceImpl implements UserCheckService {
    @Autowired(required = false)
    private UserCheckMapper userCheckMapper;

    @Override
    public TableRsqDTO list4Table(TableReqDTO tableReqDTO) throws Exception {
        Integer count = userCheckMapper.count4Table(tableReqDTO.getQueryText());
        List<UserDTO> listuserDTO = userCheckMapper.list4Table(tableReqDTO.getStart(),
                tableReqDTO.getPageSize(), tableReqDTO.getQueryText());
        return new TableRsqDTO(count, listuserDTO);
    }

    @Override
    public Integer updateTrue(Integer userID) throws Exception {
        return userCheckMapper.updateTrue(userID);
    }

    @Override
    public Integer updateFalse(Integer userID) throws Exception {
        return userCheckMapper.updateFalse(userID);
    }
}
