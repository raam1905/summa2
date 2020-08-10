/*package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PowerSurge2 {

	public static int reduceCapcacity(List<Integer> activeGenerators){	
		int result =0;

	Comparator<String> customComparator = (a, b)->{
		int occurencesOfA = Collections.frequency(activeGenerators, a);
		int occurencesOfB = Collections.frequency(activeGenerators, b);
		
		if(occurencesOfA>occurencesOfB)
			return 1;
		else if (occurencesOfA<occurencesOfB)
			return -1;
		else 
			return 0;
	};
		Map<Integer,List<Integer>> generatorsMapGroupByCount = new TreeMap<>(Comparator.reverseOrder());
		Integer minGeneratorsToBeDeactivated = ((Double)Math.ceil(activeGenerators.size() /2.0)).intValue();
		List<Integer> chosenModels = new ArrayList();
		
		List<Integer> sortedInput = activeGenerators.stream().distinct().sorted((a,b)->{a}).collect(Collectors.toList());
		
		for(Integer e: sortedInput){
			int generatorCount = Collections.frequency(activeGenerators, e);
			minGeneratorsToBeDeactivated= minGeneratorsToBeDeactivated- generatorCount;
			chosenModels.add(e);
			if(minGeneratorsToBeDeactivated <=0)
				break;
			if(generatorsMapGroupByCount.containsKey(generatorCount)){
				generatorsMapGroupByCount.get(generatorCount).add(e);
			}
			else{
				generatorsMapGroupByCount.put(generatorCount, new ArrayList<>(Arrays.asList(e)));
			}
		};
		System.out.println(chosenModels);
		
		Iterator<Integer> itr = generatorsMapGroupByCount.keySet().iterator();
		while(itr.hasNext() && minGeneratorsToBeDeactivated >0){
			int activeGeneratorsCount = itr.next();
			List<Integer> generatorTypes = (List<Integer>) generatorsMapGroupByCount.get(activeGeneratorsCount);
			Integer minModelsTobeChosen;
		//	System.out.println(minGeneratorsToBeDeactivated);
			
			if(activeGeneratorsCount * generatorTypes.size() > minGeneratorsToBeDeactivated){
				minModelsTobeChosen = ((Double)Math.ceil(activeGeneratorsCount * generatorTypes.size() / (double)minGeneratorsToBeDeactivated)).intValue();
			}
			else{
				minModelsTobeChosen = generatorTypes.size();
			}
			minGeneratorsToBeDeactivated= minGeneratorsToBeDeactivated - (minModelsTobeChosen * activeGeneratorsCount);
			result=result+minModelsTobeChosen;
			
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer[] tmp = {3,4,6,11,9,9,9,9,8,8,8,8,8};
		Integer[] tmp = { 3, 4, 6, 11, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8 };
		// Integer[] tmp = {6,6,6,6,7,7,7,7,5};

		List<Integer> input = new ArrayList<>(Arrays.asList(tmp));

		System.out.println(reduceCapcacity(input));

	}

}
*/