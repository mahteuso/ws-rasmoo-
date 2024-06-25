package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.dto.UserPaymentInfoDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.UserPaymentInfo;
import com.client.ws.rasmooplus.service.UserPaymentInfoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user-payment-info/save")
    public ResponseEntity<UserPaymentInfo> save(UserPaymentInfoDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userPaymentInfoService.save(dto));
    }

    @PostMapping("/user-payment-info/update/{id}")
    public ResponseEntity<UserPaymentInfo> update(@RequestBody UserPaymentInfoDto dto, @PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(userPaymentInfoService.update(dto, id));
    }

    @DeleteMapping("/user-payment-info/delete/{id}")
    public ResponseEntity<Void> delete(Long id){
        userPaymentInfoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
