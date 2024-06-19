package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SubscriptionTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping("subscriptions-type")
    public ResponseEntity<List<SubscriptionsType>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());
    }

    @GetMapping("subscriptions-type/{id}")
    public ResponseEntity<SubscriptionsType> findById(@PathVariable("id") Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findById(id));
        } catch(NotFoundException nf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
