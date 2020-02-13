package com.ust.invoice.domain;

import java.util.List;

import com.ust.common.response.ObjectReference;
import com.ust.invoice.service.bo.ClientBO;

public interface ClientDomain {
	
	public List<ClientBO> getClientsByUserId(Long userId);

    public ClientBO getClient(Long clientId);

    public ObjectReference createClient(ClientBO clientDTO);

    public ClientBO updateClient(ClientBO client);

    public boolean deleteClient(Long clientId);

//    public InvoiceData getClientFromApiByNip(String nip);

}
