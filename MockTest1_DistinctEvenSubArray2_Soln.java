package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MockTest1_DistinctEvenSubArray2_Soln {

	  private static List<List<Integer>> result = new ArrayList<>();
	  public static int evenSubarray(List<Integer> numbers, int k) {

	    	
	    	List<Integer> nums=null;
	    	HashSet<List<Integer>> subarr=new HashSet<>();
	    	
	    	int count=0,oddcount=0;
	    	
	    	for(int i=0;i<=numbers.size();i++) {
	    		nums=new ArrayList<Integer>();
	    		
	    		for(int j=i+1;j<=numbers.size();j++) {
	    			{
	    				//Sub Array
	    				nums =numbers.subList(i, j);
	    				
	    				//Sub Array exists in HashSet
	    				if(!subarr.contains(nums)) {
	    					
	    					//Add subArray into HashSet
		    				subarr.add(nums);
		    				//Odd count zero
		    				oddcount=0;
		    				for(int n:nums) {
		    					if(n%2!=0)
		    						oddcount++;
		    				}
		    				if(oddcount<=k)
		    					count++;
	    				}
	    			}
	    		}
	    		
	    	}
	    	System.out.println(subarr);
	    	System.out.println("output:"+ count);
	    	return count;
	    
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
