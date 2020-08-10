package hackerrank;

import java.util.HashMap;

public class Numerology { 
	
	public static int getNumerologyNumber(String s){
		HashMap<Character, Integer> numberMap = new HashMap<>();
		numberMap.put('A', 1);
		numberMap.put('B', 2);
		numberMap.put('C', 3);
		numberMap.put('D', 4);
		numberMap.put('E', 5);
		numberMap.put('F', 8);
		numberMap.put('G', 3);
		numberMap.put('H', 5);
		numberMap.put('I', 1);
		numberMap.put('J', 1);
		numberMap.put('K', 2);
		numberMap.put('L', 3);
		numberMap.put('M', 4);
		numberMap.put('N', 5);
		numberMap.put('O', 7);
		numberMap.put('P', 8);
		numberMap.put('Q', 1);
		numberMap.put('R', 2);
		numberMap.put('S', 3);
		numberMap.put('T', 4);
		numberMap.put('U', 6);
		numberMap.put('V', 6);
		numberMap.put('W', 6);
		numberMap.put('X', 5);
		numberMap.put('Y', 1);
		numberMap.put('Z', 7);
		int  sum = 0;
		//String str= s.replace("\\s", "");
		for(int i = 0 ;i< s.length();i++){ 
			if(numberMap.containsKey(s.charAt(i))){
				sum+= numberMap.get(s.charAt(i));
			}
		}
		int n= sum;
		sum=0;
		while(n>0){
			sum+= n%10;
			n=n/10;
			
		}
		return sum;
	}


   	public static void main(String[] args) {
		
		
		
		System.out.println(getNumerologyNumber("S. KANAPATHY"));
		//System.out.println(isPangram("the quick brown fox jumps over the lazy dog."));
	
	/*	int a[] = { 2,1,2,1,3 };
		int n = a.length;
		int m = 2;

		System.out.println(distinctSubarraysAtMostKOdd(a, m));
*/	}
}