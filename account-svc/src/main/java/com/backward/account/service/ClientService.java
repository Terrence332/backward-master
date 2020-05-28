package com.backward.account.service;

import com.backward.account.dmo.ClientDmo;

/**
 * 前端配置API（仅管理员使用）
 * @author Terrence332
 * @version 0.1
 */
public interface ClientService {

    /**
     * 根据Client编号(id)获取该Client的详细信息
     * @param clientId
     * @return ClientDmo.class
     */
    ClientDmo getClientInfoByClientId(String clientId);

    /**
     * 注册一个新的Client
     * @param clientDmo
     * @return
     */
    int registerNewClient(ClientDmo clientDmo);

    /**
     * 根据Client编号(id)删除一个Client
     * @param clientId
     * @return
     */
    int deleteClientByClientId(String clientId);

    /**
     * 根据Client编号(id)修改该Client的密钥
     * @param clientId
     * @param ClientSecret
     * @return
     */
    int alterClientPasswordByClientId(String clientId, String ClientSecret);

}
