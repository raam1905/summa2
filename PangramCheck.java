package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class PangramCheck { 
	



    public static boolean isPangram(String s){
    	if(s == null || s.length()<26)
    		return false;
    	
    	String str= s.replace("\\s", "");
		System.out.println(str);
		Set<Character> distinctChars = new HashSet<>();
		for(int i = 0;i<str.length();i++){
				if(Character.isAlphabetic(str.charAt(i)))
					distinctChars.add(str.charAt(i));
		}
		
		if(distinctChars.size()==26)
			return true;
		else
			return false;
    }
	// Driver code
	public static void main(String[] args) {
		
		
		
		System.out.println(isPangram("the quick brown fox jumps over the lazy dog."));
	
	/*	int a[] = { 2,1,2,1,3 };
		int n = a.length;
		int m = 2;

		System.out.println(distinctSubarraysAtMostKOdd(a, m));
*/	}
}