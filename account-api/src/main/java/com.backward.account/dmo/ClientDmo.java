package com.backward.account.dmo;

import com.backward.common.constant.CommonConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Terrence332
 * @version 0.1
 * 客户端信息模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDmo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String clientId;

    @Builder.Default
    private String resourceIds = CommonConstant.GLOBAL_RESOURCE_ID;

    @NotBlank
    private String clientSecret;

    @Builder.Default
    private String scope = "all";

    @Builder.Default
    private String authorizedGrantTypes = "password,refresh_token";

    private String webServerRedirectUri;

    @Builder.Default
    private String authorities = "all";

    @Builder.Default
    private Integer accessTokenValidity = 7200;

    @Builder.Default
    private Integer refreshTokenValidity = 259200;

    @Builder.Default
    private String autoapprove = "false";

    private String additionalInformation;

}
