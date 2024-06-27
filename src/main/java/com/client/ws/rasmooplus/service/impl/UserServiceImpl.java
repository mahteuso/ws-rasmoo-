package com.client.ws.rasmooplus.service.impl;

import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.mapper.UserMapper;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.repository.UserTypeRepository;
import com.client.ws.rasmooplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
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

        Optional<UserType> optUserType = userTypeRepository.findById(dto.getUserTypeId());

        if (optUserType.isEmpty()){
            throw new NotFoundException("UserType id not found");
        }
        UserType userType = optUserType.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);

        return userRepository.save(user);
    }

    @Override
    public User update(UserDto dto, Long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) {
            throw new BadRequestException("User not exist.");
        }
        Optional<UserType> optUserType = userTypeRepository.findById(id);
        if (optUserType.isEmpty()){
            throw new NotFoundException("Id not found.");
        }
        UserType userType = optUserType.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);
        dto.setId(id);
        return userRepository.save(user);
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
