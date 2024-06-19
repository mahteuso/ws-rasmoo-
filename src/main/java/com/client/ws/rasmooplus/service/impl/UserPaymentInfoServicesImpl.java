package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.UserPaymentInfo;
import com.client.ws.rasmooplus.repository.UserPaymentInfoRepository;
import com.client.ws.rasmooplus.service.UserPaymentInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserPaymentInfoServicesImpl implements UserPaymentInfoService {

    private UserPaymentInfoRepository userPaymentInfoRepository;

    public UserPaymentInfoServicesImpl( UserPaymentInfoRepository userPaymentInfoRepository){
        this.userPaymentInfoRepository = userPaymentInfoRepository;
    }
    @Override
    public List<UserPaymentInfo> findAll() {
        return userPaymentInfoRepository.findAll();
    }

    @Override
    public UserPaymentInfo findById(Long id) {

        Optional<UserPaymentInfo> opt = userPaymentInfoRepository.findById(id);
        if (opt.isEmpty()){
            throw new NotFoundException("UserPaymentInfo not found");
        }
        return opt.get();
    }

    @Override
    public UserPaymentInfo save(UserPaymentInfo userPaymentInfo) {
        return null;
    }

    @Override
    public UserPaymentInfo update(UserPaymentInfo userPaymentInfo, Long id) {
        return null;
    }

    @Override
    public void delete() {

    }
}
