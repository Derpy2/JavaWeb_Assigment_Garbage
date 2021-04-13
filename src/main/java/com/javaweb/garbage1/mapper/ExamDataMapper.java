package com.javaweb.garbage1.mapper;

import com.javaweb.garbage1.dto.ExamDataDTO;
import com.javaweb.garbage1.dto.ExamProDTO;
import com.javaweb.garbage1.dto.ExamScoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamDataMapper {
    /*
     * 根据用户ID获取正确的总题数和总题数
     *
     * */
    @Select({"<script> " +
            "SELECT userID as numUserID,SUM(case WHEN sortID=answerID THEN 1 ELSE 0 END) as numCorrect,COUNT(examID) as numTotText " +
            "FROM tb_exam " +
            "WHERE userID LIKE CONCAT('%', #{queryText}, '%') " +
            "GROUP BY userID " +
            "LIMIT #{start}, #{length} " +
            "</script>"})
    List<ExamDataDTO> list4Table(@Param("start") Integer start,
                                 @Param("length") Integer length,
                                 @Param("queryText") String queryText) throws Exception;

    /*
     * 獲取表格數據記錄的總條數
     * */
    @Select({"<script>SELECT COUNT(*) " +
            "FROM " +
            "(SELECT COUNT(examID) " +
            "FROM tb_exam " +
            "WHERE userID LIKE CONCAT('%', #{queryText}, '%') " +
            "GROUP BY userID)AS TEMP " +
            "</script>"})
    Integer count4Table(@Param("queryText") String queryText) throws Exception;

    /*
     * 根据用户ID獲取用戶每張考卷的成績和創建時間
     * */
    @Select("<script>SELECT userID as scoreUserID,SUM(case WHEN sortID=answerID THEN 1 ELSE 0 END) AS scoreUserScore,createTime AS scoreCreateTime " +
            "FROM tb_exam " +
            "WHERE userID like CONCAT('%', #{queryText},'%') " +
            "GROUP BY createTime " +
            "LIMIT #{start}, #{length} " +
            "</script>")
    List<ExamScoreDTO> scorelist4Table(@Param("start") Integer start,
                                       @Param("length") Integer length,
                                       @Param("queryText") String queryText) throws Exception;

    /*
     * 获取试卷数
     * */
    @Select({"<script>SELECT COUNT(*) " +
            "FROM " +
            "(SELECT COUNT(userID) " +
            "FROM tb_exam " +
            "WHERE userID like CONCAT('%', #{queryText},'%') " +
            "GROUP BY createTime) AS TEMP " +
            "</script>"})
    Integer scorecount4Table(@Param("queryText") String queryText) throws Exception;

    /*
     * 获取题目调用次数 得到题目ID(垃圾ID),垃圾名称，垃圾类型ID，以及调用次数
     * */
    @Select("<script>SELECT tb_exam.garbageID AS proGarbageID,garbageName AS proGarbageName,tb_exam.sortID AS proGarbageTypeID,COUNT(tb_exam.garbageID) AS proGarbageTime " +
            "FROM tb_exam,tb_garbage " +
            "WHERE tb_exam.garbageID=tb_garbage.garbageID " +
            "AND (tb_garbage.garbageName LIKE CONCAT('%', #{queryText}, '%') OR tb_garbage.garbageID LIKE CONCAT('%', #{queryText}, '%')) " +
            "GROUP BY tb_exam.garbageID " +
            "ORDER BY tb_exam.garbageID ASC "+
            "LIMIT #{start}, #{length} " +
            "</script>")
    List<ExamProDTO> prolist4Table(@Param("start") Integer start,
                                   @Param("length") Integer length,
                                   @Param("queryText") String queryText) throws Exception;

    /*
     * 获取题目数
     * */
    @Select({"<script>SELECT COUNT(*) " +
            "FROM( " +
            "SELECT tb_exam.garbageID  " +
            "FROM tb_exam,tb_garbage " +
            "WHERE tb_exam.garbageID=tb_garbage.garbageID " +
            "AND (tb_garbage.garbageName LIKE CONCAT('%', #{queryText}, '%') OR tb_garbage.garbageID LIKE CONCAT('%', #{queryText}, '%')) " +
            "GROUP BY tb_exam.garbageID " +
            ")AS TEMP " +
            "</script>"})
    Integer procount4Table(@Param("queryText") String queryText) throws Exception;
}
