package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.ClientDto;
import com.stockManager.sinda.service.ClientService;

@RestController
public class ClientController implements ClientApi{
	
private ClientService clientService;

@Autowired
public  ClientController( ClientService clientService) {
	this.clientService= clientService;
}
	
	@Override
	public ClientDto save(ClientDto clientDto) {
		// TODO Auto-generated method stub
		return clientService.save(clientDto);
	}

	@Override
	public ClientDto findById(Long id) {
		// TODO Auto-generated method stub
		return clientService.findById(id);
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return clientService.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clientService.delete(id);
	}

}
