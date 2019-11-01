package com.amon.wfx.selfmedia.member.pojos;


public class Member {

    private String memberId;//
    private String account;//
    private String qqNum;
    private String email;
    private String phone;//
    private String recomUser;
    private String registerTime;
    private String payAccount;
    private String name;
    private String password;//
    private String visitCode;
    private String useRecom;
    private String levelCode;
    private String mid;
    private String upStringTime;


    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", account='" + account + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", recomUser='" + recomUser + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", payAccount='" + payAccount + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", visitCode='" + visitCode + '\'' +
                ", useRecom='" + useRecom + '\'' +
                ", levelCode='" + levelCode + '\'' +
                ", mid='" + mid + '\'' +
                ", upStringTime='" + upStringTime + '\'' +
                '}';
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRecomUser() {
        return recomUser;
    }

    public void setRecomUser(String recomUser) {
        this.recomUser = recomUser;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVisitCode() {
        return visitCode;
    }

    public void setVisitCode(String visitCode) {
        this.visitCode = visitCode;
    }

    public String getUseRecom() {
        return useRecom;
    }

    public void setUseRecom(String useRecom) {
        this.useRecom = useRecom;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }
}
