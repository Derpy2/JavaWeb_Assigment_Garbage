package com.javaweb.garbage1.entity;


public class Exam {
    private Integer examID;
    private String examSn;
    private Integer  garbageID;
    private Integer userID;
    private Integer sortID;
    private Integer answerID;
    private String createTime;

    public Exam() {
    }

    public Exam(Integer examID, String examSn, Integer garbageID, Integer userID, Integer sortID, Integer answerID, String createTime) {
        this.examID = examID;
        this.examSn = examSn;
        this.garbageID = garbageID;
        this.userID = userID;
        this.sortID = sortID;
        this.answerID = answerID;
        this.createTime = createTime;
    }

    public Integer getExamID() {
        return examID;
    }

    public void setExamID(Integer examID) {
        this.examID = examID;
    }

    public String getExamSn() {
        return examSn;
    }

    public void setExamSn(String examSn) {
        this.examSn = examSn;
    }

    public Integer getGarbageID() {
        return garbageID;
    }

    public void setGarbageID(Integer garbageID) {
        this.garbageID = garbageID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getSortID() {
        return sortID;
    }

    public void setSortID(Integer sortID) {
        this.sortID = sortID;
    }

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
