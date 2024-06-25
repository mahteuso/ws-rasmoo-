package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.exception.BadRequestException;
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

    public SubscriptionsTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionsType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionsType save(SubscriptionTypeDto dto) {
        return subscriptionTypeRepository.save(SubscriptionsType.builder()
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build());
    }

    @Override
    public SubscriptionsType update(SubscriptionTypeDto dto, Long id) {
        if (Objects.isNull(dto.getId())) {
            throw new BadRequestException("Id must be valid.");
        }
        return subscriptionTypeRepository.save(SubscriptionsType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build());
    }

    @Override
    public SubscriptionsType findById(Long id) {
        Optional<SubscriptionsType> opt = subscriptionTypeRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("SubscriptionsType not found");
        }
        return opt.get();
    }

    @Override
    public void delete(Long id) {
        Optional<SubscriptionsType> opt = subscriptionTypeRepository.findById(id);
        if (opt.isEmpty()) {
            throw new BadRequestException("Id must be valid");
        }
        subscriptionTypeRepository.deleteById(id);
    }
}
