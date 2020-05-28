package com.backward.account.dmo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Terrence332
 * @version 0.1
 * 角色权限关系模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleAuthDmo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String role;

    @NotBlank
    private String authority;
}
