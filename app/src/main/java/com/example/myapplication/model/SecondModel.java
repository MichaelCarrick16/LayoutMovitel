package com.example.myapplication.model;


import java.io.Serializable;

public class SecondModel implements Serializable {
    private String nameSecond;
    private String nameFragment;

    public SecondModel(String nameSecond, String nameFragment) {
        this.nameSecond = nameSecond;
        this.nameFragment = nameFragment;
    }

    public String getNameSecond() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond = nameSecond;
    }

    public String getNameFragment() {
        return nameFragment;
    }

    public void setNameFragment(String nameFragment) {
        this.nameFragment = nameFragment;
    }
}
