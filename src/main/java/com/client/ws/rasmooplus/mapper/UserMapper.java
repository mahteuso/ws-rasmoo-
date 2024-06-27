package com.client.ws.rasmooplus.mapper;

import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserMapper {

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionsType subscriptionsType) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .cpf(dto.getCpf())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(userType)
                .subscriptionsType(subscriptionsType)
                .build();

    }
}
