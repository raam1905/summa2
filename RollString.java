package hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RollString {

	public static char roll_character(char c, int roll) { 
        roll = roll % 26; 
        int position_in_alphabetsList = c - 'a'; 
       
        return (char) ('a' + (position_in_alphabetsList + roll) % 26); 
    } 
	
	  public static String rollTheString_v2(String s, int roll[]) { 
		  
	        int toRollLength = s.length(); 
	        int each_character_roll[] = new int[toRollLength]; 
	        char[] toRollCharArr = s.toCharArray(); 
	  
	        for (int i = 0; i < roll.length; ++i) { 
	            ++each_character_roll[0]; 
	            int noOfRoll = roll[i]; 
	            if (noOfRoll >= each_character_roll.length) 
	                continue; 
	            else
	                --each_character_roll[noOfRoll]; 
	        } 
	       
	        IntStream.range(1, toRollLength).forEach(index -> { 
	            each_character_roll[index] = each_character_roll[index] + each_character_roll[index - 1]; 
	        }); 
	  
	        IntStream.range(0, toRollLength).forEach(index -> { 
	            toRollCharArr[index] = roll_character(toRollCharArr[index], each_character_roll[index]); 
	        }); 
	  
	        return String.valueOf(toRollCharArr); 
	  }
	  public static String rollTheString(String toRoll, int roll[]) { 
		  
		char[] inputCharArr = toRoll.toCharArray();
		for(int i = 0;i<roll.length;i++){
			for(int j=0;j< roll[i];j++){
				inputCharArr[j] = roll_character(inputCharArr[j],1);
			}
		}
		return String.valueOf(inputCharArr);
	
		
		
		  
		  
	  }
	public static void main(String[] args) {
		  String s = "bca"; 
		  int roll[] = {1, 2, 3}; 
	        //System.out.println(rollTheString(s, roll));
		  System.out.println(rollTheString(s, roll));
	}

}
