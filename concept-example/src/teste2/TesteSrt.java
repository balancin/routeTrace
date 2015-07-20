package teste2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TesteSrt {
	
	public static void main(String[] args) {
		
		HashMap<String, HashMap<String, Integer>> monthTotals = new HashMap<String, HashMap<String, Integer>>();
		
		HashMap<String, Integer> dayTotals = new HashMap<String, Integer>();
		dayTotals.put("07", 2);
		dayTotals.put("02", 0);
		dayTotals.put("05", 2);
		
		HashMap<String, Integer> dayTotalsB = new HashMap<String, Integer>();
		dayTotalsB.put("01", 2);
		dayTotalsB.put("06", 1);
		dayTotalsB.put("02", 0);
		
		monthTotals.put("2015-03", dayTotals);
		monthTotals.put("2015-01", dayTotalsB);
        
		preview(monthTotals);
		TreeMap<String, TreeMap<String, Integer>> monthTotalss = new TreeMap<String, TreeMap<String, Integer>>();
		
		HashMap<String, HashMap<String, Integer>> sortedMonthTotals = new HashMap<String, HashMap<String, Integer>>();
		for(String month : monthTotals.keySet()){
			
			Map<String, Integer> map = new TreeMap<String, Integer>(monthTotals.get(month)); 
//			sortedMonthTotals.put(month, (HashMap<String, Integer>) map);
			
			HashMap<String, String> hashMap = (map instanceof HashMap) ? (HashMap) map : new HashMap<String, Integer>(map);
					      
//	        Map<String, ?> map = new TreeMap<String, HashMap<String, Integer>>(monthTotals); 
	        System.out.println("After Sorting:"+map+" "+hashMap);
	        Set set2 = map.entrySet();
	        Iterator iterator2 = set2.iterator();
	        while(iterator2.hasNext()) {
	             Map.Entry me2 = (Map.Entry)iterator2.next();
	             System.out.print(me2.getKey() + ": ");
	             System.out.println(me2.getValue());
	        }
			
		}

		preview(sortedMonthTotals);
		
	}
	
	private static <K, V> V forceGet(TreeMap<K, V> sortedMap) {
		
//		Map<String, ?> map = new TreeMap<String, HashMap<String, Integer>>(monthTotals); 
		System.out.println("After Sorting:");
        Set set2 = sortedMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
             Map.Entry me2 = (Map.Entry)iterator2.next();
             System.out.print(me2.getKey() + ": ");
             System.out.println(me2.getValue());
        }
        
		return null;

	}
	
	private static void preview(HashMap<String, ?> totals){
		
        System.out.println("Before Sorting:");
        Set set = totals.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
              Map.Entry me = (Map.Entry)iterator.next();
              System.out.print(me.getKey() + ": ");
              System.out.println(me.getValue());
        }
        
//        forceGet(new TreeMap<String, HashMap<String, Integer>>(totals)); 
        
	}

}
