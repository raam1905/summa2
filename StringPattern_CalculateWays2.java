package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StringPattern_CalculateWays2 {
	
static Set<StringBuilder> patterns=new HashSet<StringBuilder>();

	
	public static int calculateWays(int wordLen,int maxVowels) {
		List<String> patterns = new ArrayList<>();
		Long result=0L;
		String vowelPattern = Stream.generate(()->"1").limit(maxVowels+1).reduce((a, b)->a+b).get();
		long startVal = 0;
		Double maxVal=Math.pow(2, wordLen); 
		long endVal =maxVal.longValue();
		
		
		for(startVal = 0; startVal<endVal;startVal++){
			
			String s = Long.toBinaryString(startVal);
			if(s.length()<wordLen){
				s=Stream.generate(()->"0").limit(wordLen-s.length()).reduce((a, b)->a+b).get() + s;
			}
		//	System.out.println(s);
			if(!s.contains(vowelPattern)){
				patterns.add(s);
				
				
				Long currentWordPossiblity= 1L;
				for(int i=0;i<s.length();i++){
					if(s.charAt(i)=='0')
						currentWordPossiblity*= 21;
					else
						currentWordPossiblity*=5;
				}
				result= result+currentWordPossiblity;
				
			}
			
		}
		System.out.println(patterns);
		
		
		return (int) (result % 1000000007);
		
	}
	public static void main(String[] args) {
		System.out.println(calculateWays(4, 1));
		patterns.stream().peek((e)->System.out.println("peek"+ e)).forEach(System.out::println);;
	}
}
