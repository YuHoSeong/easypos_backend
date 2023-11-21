package com.pcpos.easypos.dto.request.auth;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSignInDto {
    @NotBlank
    @Email
    @Length(max=320)
    private String email;
    @NotBlank
    @Length(min=8, max=20)
    private String password;
}
