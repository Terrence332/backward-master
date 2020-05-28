package com.backward.account.dto.response;

import com.backward.account.dmo.ClientDmo;
import com.backward.common.api.BaseResponse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ClientDetailResponse extends BaseResponse {

    private ClientDmo clientDmo;

}
