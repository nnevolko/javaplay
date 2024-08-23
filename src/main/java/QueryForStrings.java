import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryForStrings {

	
	public List<Integer> matchStrings(List<String> strings, List<String> queries){
		
		List<Integer> queryOccuranceList = new ArrayList<Integer>();
		
		Map<String, Integer> stringsMap = new HashMap<String, Integer>();
		
		for (String stringie: strings) {
			if(stringsMap.containsKey(stringie)){
				int value = stringsMap.get(stringie);
				stringsMap.replace(stringie, value+1);
			}else {
				stringsMap.put(stringie, 1);
			}
		}
		
		//create parallel array: query | number of occurences
		for (String query: queries) {
			if(stringsMap.containsKey(query)) {
				int occurence = stringsMap.get(query);
				queryOccuranceList.add(occurence);
			} else {
				queryOccuranceList.add(0);
			}
		}
		
		return queryOccuranceList;
		
	}
}
