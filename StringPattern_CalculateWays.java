package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class StringPattern_CalculateWays {
	
static Set<StringBuilder> patterns=new HashSet<StringBuilder>();

	
	public static int calculateWays(int wordLen,int maxVowels) {
		
		char[] arr=new char[wordLen];
		generateAllPatterns(wordLen,arr,0,maxVowels);
		System.out.println(patterns);
		Long result;
		result = patterns.stream().mapToLong((e)->{
				Long total= 1L;
				for(int i=0;i<e.length();i++){
					if(e.charAt(i)=='C')
						total*= 21;
					else
						total*=5;
				}
				System.out.println(e + " "+ total);
				return total;
			}).sum();
		
	
		
		return (int) (result % 1000000007);
	}
	static void generateAllPatterns(int n, char arr[], int i,int maxVowels) 
		{ 
			if (i == n)  
			{ 
				printPatterns(arr, n, maxVowels); 
			return; 
			} 

				// First assign "C" at ith position 
				// and try for all other permutations 
				// for remaining positions 
				arr[i] ='C'; 
					generateAllPatterns(n, arr, i + 1,maxVowels); 

				// And then assign "V" at ith position 
				// and try for all other permutations 
				// for remaining positions 
				arr[i] ='V'; 
				generateAllPatterns(n, arr, i + 1, maxVowels); 
		} 
	
	
	// Function to print the output 
		static void printPatterns(char arr[], int n, int maxVowels) 
		{ 
			StringBuilder builder=new StringBuilder();
			int count = 0;
		    for (int i = 0; i < n; i++)  
		    { 
		    	builder.append(arr[i]);
		    	if(arr[i] == 'V')
		    		count++;
		    	if(count>maxVowels)
		    		break;
		       // System.out.print(arr[i]+" "); 
		    } 
		    if(count<=maxVowels){
		    	patterns.add(builder);
		    }
		   // System.out.println(builder); 
		} 

	public static void main(String[] args) {
		System.out.println(calculateWays(4, 1));

	}
}
