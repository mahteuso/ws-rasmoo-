package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.model.User;

import java.util.List;

public interface UserService {

    List<User> finAll();
    User save(User user);
    User update(User user, Long id);
    User findById(Long id);

    void delete(Long id);
}
