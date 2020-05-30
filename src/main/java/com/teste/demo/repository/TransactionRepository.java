package com.teste.demo.repository;

import com.teste.demo.model.Transaction;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.sql.Timestamp;
import java.util.*;

@Component
public class TransactionRepository {

    Jedis jedis;
    String hash = "transactions";

    public TransactionRepository(){
        this.jedis = new Jedis("localhost",7001);
    }

    public void createTransaction(Transaction t, int expire){
        String key = UUID.randomUUID().toString();
        jedis.set(hash+"&"+t.toString()+"&"+key,"");
        jedis.expire(hash+"&"+t.toString()+"&"+key,expire);
    }

    public List<Transaction> getAllTransactions(){
        try {
            List<Transaction> resposta =  new ArrayList<>();
            Set<String> keys = jedis.keys("*");
            for(String k : keys){
                String[] values = k.split("&");
                resposta.add(new Transaction(values[1]));
            }
            return  resposta;
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }
}
