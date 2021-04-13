package com.javaweb.garbage1.dto;

public class ExamProDTO {
    private Integer proGarbageID;
    private String proGarbageName;
    private Integer proGarbageTypeID;
    private String proGarbageTime;

    public ExamProDTO() {
    }

    public ExamProDTO(Integer proGarbageID, String proGarbageName, Integer proGarbageTypeID, String proGarbageTime) {
        this.proGarbageID = proGarbageID;
        this.proGarbageName = proGarbageName;
        this.proGarbageTypeID = proGarbageTypeID;
        this.proGarbageTime = proGarbageTime;
    }

    public Integer getProGarbageID() {
        return proGarbageID;
    }

    public void setProGarbageID(Integer proGarbageID) {
        this.proGarbageID = proGarbageID;
    }

    public String getProGarbageName() {
        return proGarbageName;
    }

    public void setProGarbageName(String proGarbageName) {
        this.proGarbageName = proGarbageName;
    }

    public Integer getProGarbageTypeID() {
        return proGarbageTypeID;
    }

    public void setProGarbageTypeID(Integer proGarbageTypeID) {
        this.proGarbageTypeID = proGarbageTypeID;
    }

    public String getProGarbageTime() {
        return proGarbageTime;
    }

    public void setProGarbageTime(String proGarbageTime) {
        this.proGarbageTime = proGarbageTime;
    }
}
