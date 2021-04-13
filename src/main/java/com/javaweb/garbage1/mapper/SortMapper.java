package com.javaweb.garbage1.mapper;

import com.javaweb.garbage1.dto.GarbageDTO;

import com.javaweb.garbage1.entity.Garbage;
import com.javaweb.garbage1.entity.GarbageEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SortMapper {
    /**
     * @Description: 获取表格数据
     */
    @Select({"<script>SELECT garbageID,garbageName,sortID,imageUrl,createTime " +
            "FROM tb_garbage " +
            "WHERE garbageName LIKE CONCAT('%', #{queryText}, '%') OR garbageID LIKE CONCAT('%', #{queryText}, '%') " +
            "ORDER BY garbageID " +
            "LIMIT #{start}, #{length} " +
            "</script>"})
    List<GarbageDTO> list4Table(@Param("start") Integer start,
                                @Param("length") Integer length,
                                @Param("queryText") String queryText) throws Exception;

    /**
     * @Description: 获取表格数据记录的总条数
     */
    @Select({"<script>SELECT COUNT(garbageID) " +
            "FROM tb_garbage " +
            "WHERE garbageName LIKE CONCAT('%', #{queryText}, '%') OR garbageID LIKE CONCAT('%', #{queryText}, '%') " +
            "</script>"})
    Integer count4Table(@Param("queryText") String queryText) throws Exception;

    /**
     * @Description: 添加记录
     */
    @Insert("INSERT INTO tb_garbage(garbageName, sortID,createTime) VALUES (#{garbageEntity.garbageName}, #{garbageEntity.sortID},#{garbageEntity.createTime})")
    Integer add(@Param("garbageEntity") GarbageEntity garbageEntity) throws Exception;

    /**
     * @Description: 编辑记录
     */
    @Update("UPDATE tb_garbage SET garbageName = #{garbageEntity.garbageName}, sortID = #{garbageEntity.sortID} ,createTime=#{garbageEntity.createTime} WHERE garbageID = #{garbageEntity.garbageID}")
    Integer edit(@Param("garbageEntity") GarbageEntity garbageEntity) throws Exception;


    /**
     * @Description: 删除记录
     */
    @Update({"DELETE FROM tb_garbage WHERE garbageID = #{garbageID}"})
    Integer remove(@Param("garbageID") Integer garbageID) throws Exception;

    /*
     * 更新garbageUrl
     *
     * */
    @Select("<script>UPDATE tb_garbage " +
            "SET imageUrl=#{garbageUrl} " +
            "WHERE garbageID=#{garbageID}" +
            "</script>")
    Integer upload(@Param("garbageUrl") String garbageUrl, @Param("garbageID") Integer garbageID) throws Exception;

}
