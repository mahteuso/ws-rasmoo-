package com.client.ws.rasmooplus.dto;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String cpf;

    private LocalDateTime dtSubscription = LocalDateTime.now();

    private LocalDateTime dtExpiration;

    private UserType userType;

    private SubscriptionsType subscriptionsType;

}
