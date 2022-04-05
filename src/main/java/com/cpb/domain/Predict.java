package com.cpb.domain;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:43
*/

public class Predict {

    private String className;
    private double probability;

    public Predict(String className, double probability) {
        this.className = className;
        this.probability = probability;
    }

    public Predict() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String toString() {
        return "Predict{" +
                "className='" + className + '\'' +
                ", probability=" + probability +
                '}';
    }
}
