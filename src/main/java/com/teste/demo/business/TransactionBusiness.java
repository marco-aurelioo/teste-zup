package com.teste.demo.business;

import com.teste.demo.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionBusiness {

    List<Transaction> lista = new ArrayList<>();

    public Transaction createTransaction(Transaction t) {
        lista.add(t);
        return t;
    }

    public List<Transaction> getTransatios(){
        return lista;
    }

}
