package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.model.User;

import java.util.List;

public interface UserService {

    List<User> finAll();
    User save(UserDto dto);
    User update(UserDto dto, Long id);
    User findById(Long id);

    void delete(Long id);
}
