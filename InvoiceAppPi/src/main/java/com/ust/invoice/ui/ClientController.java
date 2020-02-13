package com.ust.invoice.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.ListResponse;
import com.ust.common.response.ObjectReference;
import com.ust.common.response.SingleResponse;
import com.ust.invoice.service.ClientService;
import com.ust.invoice.service.bo.ClientBO;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
    private ClientService clientService;

    @GetMapping(value = "/client")
    public SingleResponse<ClientBO> getClient(@PathVariable("clientId") Long clientId) {
        return new SingleResponse<ClientBO>(clientService.getClient(clientId));
    }

    @PostMapping
    public SingleResponse<ObjectReference> createClient(@RequestBody ClientBO clientDTO) {
        return new SingleResponse<>(clientService.createClient(clientDTO));
    }

    @PutMapping(value = "/client")
    public SingleResponse<ClientBO> updateClient(@RequestBody ClientBO client) {
        return new SingleResponse<ClientBO>(clientService.updateClient(client));
    }

    @GetMapping
    public ListResponse<List<ClientBO>> getClientsByUserId(@PathVariable("userId") Long userId) {
        return new ListResponse<List<ClientBO>>(clientService.getClientsByUserId(userId));
    }

    @DeleteMapping(value = "/delete")
    public SingleResponse<Boolean> deleteClient(@PathVariable("clientId") Long clientId) {
        return new SingleResponse<>(clientService.deleteClient(clientId));
    }

}