package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlexSamGift2 {

	public static int getSubsequenceCount(String alexString,String samString){
		
		int pos1=-1;
		int pos2=-1;
		int pos3=-1;
		List<String> result = new ArrayList<>();
		while(pos1<alexString.length()){
			int nextPos= alexString.substring(pos1+1).indexOf(samString.charAt(0));
			if(nextPos>=0){
				pos1=pos1+nextPos+1;
				pos2=pos1; // reset index2 pointer 
			}
			else
				break;
			while(pos2<alexString.length()){
				int nextPos2= alexString.substring(pos2+1).indexOf(samString.charAt(1));
				if(nextPos2>=0){
					pos2=pos2+nextPos2+1;
					pos3=pos2; // reset index3 pointer
				}
				else
					break;
				while(pos3<alexString.length()){
					
					int nextPos3= alexString.substring(pos3+1).indexOf(samString.charAt(2));
					if(nextPos3>=0){
						pos3=pos3+nextPos3+1;
						result.add( (pos1+1)+","+(pos2+1)+","+(pos3+1));
						
					}
					else{
						break;
					}
				}
				
			}

		}
		System.out.println(result);
		return result.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getSubsequenceCount("HERHRWS","HRW"));
	//	System.out.println(getSubsequenceCount("HELLOWORLD","ELO"));

	}

}
