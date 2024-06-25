package com.client.ws.rasmooplus.service;

import com.client.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionsType> findAll();

    SubscriptionsType save(SubscriptionTypeDto dto);

    SubscriptionsType update(SubscriptionTypeDto dto, Long id);

    SubscriptionsType findById(Long id);

    void delete(Long id);
}
