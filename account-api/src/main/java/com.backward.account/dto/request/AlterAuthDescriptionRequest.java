package com.backward.account.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Terrence332
 * @version 0.1
 * 修改权限描述请求体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlterAuthDescriptionRequest {

    @NotBlank
    private String authority;

    @NotBlank
    private String description;
}
