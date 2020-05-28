package com.backward.account.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Terrence332
 * @version 0.1
 * 修改用户密码请求体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlterUserPasswordRequest {

    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;
}
