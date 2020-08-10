package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WaysToSum2 {
	static Map<String, Map<Character, Integer>> charOccurrencesCache = new HashMap<>();

	public static String manipulateString(String s, int rightPos, int k){
		String numbers[] = s.split(",");
		int upperLimit = numbers.length- rightPos;
		if(upperLimit<0)
			return "-1";
		List<String> nextString = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(numbers, 0, upperLimit)));
		int total =  Integer.parseInt(numbers[upperLimit]) + Integer.parseInt(numbers[++upperLimit]);
		if(total>k)
			return null;
		nextString.add("" + total);
		++upperLimit;
		while(upperLimit<numbers.length){
			nextString.add(numbers[upperLimit]);
			upperLimit++;
		}
		
		return nextString.stream().sorted().reduce((a, b)->a+","+b).get();
	}
	public static int waysToSum(int total, int k) {
		List<String> result = new ArrayList<>();
		String firstRow = Stream.generate(()->"1").limit(total).reduce((a, b)->a+","+b).get();
		result.add(firstRow);
		int startPos=0;
		int rowPointer=startPos;
		int columnPointer = 2;
		while(rowPointer<result.size()){
			String s= manipulateString(result.get(rowPointer), columnPointer, k);
			
			if(s==null){
				columnPointer++;
				rowPointer = ++ startPos;
			}
			else if(s.equals("-1")){
				break;
			}
			else{
				if(!result.contains(s))
					result.add(s);
				rowPointer++;
			}
			
		}
	//	System.out.println(result);
		return result.size();
	}
	public static int count(List<Integer> s, int m, int n ) 
	{ 
	    // table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
		
	    int table[]=new int[n+1]; 
	  
	    // Base case (If given value is 0) 
	    table[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the 
	    // picked coin 
	    for(int i=0; i<m; i++) 
	        for(int j=s.get(i); j<=n; j++) {
	            table[j] += table[j-s.get(i)];
	            for(int k=0;k<table.length;k++)	
	            	System.out.print(" " + table[k]);
	            System.out.println(" ");
	            	
	        }
	  
	    return table[n]; 
	} 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=3; //m
		int total= 3; //n
		
		List<Integer> tmp = new ArrayList<>(IntStream.rangeClosed(1, k).boxed().collect(Collectors.toList()));
		//Integer s[] = tmp.toArray();
		//System.out.println(tmp);
		
		//System.out.println(Math.pow(2, 3));
		System.out.println(count(tmp,k,total));
		//System.out.println(waysToSum(5, 3));
		//System.out.println(waysToSum(56, 23));
		
	}

	public String sort(char[] c) {
		Arrays.sort(c);
		return new String(c);
	}

}
