package br.com.walmart.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component; 

import br.com.walmart.data.model.WMMap;

@Component
public interface AddressRepository extends MongoRepository<WMMap, String> {

	public List<WMMap> findByName(String name);
	
}
