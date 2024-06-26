package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.service.UserTypeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<UserType>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findAll());
    }

    @PostMapping("/user-type/save")
    public ResponseEntity<UserType> save(@Valid @RequestBody UserTypeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userTypeService.save(dto));
    }

    @GetMapping("/user-type/{id}")
    public ResponseEntity<UserType> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findById(id));
    }

    @PutMapping("user-type/update/{id}")
    public ResponseEntity<UserType> update(@Valid @RequestBody UserTypeDto dto, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userTypeService.update(dto, id));
    }

    @DeleteMapping("/user-type/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
