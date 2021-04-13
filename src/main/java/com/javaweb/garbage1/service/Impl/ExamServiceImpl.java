package com.javaweb.garbage1.service.Impl;

import com.javaweb.garbage1.dto.ExamDTO;
import com.javaweb.garbage1.dto.TableRsqExamDTO;
import com.javaweb.garbage1.entity.Exam;
import com.javaweb.garbage1.mapper.ExamMapper;
import com.javaweb.garbage1.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired(required = false)
    private ExamMapper examMapper;

    @Override
    public void insertExamItem(TableRsqExamDTO exam) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
        String createTime = df.format(new Date());

        for(int i = 0;i < exam.getListTable().size();i++)
        {
            ExamDTO tmp = exam.getListTable().get(i);
            tmp.setCreateTime(createTime);
            examMapper.insertExam(tmp.getExamSN(),tmp.getGarbageID(),tmp.getUserID(),
                    tmp.getSortID(),tmp.getAnswerID(),tmp.getCreateTime());
        }
    }

}
