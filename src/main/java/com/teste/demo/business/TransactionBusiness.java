package com.teste.demo.business;

import com.teste.demo.model.Transaction;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionBusiness {

    List<Transaction> lista = new ArrayList<>();

    public Transaction createTransaction(Transaction t) {
        lista.add(t);
        return t;
    }

    public List<Transaction> getTransatios(long timeConsult){
        List<Transaction> transactions = lista
                .stream()
                .filter(t -> t.getTimeStamp() >= timeConsult-60000 )
                .collect(Collectors.toList());
        this.lista = transactions;
        return transactions;
    }

}
