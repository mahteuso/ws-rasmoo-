package com.client.ws.rasmooplus.dto;

import com.client.ws.rasmooplus.model.SubscriptionsType;
import com.client.ws.rasmooplus.model.UserType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = " Não poder nulo ou vazio")
    @Size(min = 5, message = " Valor mínimo  de 5 caracteres")
    private String name;

    @Email(message = " Email inválido")
    private String email;

    @Size(max = 11, message = " Deve conter 11 dígitos")
    private String phone;

    @CPF(message = " Cpf inválido")
    private String cpf;

    private LocalDateTime dtSubscription = LocalDateTime.now();

    private LocalDateTime dtExpiration = LocalDateTime.now();

    @NotNull
    private Long userTypeId;

    private Long subscriptionsTypeId;

}
