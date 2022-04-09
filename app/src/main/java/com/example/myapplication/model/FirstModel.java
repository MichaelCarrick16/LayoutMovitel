package com.example.myapplication.model;

import java.util.List;

public class FirstModel {
    private String name;
    private List<SecondModel> listSecondModel;

    public FirstModel(String name, List<SecondModel> listSecondModel) {
        this.name = name;
        this.listSecondModel = listSecondModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SecondModel> getListSecondModel() {
        return listSecondModel;
    }

    public void setListSecondModel(List<SecondModel> listSecondModel) {
        this.listSecondModel = listSecondModel;
    }
}
