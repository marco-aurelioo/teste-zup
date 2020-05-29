package com.teste.demo.controllers;

import com.teste.demo.business.TransactionBusiness;
import com.teste.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    private TransactionBusiness transactionBusiness;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction t){
        return new ResponseEntity<Transaction>(transactionBusiness.createTransaction(t), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransaction(){
        return new ResponseEntity<List<Transaction>>( transactionBusiness.getTransatios(System.currentTimeMillis()), HttpStatus.OK);
    }

}
