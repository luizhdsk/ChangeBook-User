package com.projeto.changebookusers.domain.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.changebookusers.config.Messages;
import com.projeto.changebookusers.domain.User;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequest {

    @JsonProperty("user_name")
    @NotBlank(message = Messages.NAME_IS_REQUIRED)
    private String userName;


    private String cpf;

    @NotBlank(message = Messages.CITY_IS_REQUIRED)
    private String city;

    @Email(message = Messages.EMAIL_IS_INVALID)
    @NotBlank(message = Messages.EMAIL_IS_REQUIRED)
    private String email;

    private String password;

    @NotBlank(message = Messages.PHONE_IS_REQUIRED)
    private String phone;

    public User toUser(){
        return User.builder()
                .userName(userName)
                .cpf(cpf)
                .city(city)
                .email(email)
                .password(password)
                .phone(phone)
                .build();
    }
}
