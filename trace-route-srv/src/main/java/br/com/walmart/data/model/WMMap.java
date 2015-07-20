package br.com.walmart.data.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class WMMap {

	@Id
	private String routeId;
	
	private List<SimpleRoute> simpleRoute;

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public List<SimpleRoute> getSimpleRoute() {
		return simpleRoute;
	}

	public void setSimpleRoute(List<SimpleRoute> simpleRoute) {
		this.simpleRoute = simpleRoute;
	}
	
}
