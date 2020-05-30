package com.teste.demo.business;

import com.teste.demo.model.Transaction;
import com.teste.demo.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TransactionBusinessTest {


    @Autowired
    private TransactionBusiness transactionBusiness;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void testaRetornoVazio(){
        when(transactionRepository.getAllTransactions()).thenReturn(new ArrayList<Transaction>());
        List<Transaction> transactions = transactionBusiness.getTransatios(System.currentTimeMillis());
        assertEquals(transactions.size(),0);
    }

    @Test
    public void testaCalculoExpiracaoRegistro(){
        /*
        1590825600000 ms => 1590825600000/1000 = 1590825600 s => 1590825660 +1m
         */

       Transaction transaction = new Transaction(1590825600000l,10.0);
       transactionBusiness.createTransaction(transaction);

       verify(transactionRepository, times(1))
               .createTransaction(any(Transaction.class),eq(1590825660));

    }
}