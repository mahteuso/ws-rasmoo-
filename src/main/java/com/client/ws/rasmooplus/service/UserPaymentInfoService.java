package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.model.UserPaymentInfo;

import java.util.List;

public interface UserPaymentInfoService {

    List<UserPaymentInfo>  findAll();

    UserPaymentInfo findById(Long id);

    UserPaymentInfo save(UserPaymentInfo userPaymentInfo);

    UserPaymentInfo update(UserPaymentInfo userPaymentInfo, Long id);

    void delete();
}
