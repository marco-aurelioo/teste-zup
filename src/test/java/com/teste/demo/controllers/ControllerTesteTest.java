package com.teste.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.demo.business.TransactionBusiness;
import com.teste.demo.model.Error;
import com.teste.demo.model.Transaction;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ControllerTeste.class)
class ControllerTesteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionBusiness transactionBusinessMock;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup(){

    }

    @Test
    public void getComListaOk() throws Exception {
        Transaction t1 = new Transaction(123,10.1);
        Transaction t2 = new Transaction(1234,10.2);
        List<Transaction> transactions = Arrays.asList(new Transaction[]{t1, t2});
        when(transactionBusinessMock.getTransatios(any(Long.class))).thenReturn(transactions);

        String uri = "/transaction";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Transaction[] transaction_response = objectMapper.readValue(content, Transaction[].class);
        assertTrue(transaction_response.length == 2);

    }

    @Test
    public void getComException() throws Exception{
        String msgErr = "error, exception para teste handler";

        when(transactionBusinessMock.getTransatios(any(Long.class))).thenThrow(new RuntimeException(msgErr));

        String uri = "/transaction";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(500, status);
        String content = mvcResult.getResponse().getContentAsString();
        Error error = objectMapper.readValue(content, Error.class);
        assertEquals(error.getMsg(), msgErr);
    }

}