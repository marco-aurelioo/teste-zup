package com.teste.demo.schedule;

import com.teste.demo.business.TransactionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TransactionGC {

    @Autowired
    private TransactionBusiness transactionBusiness;

    /**
     * Metodo para fazer a manutenção nos dados guardados,
     * como o requisito é apenas apresentar as transações do ultimo minuto
     */
    @Scheduled(fixedRate = 60000)
    public void preventOverflow(){
        transactionBusiness.expurgo(System.currentTimeMillis());
    }

}
