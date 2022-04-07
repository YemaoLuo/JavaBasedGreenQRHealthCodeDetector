package com.cpb.domain;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:43
*/

public class Predict {

    private String className;
    private double probability;
    private Bound bound;

    public Predict(String className, double probability, Bound bound) {
        this.className = className;
        this.probability = probability;
        this.bound = bound;
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

    @Override
    public String toString() {
        return "Predict{" +
                "className='" + className + '\'' +
                ", probability=" + probability +
                ", bound=" + bound +
                '}';
    }

    public Bound getBound() {
        return bound;
    }

    public void setBound(Bound bound) {
        this.bound = bound;
    }
}
