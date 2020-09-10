package com.socio_infonavit_android.socio_infonavit_android.model;

public class Member {

    private Integer id;
    private Integer userId;
    private String idSocioInfonavit;
    private String name;
    private String lastname;
    private String mobile;
    private Object zipcode;
    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Member withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getIdSocioInfonavit() {
        return idSocioInfonavit;
    }

    public void setIdSocioInfonavit(String idSocioInfonavit) {
        this.idSocioInfonavit = idSocioInfonavit;
    }

    public Member withIdSocioInfonavit(String idSocioInfonavit) {
        this.idSocioInfonavit = idSocioInfonavit;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Member withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Member withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Object getZipcode() {
        return zipcode;
    }

    public void setZipcode(Object zipcode) {
        this.zipcode = zipcode;
    }

    public Member withZipcode(Object zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Member withAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

}
