package com.example.diplom;

import java.lang.ref.SoftReference;

public class ResorsesForRow {

    String name;
    int img;
    String editTextValue;

    ResorsesForRow(String name1, int img1, String editTextValue){
        name=name1;
        img=img1;
        this.editTextValue=editTextValue;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getImg(){
        return this.img = img;
    }

    public void setImg(int img){
        this.img = img;
    }

    public String getEditTextValue(){
        return this.editTextValue;
    }

    public void setEditTextValue(String editTextValue){
        this.editTextValue=editTextValue;
    }
}
