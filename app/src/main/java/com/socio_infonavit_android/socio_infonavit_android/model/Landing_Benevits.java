package com.socio_infonavit_android.socio_infonavit_android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Landing_Benevits {

    ArrayList<Object> locked = new ArrayList<Object>();
    ArrayList<Object> unlocked = new ArrayList<Object>();

    public ArrayList<Object> getLocked() {
        return locked;
    }

    public void setLocked(ArrayList<Object> locked) {
        this.locked = locked;
    }

    public ArrayList<Object> getUnlocked() {
        return unlocked;
    }

    public void setUnlocked(ArrayList<Object> unlocked) {
        this.unlocked = unlocked;
    }
}
