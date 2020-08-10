package smallPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinSum {
/*
 * 
 * 1 2 3 4
 * 
 * 1,2    1,3     1,4
 * 
 * 1,2,3      1,2,4
 * 
 * 1234
 * 
 * 2,3    2,4
 * 2,3,4
 * 
 * 
 * 
 */

	
	public static int printPattern(List<Integer> input,int target) {
		
		if(input.contains(target)){
			return 1;
		}
	
		if(target<0)
			return -1;
		
		
		List<String> patterns = new ArrayList<>();
		Long result=0L;
	
		long startVal = 0;
		Double maxVal=Math.pow(2, input.size()); 
		long endVal =maxVal.longValue();
		
		int total = 0;
		List<Integer> pickedElements = new ArrayList<>();
		for(startVal = 0; startVal<endVal;startVal++){
			total=0;
			List<Integer> currentSelection = new ArrayList<>();
			String s = Long.toBinaryString(startVal);
			if(s.length()< input.size()){
				s=Stream.generate(()->"0").limit( input.size()-s.length()).reduce((a, b)->a+b).get() + s;
			}
		//	System.out.println(s);
			
			for(int i =0;i< s.length();i++){
				if(s.charAt(i)=='1'){
					total=total+input.get(i);
					currentSelection.add(input.get(i));
				}
			}
			if(total == target){
				
				if(pickedElements.size()==0 || pickedElements.size()>currentSelection.size()){
					pickedElements.clear();
					pickedElements.addAll(currentSelection);
				}
			}
			patterns.add(s);
				
				
				
			
		}
		System.out.println(patterns);
		System.out.println(pickedElements);
		
		return (int) (result % 1000000007);
		
	}
	
	
	
	
	
	/*static List<List<Integer>> subArrays = new ArrayList<>();
	 public static void generateSubArrays(List<Integer> input, int target){

	     	
     	List<Integer> result = new ArrayList<>();	       
	        for (int startPoint = 0; startPoint <input.size() ; startPoint++) {

	        	for (int subListSize = startPoint; subListSize <=input.size() ; subListSize++) {

	            	List<Integer> currentSubArray = new ArrayList<>();
	            	int total=0;
	                for (int j = startPoint ; j < subListSize ; j++) {
	                  
	                    total+=input.get(j);
	                    currentSubArray.add(input.get(j));
	                }
	                if(total == target){
	                	if(result.size()==0 || result.size()>currentSubArray.size()){
	                		result.clear();
	                		result.addAll(currentSubArray);
	                	}
	                }
	                subArrays.add(currentSubArray);
	            }
	        }
	        System.out.println("Given Input : " +input );
	        System.out.println("Elements picked: " + result);
	        System.out.println("Count of Elements: " + result.size());
	    }
	*/
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[]={1,2,3,4,5};
		Integer targetSum = 5;
	//	generateSubArrays(Arrays.asList(a),targetSum);
		printPattern(Arrays.asList(a), targetSum);
		
	}

}
