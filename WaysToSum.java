package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WaysToSum {
	static Map<String, Map<Character, Integer>> charOccurrencesCache = new HashMap<>();

	public static int waysToSum(int total, int k) {
		List<List<Integer>> result = new ArrayList<>();
		int rowpos=0;
		int colpos = 0;
		List<Integer> baseRow = IntStream.iterate(1,(i)->1).limit(total).boxed().collect(Collectors.toList());
		result.add(baseRow);
		
		
		List<Integer> l = new ArrayList<>(result.get(rowpos));
		while(rowpos < result.size()){
			
			while(colpos<l.size()){
				int sum = l.get(colpos) + l.get(colpos+1);
				if(sum<=k){
					l.set(colpos,sum);
					l.remove(l.size()-1);
					result.add(l);
				}
				
			}
			rowpos++;
		/*	for(int colpos= 0; colpos< l.size()-1 ;colpos++){
				l.set(colpos,l.get(colpos) + l.get(colpos+1));
				l.remove(l.size()-1);
				result.add(l);
				
				System.out.println(l);
				
			}
				*/
			
			
		}
		
		
		
		return 0;
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
	        for(int j=s.get(i); j<=n; j++) 
	            table[j] += table[j-s.get(i)]; 
	  
	    return table[n]; 
	} 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
	

		System.out.println(waysToSum(5, 3));
	}

	public String sort(char[] c) {
		Arrays.sort(c);
		return new String(c);
	}

}
