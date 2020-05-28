package com.backward.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {

    private String message;

    @Builder.Default
    private HttpCode code = HttpCode.SUCCESS;

    public boolean isSuccess(){ return code == HttpCode.SUCCESS; }
}
