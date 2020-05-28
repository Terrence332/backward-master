package com.backward.account.dto.response;

import com.backward.account.dto.UserDetailsDto;
import com.backward.common.api.BaseResponse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDetailResponse extends BaseResponse {

    private UserDetailsDto userDetailsDto;

}
