package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> finAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id must be null");
        }

        return userRepository.save(User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .cpf(dto.getCpf())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .subscriptionsType(dto.getSubscriptionsType())
                .subscriptionsType(dto.getSubscriptionsType())
                .build());
    }

    @Override
    public User update(UserDto dto, Long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) {
            throw new BadRequestException("User not exist.");
        }
        return userRepository.save(User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .cpf(dto.getCpf())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(dto.getUserType())
                .subscriptionsType(dto.getSubscriptionsType())
                .build());
    }

    @Override
    public User findById(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return opt.get();
    }

    @Override
    public void delete(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) {
            throw new BadRequestException("User not exist");
        }
        userRepository.deleteById(id);
    }
}
