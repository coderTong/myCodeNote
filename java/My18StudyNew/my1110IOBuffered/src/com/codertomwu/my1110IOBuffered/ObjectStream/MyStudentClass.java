package com.codertomwu.my1110IOBuffered.ObjectStream;

import java.io.Serializable;

/**
 * Created by codew on 11/10/18.
 */
public class MyStudentClass implements Serializable{


    private String className;
    private int idNu; // 学号

    public MyStudentClass() {
    }

    public MyStudentClass(String className, int idNu) {
        this.className = className;
        this.idNu = idNu;
    }

    @Override
    public String toString() {
        return "MyStudentClass{" +
                "className='" + className + '\'' +
                ", idNu=" + idNu +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getIdNu() {
        return idNu;
    }

    public void setIdNu(int idNu) {
        this.idNu = idNu;
    }
}
