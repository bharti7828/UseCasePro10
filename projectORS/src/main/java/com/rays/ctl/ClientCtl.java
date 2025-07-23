package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.ClientDTO;
import com.rays.form.ClientForm;
import com.rays.service.ClientServiceInt;

@RestController
@RequestMapping(value="Client")
public class ClientCtl extends BaseCtl<ClientForm, ClientDTO, ClientServiceInt>{

	@Autowired
	private ClientServiceInt ClientService;
	
    @GetMapping("/preload")
	public ORSResponse preload() {		

    ORSResponse res = new ORSResponse(true);
	ClientDTO dto = new ClientDTO();
	List<DropdownList> list = ClientService.search(dto, userContext);
	res.addResult("inlist", list);
	
	return res;

    }
}