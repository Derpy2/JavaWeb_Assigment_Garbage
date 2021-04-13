package com.javaweb.garbage1.controller;

import com.javaweb.garbage1.dto.OpResultDTO;
import com.javaweb.garbage1.dto.TableReqDTO;
import com.javaweb.garbage1.dto.TableRsqDTO;
import com.javaweb.garbage1.service.SortService;
import com.javaweb.garbage1.service.UserCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/admin")
public class UserCheckController {

    @Resource
    private UserCheckService userCheckService;
    private final Logger logger = LoggerFactory.getLogger(UserCheckController.class);

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public TableRsqDTO list4Table(TableReqDTO tableReqDTO) {
        TableRsqDTO tableRspDTO = new TableRsqDTO();
        try {
            tableRspDTO = userCheckService.list4Table(tableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

    @RequestMapping(value = "/updateTrue", method = RequestMethod.POST)
    public OpResultDTO updateTrue(Integer userID) {
        OpResultDTO opResultDTO = new OpResultDTO();
        try {
            opResultDTO.setIntResult(userCheckService.updateTrue(userID));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResultDTO;
    }

    @RequestMapping(value = "/updateFalse", method = RequestMethod.POST)
    public OpResultDTO updateFalse(Integer userID) {
        OpResultDTO opResultDTO = new OpResultDTO();
        try {
            opResultDTO.setIntResult(userCheckService.updateFalse(userID));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResultDTO;
    }
}
