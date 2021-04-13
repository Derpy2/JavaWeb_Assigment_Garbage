package com.javaweb.garbage1.mapper;

import com.javaweb.garbage1.dto.GarbageDTO;
import com.javaweb.garbage1.dto.UserDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserCheckMapper {

    /**
     * @Description: 获取表格数据
     */
    @Select({"<script>SELECT userID,userName,userPhone,userCard " +
            "FROM tb_user " +
            "WHERE (userName LIKE CONCAT('%', #{queryText}, '%') OR userID LIKE CONCAT('%', #{queryText}, '%')) " +
            "AND userStatus = 0 " +
            "ORDER BY userID " +
            "LIMIT #{start}, #{length} " +
            "</script>"})
    List<UserDTO> list4Table(@Param("start") Integer start,
                             @Param("length") Integer length,
                             @Param("queryText") String queryText) throws Exception;

    /**
     * @Description: 获取表格数据记录的总条数
     */
    @Select({"<script>SELECT COUNT(userID) " +
            "FROM tb_user " +
            "WHERE (userName LIKE CONCAT('%', #{queryText}, '%') OR userID LIKE CONCAT('%', #{queryText}, '%')) " +
            "AND userStatus = 0 "+
            "</script>"})
    Integer count4Table(@Param("queryText") String queryText) throws Exception;

    /*
     * 同意用户申请
     * */
    @Update({"<script>UPDATE tb_user SET userStatus=1 WHERE userID=#{userID}</script>"})
    Integer updateTrue(@Param("userID") Integer userID) throws Exception;

    /*
     * 拒绝用户申请
     * */
    @Update({"<script>UPDATE tb_user SET userStatus=2 WHERE userID=#{userID}</script>"})
    Integer updateFalse(@Param("userID") Integer userID) throws Exception;

}
