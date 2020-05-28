package com.teste.demo.model;

public class Transaction {

    private long timeStamp;
    private double value;

    public Transaction(){
    }

    public Transaction(long timeStamp, double value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
