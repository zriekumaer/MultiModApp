package com.ust.invoice.ui;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.common.response.ListResponse;
import com.ust.common.response.SingleResponse;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping(value = "/client")
    public SingleResponse<ClientDTO> getClient(@PathVariable("clientId") Long clientId) {
        return new SingleResponse<>(clientService.getClient(clientId));
    }

    @PostMapping
    public SingleResponse<ObjectReference> createClient(@RequestBody ClientDTO clientDTO) {
        return new SingleResponse<>(clientService.createClient(clientDTO));
    }

    @PutMapping(value = "/client")
    public SingleResponse<ClientDTO> updateClient(@RequestBody ClientDTO client) {
        return new SingleResponse<>(clientService.updateClient(client));
    }

    @GetMapping
    public ListResponse<ClientDTO> getClientsByUserId(@PathVariable("userId") Long userId) {
        return new ListResponse<>(clientService.getClientsByUserId(userId));
    }

    @DeleteMapping(value = "/delete")
    public SingleResponse<Boolean> deleteClient(@PathVariable("clientId") Long clientId) {
        return new SingleResponse<>(clientService.deleteClient(clientId));
    }

    @GetMapping(value = "/nip")
    public SingleResponse<InvoiceData> getClientFromApiByNip(@PathVariable("nip") String nip) {
        return new SingleResponse<>(clientService.getClientFromApiByNip(nip));
    }

}