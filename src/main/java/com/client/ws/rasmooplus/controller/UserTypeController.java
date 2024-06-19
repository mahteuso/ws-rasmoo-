package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ws-rasplus")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/user-type")
    public ResponseEntity<List<UserType>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<UserType> save(@RequestBody UserTypeDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userTypeService.save(dto));
    }

    @GetMapping("/user-type/{id}")
    public ResponseEntity<UserType> findById(@PathVariable("id") Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findById(id));
        } catch(NotFoundException nf){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
