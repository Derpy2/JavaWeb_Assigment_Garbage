package com.javaweb.garbage1.mapper;

import com.javaweb.garbage1.entity.Exam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ExamMapper {
    /**
     * 获取考试表记录
     * @return
     */
    @Select("select * from tb_exam")
    List<Exam> findAll();

    /**
     * 插入考试
     * @param examSN
     * @param garbageID
     * @param userID
     * @param sortID
     * @param answerID
     * @param createTime
     * @return
     */
    @Insert("<script>INSERT INTO tb_exam( examSN, garbageID, userID, sortID, answerID, createTime) " +
            "VALUES (#{examSN}, #{garbageID}, #{userID}, #{sortID}, #{answerID}, #{createTime})</script>")
    void insertExam(@Param("examSN")String examSN, @Param("garbageID")Integer garbageID, @Param("userID")Integer userID,
                   @Param("sortID")Integer sortID, @Param("answerID")Integer answerID, @Param("createTime")String createTime);

    /**
     * 获得考试条目总数
     * @return
     */
    @Select("<script>SELECT COUNT(examID)  FROM tb_exam</script>")
    int getTotalExamItem();

    /**
     * 获取某用户的答题信息
     */

    /**
     * 统计题目调用次数
     */
}

