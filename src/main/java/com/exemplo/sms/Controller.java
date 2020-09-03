/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemplo.sms;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elton Julio
 */
@RestController
@RequestMapping("api/v1/sms")
public class Controller {
    
    private final Service service;
    
    @Autowired
    public Controller(Service service) {
        this.service = service;
    }
    
    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
    
    service.sendSms(smsRequest);
    }
    
}
