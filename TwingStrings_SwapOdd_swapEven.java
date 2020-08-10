package smallPrograms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Result {

    /*
     * Complete the 'twins' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static List<String> twins(List<String> a, List<String> b) {
    // Write your code here
        List<String> result = new ArrayList<String>();
        for(int i=0;i<a.size();i++){
            String s1= a.get(i);
            String s2= b.get(i);

            if(s1.length()!= s2.length())
                result.add("No");
            else if (s1.length() ==1 && s2.length()==1){
                if(s1.equals(s2))
                    result.add("Yes");
                else   
                    result.add("No");
            }
            else{
                List<Character> oddPosCharacters1= new ArrayList<>();
                List<Character> evenPosCharacters1= new ArrayList<>();

                List<Character> oddPosCharacters2= new ArrayList<>();
                List<Character> evenPosCharacters2= new ArrayList<>();
                for(int j=0;j<s1.length();j++){
                    if(j%2==1){
                        evenPosCharacters1.add(s1.charAt(j));
                        evenPosCharacters2.add(s2.charAt(j));
                    }
                    else{
                        oddPosCharacters1.add(s1.charAt(j));
                        oddPosCharacters2.add(s2.charAt(j));
                    }
                }
                Collections.sort(oddPosCharacters1);
                Collections.sort(oddPosCharacters2);
                Collections.sort(evenPosCharacters1);
                Collections.sort(evenPosCharacters2);
     
                String sub1 = oddPosCharacters1.stream().map((e)-> {return ""+e;}).reduce((c1,c2)->c1+c2).get();
                String sub2 = oddPosCharacters2.stream().map((e)-> {return ""+e;}).reduce((c1,c2)->c1+c2).get();
                if (!sub1.equals(sub2)){
                    result.add("No");
                }
                else{
                    sub1 = evenPosCharacters1.stream().map((e)-> {return ""+e;}).reduce((c1,c2)->c1+c2).get();
                    sub2 = evenPosCharacters2.stream().map((e)-> {return ""+e;}).reduce((c1,c2)->c1+c2).get();
                     if (!sub1.equals(sub2)){
                            result.add("No");
                     }
                     else{
                         result.add("Yes");
                     }

                }

            }
               
        }
              
          
        
        return result;
    }

}


public class TwingStrings_SwapOdd_swapEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
