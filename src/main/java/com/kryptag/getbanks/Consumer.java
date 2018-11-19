/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kryptag.getbanks;

import com.google.gson.Gson;
import com.kryptag.rabbitmqconnector.MessageClasses.CreditMessage;
import com.kryptag.rabbitmqconnector.MessageClasses.RuleMessage;
import com.kryptag.rabbitmqconnector.RMQConnection;
import com.kryptag.rabbitmqconnector.RMQConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author florenthaxha
 */
public class Consumer extends RMQConsumer{

    public Consumer(RMQConnection aggregatorCon, ConcurrentLinkedQueue q, RMQConnection rmq) {
        super(q, rmq);
    }

    @Override
    public void run() {
        super.run(); 
    }
    
    public void doWork(){
        Gson g = new Gson();
        if (!super.getQueue().isEmpty()) {
            CreditMessage cmsg = g.fromJson(super.getQueue().remove().toString(), CreditMessage.class);
            RuleMessage rmsg = getBanks(cmsg);
        }
    }
    
    private RuleMessage getBanks(CreditMessage cmsg){
        // soap magic yayeet
        
        return null;
    }
}
