package com.javaweb.garbage1.mapper;


import com.javaweb.garbage1.entity.Garbage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GarbageMapper {
    @Select("select * from tb_garbage")
    List<Garbage> findAll();

    /**
     * 添加垃圾
     * @param garbageName 垃圾名
     * @param sortID 垃圾类型
     * @param createTime 创建时间
     * @throws Exception
     */
    @Insert("<script>Insert INTO tb_garbage(garbageName, sortID, createTime) " +
            "VALUES (#{garbageName}, #{sortID}, #{createTime})</script>")
    void addGarbage(@Param("garbageName")String garbageName, @Param("sortID")int sortID, @Param("createTime")String createTime)throws Exception;

    /**
     * 查询垃圾
     * @param garbageName 垃圾名
     * @throws Exception
     */
    @Select("<script>SELECT * from tb_garbage " +
            "WHERE garbageName=#{garbageName}</script>")
    void searchGarbageByGarbageName(@Param("garbageName")String garbageName)throws Exception;

    /**
     * 删除垃圾
     * @param garbageName 垃圾名
     * @throws Exception
     */
    @Delete("<script>DELETE FROM tb_garbage " +
            "WHERE garbageName=#{garbageName}</script>")
    void deleteGarbageByGarbageName(@Param("garbageName")String garbageName)throws Exception;

    /**
     * 更新垃圾信息
     * @param oldGarbageName 查询用垃圾名
     * @param newGarbageName 新垃圾名
     * @param imgUrl 垃圾图片地址
     * @param sortID 垃圾类别
     * @param createTime 垃圾建立时间
     * @throws Exception
     */
    @Update("<script>UPDATE tb_garbage " +
            "SET garbageName=#{newGarbageName}, imageUrl=#{imageUrl}, sortID=#{sortID}, createTime=#{createTime} " +
            "WHERE garbageName=#{oldGarbageName}" +
            "</script>")
    void updateGarbageByGarbageName(@Param("oldGarbageName")String oldGarbageName, @Param("newGarbageName")String newGarbageName,
    @Param("imageUrl")String imgUrl, @Param("sortID")int sortID, @Param("createTime")String createTime)throws Exception;

    /**
     * 获得垃圾总数
     * @return 垃圾总数
     * @throws Exception
     */
    @Select("<script>SELECT COUNT(*)  FROM tb_garbage</script>")
    int getTotalCountGarbage()throws Exception;

    /**
     * 获得指定垃圾
     * @param garbageNum
     * @return
     */
    @Select("<script>SELECT * FROM tb_garbage ORDER BY garbageID LIMIT #{garbageNum}, 1</script>")
    Garbage getAGarbage(@Param("garbageNum")int garbageNum) throws Exception;
}

