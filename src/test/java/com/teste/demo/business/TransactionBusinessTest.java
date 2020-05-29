package com.teste.demo.business;

import com.teste.demo.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionBusinessTest {


    @Autowired
    private TransactionBusiness transactionBusiness;

    @Test
    public void testaRetornoVazio(){
        List<Transaction> transactions = transactionBusiness.getTransatios(System.currentTimeMillis());
        assertEquals(transactions.size(),0);
    }

    @Test
    public void testaRetornoListaPopulada(){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100 ;i++){
            transactionBusiness.createTransaction(new Transaction(start+i , new Random().nextDouble()));
        }
        List<Transaction> resposta = transactionBusiness.getTransatios(start+60000);
        assertEquals(100,resposta.size());

    }

    @Test
    public void testaRetornoListaParcial(){
        long start = 60000;
        List<Transaction> listaParcial = new ArrayList<>();
        for(long i = 0; i < 100 ;i++){
            Long nlong = start + i;
            listaParcial.add(transactionBusiness.createTransaction(new Transaction(nlong,10.0)));
        }
        List<Transaction> resposta = transactionBusiness.getTransatios(System.currentTimeMillis());
        assertTrue(!resposta.containsAll(listaParcial));
    }


}