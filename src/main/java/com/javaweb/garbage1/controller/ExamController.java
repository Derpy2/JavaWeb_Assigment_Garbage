package com.javaweb.garbage1.controller;

import com.javaweb.garbage1.dto.TableRsqExamDTO;
import com.javaweb.garbage1.entity.Exam;
import com.javaweb.garbage1.service.ExamService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("exam")
public class ExamController {

    @Resource
    private ExamService examService;
    private Logger logger = LoggerFactory.getLogger(Exam.class);

    @CrossOrigin
    @RequestMapping("insertExamItem")
    public void insertExamItem(TableRsqExamDTO exam){
        try{
            examService.insertExamItem(exam);
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
}
