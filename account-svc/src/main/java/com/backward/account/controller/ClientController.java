package com.backward.account.controller;

import com.backward.account.dmo.ClientDmo;
import com.backward.account.dto.request.AlterClientPasswordRequest;
import com.backward.account.dto.response.ClientDetailResponse;
import com.backward.account.service.ClientService;
import com.backward.common.api.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@Api(value = "Client API", tags = {"Client API"})
@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * 根据客户端id获取客户端完整信息
     * @param clientId
     * @return
     */
    @ApiOperation(value = "获取客户端完整信息")
    @GetMapping("/client_details")
    ClientDetailResponse getClientInformationByClientId(@RequestParam("clientId") String clientId){
        ClientDmo clientDmo = clientService.getClientInfoByClientId(clientId);
        ClientDetailResponse response = new ClientDetailResponse(clientDmo);
        response.setMessage("客户端完整信息");
        return response;
    }

    /**
     * 注册新客户端
     * @param clientDmo
     * @return
     */
    @ApiOperation(value = "注册新客户端")
    @PostMapping("/register_client")
    BaseResponse registerNewClient(@RequestBody ClientDmo clientDmo){
        if(clientDmo.getClientSecret() != null){
            String encodedSecret = BCrypt.hashpw(clientDmo.getClientSecret(), BCrypt.gensalt());
            clientDmo.setClientSecret(encodedSecret);
        }
        int msg = clientService.registerNewClient(clientDmo);
        return BaseResponse.builder().message(Integer.toString(msg)).build();
    }

    /**
     * 根据客户端id删除客户端
     * @param clientId
     * @return
     */
    @ApiOperation(value = "删除客户端")
    @DeleteMapping("/delete_client")
    int deleteClientByClientId(@RequestParam("clientId") String clientId){
        return clientService.deleteClientByClientId(clientId);
    }

    /**
     * 根据客户端id修改客户端密钥
     * @param request
     * @return
     */
    @ApiOperation(value = "修改客户端密钥")
    @PostMapping("/alter_secret")
    int alterClientSecretByClientId(@RequestBody AlterClientPasswordRequest request){
        String clientId = request.getClientId();
        String encodedSecret = BCrypt.hashpw(request.getSecret(), BCrypt.gensalt());
        return clientService.alterClientPasswordByClientId(clientId, encodedSecret);
    }

}
