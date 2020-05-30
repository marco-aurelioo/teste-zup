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

    public Transaction(String str){
        String[] values = str.split("\\|");
        if(values.length != 2){
            throw new RuntimeException("String de Transação invalida");
        }
        try {
            this.timeStamp = Long.parseLong(values[0]);
            this.value = Double.parseDouble(values[1]);
        }catch(Exception ex){
            throw new RuntimeException("String de Transação invalida");
        }
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

    @Override
    public String toString() {
        return this.timeStamp+"|"+getValue();
    }
}
