package com.ust.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.domain.ClientDomain;
import com.ust.invoice.service.ClientService;
import com.ust.invoice.service.bo.ClientBO;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDomain clientDomain;

	@Override
	public List<ClientBO> getClientsByUserId(Long userId) {
		return clientDomain.getClientsByUserId(userId);
	}

	@Override
	public ClientBO getClient(Long clientId) {
		return clientDomain.getClient(clientId);
	}

	@Override
	public ObjectReference createClient(ClientBO clientDTO) {
		return clientDomain.createClient(clientDTO);
	}

	@Override
	public ClientBO updateClient(ClientBO client) {
		return clientDomain.updateClient(client);
	}

	@Override
	public boolean deleteClient(Long clientId) {
		return clientDomain.deleteClient(clientId);
	}
	
	
	
}