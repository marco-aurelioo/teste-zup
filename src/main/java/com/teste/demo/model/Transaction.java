package com.teste.demo.model;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class Transaction {

    @NotNull
    private Long timeStamp;

    @NotNull
    private Double value;

    public Transaction(){
    }

    public Transaction(Long timeStamp, Double value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
