package com.cpb.domain;
/*
  User: Yemao Luo
  Date: 2022/4/6
  Time: 0:14
*/

public class UtilInputs {

    String path;
    String ModelName;
    String ClassName;
    int width;
    int height;

    public UtilInputs() {
    }

    public UtilInputs(String path, String modelName, String className, int width, int height) {
        this.path = path;
        ModelName = modelName;
        ClassName = className;
        this.width = width;
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
