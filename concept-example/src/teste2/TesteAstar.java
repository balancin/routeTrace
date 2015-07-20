package teste2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TesteAstar {
	
	private static HashMap<String, HashMap<String, Integer>> newRoutes;
	
	private static List<String> openList;
	private static List<String> closedList;
	
	public static void main(String[] args) {
		
		HashMap<String, HashMap<String, Integer>> rotas = new HashMap<String, HashMap<String, Integer>>();
		
		HashMap<String, Integer> ap = new HashMap<String, Integer>();
		ap.put("B", 1);
		ap.put("C", 2);
		rotas.put("A", ap);
		
		HashMap<String, Integer> bp = new HashMap<String, Integer>();
//		bp.put("D", 1);
//		bp.put("F", 1);
		bp.put("C", 1);
		rotas.put("B", bp);

		HashMap<String, Integer> cp = new HashMap<String, Integer>();
		cp.put("D", 1);
		rotas.put("C", cp);
		
		HashMap<String, Integer> dp = new HashMap<String, Integer>();
//		dp.put("C", 1);
		dp.put("E", 1);
		rotas.put("D", dp);

		HashMap<String, Integer> fp = new HashMap<String, Integer>();
		fp.put("F", 1);
		rotas.put("E", fp);

		System.out.println(rotas);
		consolidateRoutes(rotas);
		System.out.println(newRoutes);
		
		String fromKey = "A";
		String toKey = "F";
		int estimative = heuristicFromTo(fromKey, toKey, new HashMap<String, HashMap<String, Integer>>(newRoutes));
		System.out.println("h "+estimative);
		
		int i = 0;
//		openList.add("A");
		
//		do{
			
			for(String key : newRoutes.get(fromKey).keySet()){
//				int hEstimative = heuristicFromTo(key, toKey, new HashMap<String, HashMap<String, Integer>>(newRoutes));
				System.out.println(key);
			}
			
			i++;
			
//		} while(i < 3);
		
	}
	
	private static boolean stopScan = false;
	
	private static int heuristicFromTo(String fromKey, String toKey, HashMap<String, HashMap<String, Integer>> scanRoutes){

		int cost = 0;
		
		if(scanRoutes.get(fromKey).containsKey(toKey)){
			cost += scanRoutes.get(fromKey).get(toKey);
			stopScan = true;
		}
		
		for(String key : scanRoutes.get(fromKey).keySet()){

			if(!stopScan){
				cost += scanRoutes.get(fromKey).get(key);
				if(scanRoutes.get(key).containsKey(toKey)){
					cost += scanRoutes.get(key).get(toKey);
					stopScan = true;
					break;
				} else {
	
					if(scanRoutes.get(key).containsKey(fromKey)){
						scanRoutes.get(key).remove(fromKey);
					}
	
					cost += heuristicFromTo(key, toKey, scanRoutes);
	
				}
			}
			
		}
		
		return cost;
		
	}
	
	private static void putNewRoute(String routeKey, HashMap<String, Integer> route){
		
		if(newRoutes.containsKey(routeKey)){
			HashMap<String, Integer> existingRoutes = newRoutes.get(routeKey);
			existingRoutes.putAll(route);	
		} else {
			newRoutes.put(routeKey, route);
		}
		
	}
	
	private static void consolidateRoutes(HashMap<String, HashMap<String, Integer>> rotas){
		
		newRoutes = new HashMap<String, HashMap<String, Integer>>();
		newRoutes.putAll(rotas);
		
		for(String routeKey : rotas.keySet()){

			for(String subRouteKey : rotas.get(routeKey).keySet()){

				if(rotas.containsKey(subRouteKey)){
					
					if(!rotas.get(subRouteKey).containsKey(routeKey)){

						HashMap<String, Integer> newRoute = new HashMap<String, Integer>();
						newRoute.put(routeKey, rotas.get(routeKey).get(subRouteKey));
						putNewRoute(subRouteKey, newRoute);
						
					}

				} else if(!subRouteKey.equals(routeKey)){
					
					HashMap<String, Integer> newRoute = new HashMap<String, Integer>();
					newRoute.put(routeKey, rotas.get(routeKey).get(subRouteKey));
					putNewRoute(subRouteKey, newRoute);
					
				}
			}
			
		}
		
	}

}
