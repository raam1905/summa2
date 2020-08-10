package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DevTeamThreshold {

	public static double getThreshold(int seniorCount, int totalCount){
		return ((seniorCount*100.0)/totalCount);
	}
	public static int hireSeniorDevs2(List<List<Integer>> teams , int r) {
		int totalTeams = teams.size();
		int totalNewHireCount = 0;
		double avgThreshold = teams.stream().mapToDouble((team)->getThreshold(team.get(0),team.get(1))).average().getAsDouble();
		while(avgThreshold <r){
		//	1,2   1,3   1,4  
			
			List<Integer> teamCountsList = teams.stream().map((e)->e.get(1)).collect(Collectors.toList());
			int minTeamIndex =0;
			int minValue= teamCountsList.get(0);
			for(int i=1;i< teamCountsList.size();i++){
				if(teamCountsList.get(i)<minValue){
					minTeamIndex=teamCountsList.indexOf(teamCountsList.get(i));
					minValue = teamCountsList.get(i);
				}
			}
			int seniorCount = teams.get(minTeamIndex).get(0);
			int totalCount = teams.get(minTeamIndex).get(1);
			
			teams.get(minTeamIndex).set(0,seniorCount+1);
			teams.get(minTeamIndex).set(1,totalCount+1);
			
			totalNewHireCount++;
			avgThreshold = teams.stream().mapToDouble((team)->getThreshold(team.get(0),team.get(1))).sum() / totalTeams;
		}
		return totalNewHireCount;
	}
	
	public static int hireSeniorDevs(int teams[][], int r) {
		int totalNewHireCount = 0;
		for(int i = 0;i<teams.length;i++){
			int seniorCount = teams[i][0];
			int totalCount = teams[i][1];
			int newHiresCount = 0;
			
			double teamThreshold =((seniorCount*100.0)/totalCount) ;
			while(teamThreshold < r){
				float singleSeniorResourcePercent = ((float)1/totalCount)* 100;
			//	System.out.println(newHiresCount);
				newHiresCount = (int) (newHiresCount + Math.ceil((r-teamThreshold) /singleSeniorResourcePercent));
				totalCount = totalCount + newHiresCount;
				seniorCount= seniorCount+ newHiresCount;
				teamThreshold =((seniorCount*100.0)/totalCount); 
			}
			totalNewHireCount= totalNewHireCount+newHiresCount;
			/*if(teamThreshold<r){
				System.out.println(newHireCount);
				newHireCount = (int) (newHireCount + Math.ceil((r-teamThreshold) /singleSeniorResourcePercent));
			}*/
				
		}
		return totalNewHireCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int teams[][] = {{1,2},{2,3} };
		List<List<Integer>> input = new ArrayList<>();
		List<Integer> team1 = new ArrayList<>();
		List<Integer> team2 = new ArrayList<>();
		team1.add(1);
		team1.add(2);
		
		team2.add(2);
		team2.add(3);
		
		/*team1.add(1);
		team1.add(2);
		
		team2.add(1);
		team2.add(3);*/
		
		input.add(team1);
		input.add(team2);
		
		System.out.println(hireSeniorDevs2(input,75));
	}

}
