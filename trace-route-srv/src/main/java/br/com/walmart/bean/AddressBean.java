package br.com.walmart.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import br.com.walmart.data.repository.AddressRepository;

@Component("addressBean")
public class AddressBean {
	
	@Autowired
	AddressRepository addressRepository;

	
}
