package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveSumValue { 
	
	public static int consecutive(int target){
		int startPos=1;
		int sum=0;
		int count =0;
		int i = 1;
		List<Integer> list = new ArrayList<>();
		while(i<= Math.ceil(target/2.0)){
			
			sum+=i;
			
			if(sum< target){
				i++;
			}
			else if(sum == target){
				startPos++;
				i= startPos;
				sum=0;
				count++;
			}
			else{
				startPos++;
				i= startPos;
				sum=0;
			}
		}
	
		
		return count;
	}


   	public static void main(String[] args) {
		
		
		
		System.out.println(consecutive(25));
		//System.out.println(isPangram("the quick brown fox jumps over the lazy dog."));
	
	/*	int a[] = { 2,1,2,1,3 };
		int n = a.length;
		int m = 2;

		System.out.println(distinctSubarraysAtMostKOdd(a, m));
*/	}
}