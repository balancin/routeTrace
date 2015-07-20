package br.com.walmart.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.walmart.WMResponse;
import br.com.walmart.bean.AddressBean;
import br.com.walmart.data.model.Address;
import br.com.walmart.data.model.SimpleRoute;
import br.com.walmart.data.repository.AddressRepository;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping("/address")
public class AddressRestService {
	
	Logger logger = Logger.getLogger(AddressRestService.class);

    @Autowired
    private AddressRepository repository;  
    
	@RequestMapping("/save")
	public WMResponse saveMap(
			List<SimpleRoute> simpleRoute,
			@RequestParam(value = "name", required = true) String origin
	){
		
		WMResponse response = new WMResponse();

		return response;
		
	}
	
	@RequestMapping("/get")
	public WMResponse getRoute(
			@RequestParam(value = "origin", required = true) String origin,
			@RequestParam(value = "destiny", required = true) String destiny
	){

		WMResponse response = new WMResponse();
				
		return response;
      
	}
	
}