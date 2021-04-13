package com.javaweb.garbage1.entity;

public class Garbage {
    private Integer garbageID;
    private String garbageName;
    private String imageUrl;
    private Integer sortID;
    private String createTime;

    public Garbage() {
    }


    public Garbage(Integer garbageID, String garbageName) {
        this.garbageID = garbageID;
        this.garbageName = garbageName;
    }

    public Garbage(Integer garbageID, String garbageName, String imageUrl, Integer sortID, String createTime) {
        this.garbageID = garbageID;
        this.garbageName = garbageName;
        this.imageUrl = imageUrl;
        this.sortID = sortID;
        this.createTime = createTime;
    }

    public Integer getGarbageID() {
        return garbageID;
    }

    public void setGarbageID(Integer garbageID) {
        this.garbageID = garbageID;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSortID() {
        return sortID;
    }

    public void setSortID(Integer sortID) {
        this.sortID = sortID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
