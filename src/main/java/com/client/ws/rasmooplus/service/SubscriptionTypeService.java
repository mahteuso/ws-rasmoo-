package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.model.SubscriptionsType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionsType> findAll();

    SubscriptionsType save(SubscriptionsType subscriptionsType);

    SubscriptionsType update(SubscriptionsType subscriptionsType, Long id);

    SubscriptionsType findById(Long id);

    void delete(Long id);
}
