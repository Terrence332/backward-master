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
 * 用户角色信息模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDmo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String role;

    @Builder.Default
    private String description = null;
}
