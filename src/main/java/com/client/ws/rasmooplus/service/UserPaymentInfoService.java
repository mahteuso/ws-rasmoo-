package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.dto.UserPaymentInfoDto;
import com.client.ws.rasmooplus.model.UserPaymentInfo;

import java.util.List;

public interface UserPaymentInfoService {

    List<UserPaymentInfo>  findAll();

    UserPaymentInfo findById(Long id);

    UserPaymentInfo save(UserPaymentInfoDto dto);

    UserPaymentInfo update(UserPaymentInfoDto dto, Long id);

    void delete(Long id);
}
