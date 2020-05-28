package com.backward.account.service.serviceImpl;

import com.backward.account.dao.ClientDao;
import com.backward.account.dmo.ClientDmo;
import com.backward.account.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    @Override
    public ClientDmo getClientInfoByClientId(String clientId) {
        return clientDao.selectByClientId(clientId);
    }

    @Override
    public int registerNewClient(ClientDmo clientDmo) {
        return clientDao.insert(clientDmo);
    }

    @Override
    public int deleteClientByClientId(String clientId) {
        return clientDao.deleteByClientId(clientId);
    }

    @Override
    public int alterClientPasswordByClientId(String clientId, String ClientSecret) {
        return clientDao.alterSecretByClientId(clientId, ClientSecret);
    }
}
