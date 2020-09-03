/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemplo.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;



/**
 *
 * @author Elton Julio
 */
class SmsRequest {
    
    @NotBlank
    private final String phoneNumber;
    @NotBlank
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
       
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" + "phoneNumber=" + phoneNumber + ", message=" + message + '}';
    }
    
    
}
