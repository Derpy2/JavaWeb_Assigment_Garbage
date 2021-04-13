package com.javaweb.garbage1.service;

import com.javaweb.garbage1.dto.TableReqDTO;
import com.javaweb.garbage1.dto.TableRsqDTO;

public interface ExamDataService {
    /*
     * 获取表格数据
     *
     * */
    TableRsqDTO list4Table(TableReqDTO tableReqDTO) throws Exception;

    /*
     * 獲取試卷成績
     *
     * */
    TableRsqDTO scorelist4Table(TableReqDTO tableReqDTO) throws Exception;

    /*
     * 获取题目调用信息
     *
     * */
    TableRsqDTO prolist4Table(TableReqDTO tableReqDTO) throws Exception;
}
