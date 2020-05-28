package com.backward.account.dao;

import com.backward.account.dmo.ClientDmo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ClientDao {

    /**
     * 根据client_id查询client完整信息
     * @param clientId
     * @return
     */
    ClientDmo selectByClientId(String clientId);

    /**
     * 添加新client信息
     * @param clientDmo
     * @return
     */
    int insert(ClientDmo clientDmo);

    /**
     * 删除client信息
     * @param clientId
     * @return
     */
    int deleteByClientId(String clientId);

    /**
     * 修改client密钥
     * @param clientId
     * @param clientSecret
     * @return
     */
    int alterSecretByClientId(@Param("clientId") String clientId, @Param("clientSecret") String clientSecret);
}
