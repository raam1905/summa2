package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MockTest1_DistinctEvenSubArray {

	  private static List<List<Integer>> result = new ArrayList<>();
	    public static void subArrays(List<Integer> numbers, int startpos, int endpos, int k){

	        int oddNumbersLimit = k;
	        if(numbers.size() == endpos)
	            return;
	        if(startpos > endpos)
	            subArrays(numbers,0, endpos+1,k);
	        else{
	            List<Integer> subArray = new ArrayList<>();
	            for(int i= startpos; i<=endpos;i++){
	                if(numbers.get(i) %2 ==1)
	                    oddNumbersLimit--;
	                if(oddNumbersLimit<0)
	                    break;
	                subArray.add(numbers.get(i));
	            }
	            if(oddNumbersLimit>=0)
	                result.add(subArray);
	            subArrays(numbers,startpos+1, endpos,k);
	            
	        }
	    }
	    public static int evenSubarray(List<Integer> numbers, int k) {
	    // Write your code here
	        subArrays(numbers,0,0,k);
	        
	       
	       System.out.println(result);
	       System.out.println(result.stream().count());
	       return (int)result.stream().distinct().count();
	      

	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k;
		List<Integer> l = new ArrayList<>();
		 k = 2;
		
		l.add(2);
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(3);
		
		
	/*	k=1;
		l.add(6);
		l.add(3);
		l.add(5);
		l.add(8);*/
		
		System.out.println(evenSubarray(l, k));
		
	}

}
