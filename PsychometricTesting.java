package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PsychometricTesting {

	public static List<Integer> jobOffers(List<Integer> scores, List<Integer> lowerLimit, List<Integer> upperLimit){
		List<Integer> result = IntStream.generate(()->{ return 0;}).limit(lowerLimit.size()).boxed().collect(Collectors.toList());
		
		for(int i=0;i<scores.size();i++){
			for(int j=0;j<lowerLimit.size();j++){
				if(scores.get(i)>=lowerLimit.get(j) && scores.get(i)<= upperLimit.get(j)){
					result.set(j, result.get(j)+1);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Integer[] scores = {4,8,7 };
		Integer[] lowerLimit ={2,4};
		Integer[] upperLimit ={8,4};*/
		
		
		Integer[] scores = {1,3,5,6,8 };
		Integer[] lowerLimit ={2};
		Integer[] upperLimit ={6};
		
		System.out.println(jobOffers(Arrays.asList(scores),Arrays.asList(lowerLimit),Arrays.asList(upperLimit)));
	}

}
