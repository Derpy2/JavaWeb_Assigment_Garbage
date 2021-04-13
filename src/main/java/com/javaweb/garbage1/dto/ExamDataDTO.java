package com.javaweb.garbage1.dto;

public class ExamDataDTO {
    private Integer numUserID;
    private Integer numCorrect;
    private Integer numTotText;

    public ExamDataDTO() {
    }

    public ExamDataDTO(Integer userID, Integer numCorrect, Integer numTotText) {
        this.numUserID = userID;
        this.numCorrect = numCorrect;
        this.numTotText = numTotText;
    }

    public Integer getNumUserID() {
        return numUserID;
    }

    public void setNumUserID(Integer numUserID) {
        this.numUserID = numUserID;
    }

    public Integer getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect(Integer numCorrect) {
        this.numCorrect = numCorrect;
    }

    public Integer getNumTotText() {
        return numTotText;
    }

    public void setNumTotText(Integer numTotText) {
        this.numTotText = numTotText;
    }
}
