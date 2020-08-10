package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PowerSurge {

	public static int reduceCapcacity(List<Integer> activeGenerators){	

		Comparator<Integer> sortByModelCountComparator = (a, b)->{
			int occurencesOfA = Collections.frequency(activeGenerators, a);
			int occurencesOfB = Collections.frequency(activeGenerators, b);
			
			if(occurencesOfA > occurencesOfB)
				return -1;
			else if (occurencesOfA < occurencesOfB)
				return 1;
			else 
				return 0;
		};
		
		Integer minGeneratorsToBeDeactivated = ((Double)Math.ceil(activeGenerators.size() /2.0)).intValue();
		List<Integer> chosenModels = new ArrayList<>();
		
		List<Integer> sortedInput = activeGenerators.stream().distinct().sorted(sortByModelCountComparator).collect(Collectors.toList());
		
		for(Integer e: sortedInput){
			int generatorCount = Collections.frequency(activeGenerators, e);
			minGeneratorsToBeDeactivated= minGeneratorsToBeDeactivated- generatorCount;
			chosenModels.add(e);
			if(minGeneratorsToBeDeactivated <=0)
				break;
			
		};
		
		//System.out.println(chosenModels);
		return chosenModels.size();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] tmp = {3,4,6,11,9,9,9,9,8,8,8,8,8};
		//Integer[] tmp = { 3, 4, 6, 11, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8 };
		 //Integer[] tmp = {6,6,6,6,7,7,7,7,5};

		List<Integer> input = new ArrayList<>(Arrays.asList(tmp));

		System.out.println(reduceCapcacity(input));

	}

}
