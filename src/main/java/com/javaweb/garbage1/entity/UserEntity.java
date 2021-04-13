package com.javaweb.garbage1.entity;

public class UserEntity {
    private Integer userID;
    private String userName;
    private String userPhone;
    private String userPwd;
    private String userCard;
    private Integer userStatus;

    public UserEntity() {
    }

    public UserEntity(Integer userID, String userName, String userPhone, String userPwd, String userCard, Integer userStatus) {
        this.userID = userID;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPwd = userPwd;
        this.userCard = userCard;
        this.userStatus = userStatus;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}
