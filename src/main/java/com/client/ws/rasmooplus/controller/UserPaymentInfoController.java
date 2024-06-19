package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.UserPaymentInfo;
import com.client.ws.rasmooplus.service.UserPaymentInfoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("ws-rasplus")
public class UserPaymentInfoController {

    @Autowired
    private UserPaymentInfoService userPaymentInfoService;

    @GetMapping("user-payment-info")
    public ResponseEntity<List<UserPaymentInfo>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userPaymentInfoService.findAll());
    }

    @GetMapping("user-payment-info/{id}")
    public ResponseEntity<UserPaymentInfo> findById(@PathVariable("id") Long id){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(userPaymentInfoService.findById(id));
        } catch (NotFoundException nf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
