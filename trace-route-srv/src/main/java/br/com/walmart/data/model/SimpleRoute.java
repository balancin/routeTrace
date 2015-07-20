package br.com.walmart.data.model;

import org.springframework.data.annotation.Id;

public class SimpleRoute {

	@Id
	private String routeId;
	
	private String origin;
	private String destiny;
	
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
			
}
