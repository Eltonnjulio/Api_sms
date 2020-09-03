/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemplo.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Elton Julio
 */
@org.springframework.stereotype.Service
public class Service {
    
    private  final SmsSender smsSender;
    
    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }
    
    public void sendSms(SmsRequest smsRequest){
    smsSender.sendSMS(smsRequest);
    
    }
    
}
