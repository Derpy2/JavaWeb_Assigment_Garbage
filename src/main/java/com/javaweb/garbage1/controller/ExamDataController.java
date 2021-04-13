package com.javaweb.garbage1.controller;

import com.javaweb.garbage1.dto.TableReqDTO;
import com.javaweb.garbage1.dto.TableRsqDTO;
import com.javaweb.garbage1.service.ExamDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/exam")
public class ExamDataController {

    @Resource
    private ExamDataService examDataService;
    private final Logger logger = LoggerFactory.getLogger(ExamDataService.class);

    /*
     * 查詢用戶ID,正確的題數以及縂題數
     *
     * */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public TableRsqDTO list4Table(TableReqDTO tableReqDTO) {
        TableRsqDTO tableRspDTO = new TableRsqDTO();
        try {
            tableRspDTO = examDataService.list4Table(tableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

    /*
     * 查詢用戶的各張試卷的成績和創建時間
     *
     * */
    @RequestMapping(value = "/scorequery", method = RequestMethod.POST)
    public TableRsqDTO scorelist4Table(TableReqDTO tableReqDTO) {
        TableRsqDTO tableRspDTO = new TableRsqDTO();
        try {
            tableRspDTO = examDataService.scorelist4Table(tableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

    /*
     * 查询题目调用次数 得到题目ID,垃圾名称，垃圾类型，以及调用次数
     *
     * */
    @RequestMapping(value = "/proquery", method = RequestMethod.POST)
    public TableRsqDTO prolist4Table(TableReqDTO tableReqDTO) {
        TableRsqDTO tableRspDTO = new TableRsqDTO();
        try {
            tableRspDTO = examDataService.prolist4Table(tableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

}
