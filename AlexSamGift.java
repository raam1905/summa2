package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlexSamGift {

	public static int getSubsequenceCount(String alexString,String samString){/*
		int alexIndex = 0;
		int samIndex = 0;
		int prevCharPos=-1;
		int validFlag= 0;
		do{
			validFlag=1;
			
			for(int i=0;i<samString.length();i++){
				
				int curCharPos=alexString.indexOf(samString.charAt(i));
				if(curCharPos>prevCharPos){
					prevCharPos=curCharPos;
				}
				else{
					validFlag = 0;
					break;
				}
			}
			if(validFlag==1)
			
				break;
		}while(1);*/
		
		int pos1=alexString.indexOf(samString.charAt(0));
		int pos2=alexString.indexOf(samString.charAt(1));
		int pos3=alexString.indexOf(samString.charAt(2));
		List<String> result = new ArrayList<>();
		while(pos1<alexString.length()){
			
			while(pos2<alexString.length()){
				while(pos3<alexString.length()){
					result.add( (pos1+1)+","+(pos2+1)+","+(pos3+1));
					int nextPos= alexString.substring(pos3+1).indexOf(samString.charAt(2));
					if(nextPos>=0){
						pos3=pos3+nextPos+1;
					}
					else{
						break;
					}
				}
				int nextPos= alexString.substring(pos2+1).indexOf(samString.charAt(1));
				if(nextPos>=0){
					pos2=pos2+nextPos+1;
				}
				else
					break;
			}
			int nextPos= alexString.substring(pos1+1).indexOf(samString.charAt(0));
			if(nextPos>=0){
				pos1=pos1+nextPos+1;
			}
			else
				break;
		}
		System.out.println(result);
		return result.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	System.out.println(getSubsequenceCount("HERHRWS","HRW"));
		System.out.println(getSubsequenceCount("HELLOWORLD","ELO"));

	}

}
