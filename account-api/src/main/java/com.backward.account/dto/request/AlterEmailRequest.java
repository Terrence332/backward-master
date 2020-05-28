package com.backward.account.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Terrence332
 * @version 0.1
 * 修改邮箱地址请求体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlterEmailRequest {

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String e_mail;
}
