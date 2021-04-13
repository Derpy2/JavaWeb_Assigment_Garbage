package com.javaweb.garbage1.entity;

public class GarbageEntity {
    private int garbageID;
    private String garbageName;
    private int sortID;
    private String imageUrl;
    private String createTime;

    public GarbageEntity() {
    }

    public GarbageEntity(int garbageID, String garbageName, int sortID, String imageUrl, String createTime) {
        this.garbageID = garbageID;
        this.garbageName = garbageName;
        this.sortID = sortID;
        this.imageUrl = imageUrl;
        this.createTime = createTime;
    }

    public int getGarbageID() {
        return garbageID;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public int getSortID() {
        return sortID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getcreateTime() {
        return createTime;
    }

    public void setcreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setGarbageID(int garbageID) {
        this.garbageID = garbageID;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public String toString() {
        return this.getGarbageName() + " " + this.getGarbageID() + " " + this.getImageUrl() + " " + this.getSortID();
    }
}
