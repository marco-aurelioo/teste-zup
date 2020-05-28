package com.teste.demo.controllers;

import com.teste.demo.business.TransactionBusiness;
import com.teste.demo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class ControllerTeste {


    @Autowired
    private TransactionBusiness transactionBusiness;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction t){
        try {
            if (t == null) {
                throw new Exception("Transaction invalida;");
            }
            return new ResponseEntity<Transaction>(transactionBusiness.createTransaction(t), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Transaction>(t, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransaction(){
        return new ResponseEntity<List<Transaction>>( transactionBusiness.getTransatios(), HttpStatus.OK);
    }

}
