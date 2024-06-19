package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.model.UserType;

import java.util.List;


public interface UserTypeService {

    List<UserType> findAll();

    UserType save(UserTypeDto dto);

    UserType update(UserType userType, Long id);

    UserType findById(Long id);

    void delete(Long id);
}
