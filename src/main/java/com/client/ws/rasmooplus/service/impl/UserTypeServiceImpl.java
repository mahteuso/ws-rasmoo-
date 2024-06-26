package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.mapper.UserTypeMapper;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.repository.UserTypeRepository;
import com.client.ws.rasmooplus.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType save(UserTypeDto dto) {
        return userTypeRepository.save(UserTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public UserType update(UserTypeDto dto, Long id) {
        Optional<UserType> opt = userTypeRepository.findById(id);
        if (opt.isEmpty()) {
            throw new BadRequestException("Id must be valid");
        }
        dto.setId(id);
        return userTypeRepository.save(UserTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public UserType findById(Long id) {
        Optional<UserType> opt = userTypeRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("UserType not exists");
        }
        return opt.get();
    }

    @Override
    public void delete(Long id) {
        Optional<UserType> opt = userTypeRepository.findById(id);
        if (opt.isEmpty()) {
            throw new BadRequestException("UserType not exists");
        }
        userTypeRepository.deleteById(id);
    }
}
