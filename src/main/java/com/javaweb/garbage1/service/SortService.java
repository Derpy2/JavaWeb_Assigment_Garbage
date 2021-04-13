package com.javaweb.garbage1.service;

import com.javaweb.garbage1.dto.*;

public interface SortService {
    /*
     * 获取表格数据
     * */
    TableRsqDTO list4Table(TableReqDTO tableReqDTO) throws Exception;

    /**
     * @Description: 添加记录
     */
    Integer add(GarbageDTO garbageDTO) throws Exception;

    /**
     * @Description: 编辑记录
     */
    Integer edit(GarbageDTO garbageDTO) throws Exception;

    /**
     * @Description: 删除记录
     */
    Integer remove(Integer garbageID) throws Exception;

    /*
     * 更新图片Url
     *
     * */
    Integer upload(String garbageUrl, Integer garbageID) throws Exception;
}
