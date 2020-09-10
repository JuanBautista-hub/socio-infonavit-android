package com.socio_infonavit_android.socio_infonavit_android.model;

public class User_login {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User_login withUser(User user) {
        this.user = user;
        return this;
    }
}
