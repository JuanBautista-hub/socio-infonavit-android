package com.socio_infonavit_android.socio_infonavit_android.model;

public class ResponseLogin {

    private Integer id;

    private String email;

    private String role;

    private Member member;

    private Integer signInCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResponseLogin withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponseLogin withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ResponseLogin  withRole(String role) {
        this.role = role;
        return this;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ResponseLogin withMember(Member member) {
        this.member = member;
        return this;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public ResponseLogin withSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
        return this;
    }

}