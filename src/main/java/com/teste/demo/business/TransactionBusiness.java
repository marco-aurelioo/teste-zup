package com.teste.demo.business;

import com.teste.demo.model.Transaction;
import com.teste.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionBusiness {

    private static int EXPIRE = 60;
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction t) {
        transactionRepository.createTransaction(t,EXPIRE);
        return t;
    }

    public List<Transaction> getTransatios(long timeConsult){
        List<Transaction> transactions = transactionRepository.getAllTransactions();
        return transactions;
    }

}
