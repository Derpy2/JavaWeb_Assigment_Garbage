package com.javaweb.garbage1.dto;

public class GarbageDTO {
    private Integer garbageID;
    private Integer sortID;
    private String garbageName;
    private String imageUrl;
    private String createTime;

    public GarbageDTO() {
    }

    public GarbageDTO(Integer garbageID, Integer sortID, String garbageName, String imageUrl, String createTime) {
        this.garbageID = garbageID;
        this.sortID = sortID;
        this.garbageName = garbageName;
        this.imageUrl = imageUrl;
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getGarbageID() {
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

}
