package com.cpb.domain;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:43
*/

public class Predict {

    private boolean flag;
    private String className;
    private double probability;
    private Bound bound;

    public Predict(boolean flag, String className, double probability, Bound bound) {
        this.flag = flag;
        this.className = className;
        this.probability = probability;
        this.bound = bound;
    }

    public Predict() {
    }

    @Override
    public String toString() {
        return "Predict{" +
                "flag=" + flag +
                ", className='" + className + '\'' +
                ", probability=" + probability +
                ", bound=" + bound +
                '}';
    }

    public boolean isFlag() {
        return flag;
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

    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
