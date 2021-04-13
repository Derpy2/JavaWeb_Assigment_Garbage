package com.javaweb.garbage1.dto;

public class ExamScoreDTO {
    private Integer scoreUserID;
    private Integer scoreUserScore;
    private String scoreCreateTime;

    public ExamScoreDTO() {
    }

    public ExamScoreDTO(Integer scoreUserID, Integer scoreUserScore, String scoreCreateTime) {
        this.scoreUserID = scoreUserID;
        this.scoreUserScore = scoreUserScore;
        this.scoreCreateTime = scoreCreateTime;
    }

    public Integer getScoreUserID() {
        return scoreUserID;
    }

    public void setScoreUserID(Integer scoreUserID) {
        this.scoreUserID = scoreUserID;
    }

    public Integer getScoreUserScore() {
        return scoreUserScore;
    }

    public void setScoreUserScore(Integer scoreUserScore) {
        this.scoreUserScore = scoreUserScore;
    }

    public String getScoreCreateTime() {
        return scoreCreateTime;
    }

    public void setScoreCreateTime(String scoreCreateTime) {
        this.scoreCreateTime = scoreCreateTime;
    }
}
