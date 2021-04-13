package com.javaweb.garbage1.entity;

public class SortEntity {
    private Integer garbageID;
    private String garbageName;
    private String creatTime;

    public SortEntity() {
    }

    public SortEntity(Integer garbageID, String garbageName, String creatTime) {
        this.garbageID = garbageID;
        this.garbageName = garbageName;
        this.creatTime = creatTime;
    }

    public Integer getGarbageID() {
        return garbageID;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setGarbageID(Integer garbageID) {
        this.garbageID = garbageID;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
}
