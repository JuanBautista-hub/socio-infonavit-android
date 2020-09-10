package com.socio_infonavit_android.socio_infonavit_android.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Locked {
@SerializedName("name")
    ArrayList<Object>  Loacked = new ArrayList<Object>();
    private String name;
    private String description;
    private String title;
    private String instructions;
    private String expiration_date;
    private Boolean active;
    private String primary_color;
    private String has_coupons;
    private String vector_file_name;
    private String vector_full_path;
    private String slug;
    private Wallet wallet;
    private Wallet territories;
    private Wallet ally;

    public ArrayList<Object> getLoacked() {
        return Loacked;
    }

    public void setLoacked(ArrayList<Object> loacked) {
        Loacked = loacked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPrimary_color() {
        return primary_color;
    }

    public void setPrimary_color(String primary_color) {
        this.primary_color = primary_color;
    }

    public String getHas_coupons() {
        return has_coupons;
    }

    public void setHas_coupons(String has_coupons) {
        this.has_coupons = has_coupons;
    }

    public String getVector_file_name() {
        return vector_file_name;
    }

    public void setVector_file_name(String vector_file_name) {
        this.vector_file_name = vector_file_name;
    }

    public String getVector_full_path() {
        return vector_full_path;
    }

    public void setVector_full_path(String vector_full_path) {
        this.vector_full_path = vector_full_path;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getTerritories() {
        return territories;
    }

    public void setTerritories(Wallet territories) {
        this.territories = territories;
    }

    public Wallet getAlly() {
        return ally;
    }

    public void setAlly(Wallet ally) {
        this.ally = ally;
    }
}
