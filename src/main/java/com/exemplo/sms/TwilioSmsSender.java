/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemplo.sms;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elton Julio
 */
@Service("twilio")
public class TwilioSmsSender implements SmsSender{

     private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
    private TwilioConfiguration twilioConfiguration;
    
    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }
     
    
    @Override
    public void sendSMS(SmsRequest smsRequest) {
       
        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
            
        PhoneNumber to =new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = smsRequest.getMessage();
       
       
        MessageCreator creator = Message.creator(to,from,message );
        creator.create();
        LOGGER.info("Send sms {}"+ smsRequest);
        }
        else{
        
        throw new IllegalArgumentException("O número ["+smsRequest.getPhoneNumber()+"] não é válido");
        }
        
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
    
}
