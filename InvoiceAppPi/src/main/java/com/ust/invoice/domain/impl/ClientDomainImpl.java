package com.ust.invoice.domain.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.domain.ClientDomain;
import com.ust.invoice.entity.Client;
import com.ust.invoice.repo.ClientRepository;
import com.ust.invoice.service.bo.ClientBO;

public class ClientDomainImpl implements ClientDomain {

	@Autowired
    private ClientRepository clientRepository;
	
    private ModelMapper modelMapper = new ModelMapper();
    
    public List<ClientBO> getClientsByUserId(Long userId) {
    	return clientRepository.findAllByUserIdAndActive(userId, true).stream()
                .map(client -> modelMapper.map(client, ClientBO.class)).collect(Collectors.toList());
	}

	public ClientBO getClient(Long clientId) {
		Client client = clientRepository.findByIdAndActive(clientId, true)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found id: " + clientId));
        return modelMapper.map(client, ClientBO.class);
	}

	public ObjectReference createClient(ClientBO clientBO) {
		Client client = modelMapper.map(clientBO, Client.class);
        client.setActive(true);
        clientRepository.save(client);
        return new ObjectReference(client.getId());
	}

	public ClientBO updateClient(ClientBO client) {
		Client clientDs = clientRepository.findById(client.getId().longValue())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found id: " + client.getId()));
        modelMapper.map(client, clientDs);

        clientRepository.save(clientDs);
        return client;
	}


    public boolean deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow( () -> new ResourceNotFoundException("Client not found id: " + clientId));
        client.setActive(false);
        clientRepository.save(client);
        return true;
    }

//    public InvoiceData getClientFromApiByNip(String nip) {
//        try {
//            NIP24Client nip24 = new NIP24Client("w4PuMSZH8D4i", "hMlmlqgMCB5O");
//            return nip24.getInvoiceData(nip);
//        } catch  (MalformedURLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}