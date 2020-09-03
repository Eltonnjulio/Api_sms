/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemplo.sms;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Elton Julio
 */
@Configuration
public class TwilioInitializer {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
    private final TwilioConfiguration twilioConfigurantion;
    
    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfigurantion) {
        this.twilioConfigurantion = twilioConfigurantion;
        
        Twilio.init(twilioConfigurantion.getAccountSid(),twilioConfigurantion.getAuthToken());

         LOGGER.info("Twilio initialized ...with account Sid {}", twilioConfigurantion.getAccountSid());
    }
    
}
