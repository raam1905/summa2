package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortEvents {

	
	
	
	static Map<Integer,Map<String,List<String>>> orderedEventsMap = new TreeMap<>();
	
	static Integer getEventOrder(String eventCode) {
		if ("G".equals(eventCode))
			return 0;
		if ("Y".equals(eventCode))
			return 1;
		if ("R".equals(eventCode))
			return 2;
		if ("S".equals(eventCode))
			return 3;
		
		return 4;
	}
	public static void addToSortedEventsMap(String teamName, String[] teamEvents){
		
		for(String t:Arrays.asList(teamEvents)){
			String empname ="";
			String event ="";
			String secondEmp ="";
			String startTime = "";
			int startTimeKey;
			String subMapKey;
			int partition = 0;
			Map<String,List<String>> subMap ;
			
			String[] values = t.split(" ");
			
			for(String s: values){
				if(Character.isDigit(s.charAt(0))){ 
					startTime= s;
					partition = 1;
					//break;
				}
				else{
					if(partition ==0 ){
						empname = empname + s;
					}
					else if(partition == 1){
						partition++;
						event = s;
					}
					else if( partition == 2 )
						secondEmp = secondEmp + s;
				}
			}
			subMapKey = getEventOrder(event)+"#"+teamName+"#"+empname+"#"+secondEmp;
			if(startTime.contains("+")){
				startTimeKey = 45;
				//recordsMap.put(45,  t);
			}
			else{
				startTimeKey = Integer.parseInt(startTime);
		
			//	recordsMap.put(Integer.parseInt(startTime), t);
			}
			
			
			if( orderedEventsMap.containsKey(startTimeKey))
				subMap = orderedEventsMap.get(startTimeKey);
			else
				subMap = new TreeMap<String,List<String>>();
			

			if( subMap.containsKey(subMapKey)){
				subMap.get(subMapKey).add(teamName + " " +t);
			}
			else{
				List<String> list = new ArrayList<>();
				list.add( teamName + " " +t);
				subMap.put(subMapKey,list);
			}
			
			orderedEventsMap.put(startTimeKey, subMap);
			 
		}
	}
	
	public static List<String> getEventsOrder(String team1,String team2, String[] team1events, String[] team2events){
		List<String> result = new ArrayList<>();
	
		addToSortedEventsMap(team1,team1events);
		addToSortedEventsMap(team2,team2events);
		//String startTime = null;
		
		
	
		//System.out.println(orderedEventsMap);
		//orderedEventsList.addAll(recordsMap.values());
		for(Map<String,List<String>> map: orderedEventsMap.values()){
			result.addAll(map.values().stream().flatMap((a)-> {
				return a.stream();
		}).collect(Collectors.toList()));
			
		}
		//System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String t1= "abc";
		String t2="cba";
		
		String[] e1= {"mo sa 45+2 Y","a 13 G"};
		String[] e2= {"d 23 S f","z 46 G"};*/
		
		String t1= "nolh";
		String t2="uzrddrc slcpx";
		
		String[] e1= {"inmuucz jzbkica 70 Y", "ton wfnt 10 S inmuucz jzbkica", "ecya kgvgy 20 S fkfk fuiyb senmofw"};
		String[] e2= {"mysior pqfcz bxlnpn 49 G","mysior pqfcz bxlnpn 18 G", "enc otagavd oevfg 68 Y"};
		System.out.println(getEventsOrder(t1,t2,e1,e2));
	
	} 

}
