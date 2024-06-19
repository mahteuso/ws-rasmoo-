package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionsTypeServiceImpl implements SubscriptionTypeService {

    private SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionsTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository){
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }
    @Override
    public List<SubscriptionsType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionsType save(SubscriptionsType subscriptionsType) {
        return null;
    }

    @Override
    public SubscriptionsType update(SubscriptionsType subscriptionsType, Long id) {
        return null;
    }

    @Override
    public SubscriptionsType findById(Long id) {
        Optional<SubscriptionsType> opt = subscriptionTypeRepository.findById(id);
        if (opt.isEmpty()){
            throw new NotFoundException("SubscriptionsType not found");
        }
        return opt.get();
    }

    @Override
    public void delete(Long id) {

    }
}
