package com.client.ws.rasmooplus.mapper;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserTypeMapper {

    public static UserType fromDtoToEntity(UserTypeDto dto){
        return UserType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
