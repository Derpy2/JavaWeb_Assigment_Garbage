package com.javaweb.garbage1.entity;

public class Sort {
    private int sortID;
    private String sortName;
    private String sortInfo;

    public Sort() {
    }

    public Sort(int sortID, String sortName) {
        this.sortID = sortID;
        this.sortName = sortName;
    }

    public Sort(int sortID, String sortName, String sortInfo) {
        this.sortID = sortID;
        this.sortName = sortName;
        this.sortInfo = sortInfo;
    }

    public int getSortID() {
        return sortID;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(String sortInfo) {
        this.sortInfo = sortInfo;
    }
}
