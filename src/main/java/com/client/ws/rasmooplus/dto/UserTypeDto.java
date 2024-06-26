package com.client.ws.rasmooplus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTypeDto {

    private Long id;

    @NotBlank(message = " O campo name não pode ser nulo ou vazio")
    @Size(min = 5, max = 30)
    private String name;

    @NotNull(message = " O campo description não poder ser vazio")
    @Size(min = 10, max = 50)
    private String description;
}
