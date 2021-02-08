package com.iamrajendra.datum.pojo;

import android.annotation.SuppressLint;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import java.util.Objects;

public class CheckModel  implements  Cloneable{
    private String name;
    private boolean state;

    public String getName() {
        return name;
    }

    public CheckModel setName(String name) {
        this.name = name;
        return this;

    }

    public boolean isState() {
        return state;
    }

    public CheckModel setState(boolean state) {
        this.state = state;
        return this;

    }

    @Override
    public boolean equals(Object o) {
        CheckModel checkModel = (CheckModel) o;
        return this.name.equals(checkModel.name) && this.isState() == checkModel.isState();

    }

    @SuppressLint("NewApi")
    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    @Override
    public String toString() {
        return "CheckModel{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }

    @NonNull
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
