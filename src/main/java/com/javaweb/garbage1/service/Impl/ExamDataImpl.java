package com.javaweb.garbage1.service.Impl;

import com.javaweb.garbage1.dto.*;
import com.javaweb.garbage1.mapper.ExamDataMapper;
import com.javaweb.garbage1.service.ExamDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamDataImpl implements ExamDataService {
    @Autowired(required = false)
    private ExamDataMapper examDataMapper;

    @Override
    public TableRsqDTO list4Table(TableReqDTO tableReqDTO) throws Exception {
        Integer count = examDataMapper.count4Table(tableReqDTO.getQueryText());
        List<ExamDataDTO> listExamDataDTOs = examDataMapper.list4Table(tableReqDTO.getStart(),
                tableReqDTO.getPageSize(), tableReqDTO.getQueryText());
        return new TableRsqDTO(count, listExamDataDTOs);
    }

    @Override
    public TableRsqDTO scorelist4Table(TableReqDTO tableReqDTO) throws Exception {
        Integer count = examDataMapper.scorecount4Table(tableReqDTO.getQueryText());
        List<ExamScoreDTO> listExamDataDTOs = examDataMapper.scorelist4Table(tableReqDTO.getStart(),
                tableReqDTO.getPageSize(), tableReqDTO.getQueryText());
        return new TableRsqDTO(count, listExamDataDTOs);
    }

    @Override
    public TableRsqDTO prolist4Table(TableReqDTO tableReqDTO) throws Exception {
        Integer count = examDataMapper.procount4Table(tableReqDTO.getQueryText());
        List<ExamProDTO> listExamDataDTOs = examDataMapper.prolist4Table(tableReqDTO.getStart(),
                tableReqDTO.getPageSize(), tableReqDTO.getQueryText());
        return new TableRsqDTO(count, listExamDataDTOs);
    }
}
