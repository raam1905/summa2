package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SumaInnoruclass {

	public static void task2() {

		List<List<Integer>> input = new ArrayList<>();
		List<Integer> t = new ArrayList<>();
		t.add(1);
		t.add(2);
		t.add(3);
		t.add(4);
		input.add(t);

		t = new ArrayList<>();
		t.add(0);
		t.add(2);
		t.add(7);
		input.add(t);

		t = new ArrayList<>();
		t.add(4);
		t.add(12);
		input.add(t);

		t = new ArrayList<>();
		t.add(1);
		t.add(2);
		t.add(5);
		t.add(6);
		input.add(t);

		List<Integer> result = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		for (List<Integer> l : input) {
			if (min > l.size()) {
				min = l.size();
				result = l;
			}
		}

		System.out.println(result);

	}

	public static void task1() {

		String input = "aabccd";

		Map<Character, Integer> occurrenceMap = new HashMap<Character, Integer>();
		input.chars().forEach((e) -> {
			char key = (char) e;
			if (occurrenceMap.containsKey(key)) {

				occurrenceMap.put(key, occurrenceMap.get(key) + 1);
			} else {
				occurrenceMap.put(key, 1);
			}

		});

		System.out.println(occurrenceMap);

	}

	public static void task2_aug4() {
		Integer arr1[] =  new Integer[]{ 1, 3, 4, 5 };
		Integer arr2[] =  new Integer[]{ 2, 4, 6, 8 };

		
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));
		list1.addAll(list2);
		System.out.println(list1);
		queue.addAll(list1);
		
		
		System.out.println(queue); 
		/*List<Integer> result = new ArrayList<>();
		int arr1_Index = 0, arr2_Index = 0;

		
		while(arr1_Index != arr1.length && arr2_Index != arr2.length){

			if (arr1[arr1_Index] < arr2[arr2_Index]) {
				result.add(arr1[arr1_Index]);
				arr1_Index++;
			} else if (arr1[arr1_Index] > arr2[arr2_Index]) {
				result.add(arr2[arr2_Index]);
				arr2_Index++;
			} else if (arr1[arr1_Index] == arr2[arr2_Index]) {
				result.add(arr1[arr1_Index]);
				result.add(arr2[arr2_Index]);
				arr1_Index++;
				arr2_Index++;
			}

		}
		
		if (arr1_Index == arr1.length && arr2_Index < arr2.length) {
			for(int i=arr2_Index;i<arr2.length;i++){
				result.add(arr2[i]);
				
			}
		}

		else if (arr2_Index == arr2.length && arr1_Index < arr1.length) {
			for(int i=arr1_Index;i<arr1.length;i++){
				result.add(arr1[i]);
				
			}
		}
		*/
		System.out.println(queue);
		//System.out.println(result);
	}

	public static void task1_aug4() {
		Integer[] arr1 = new Integer[]{ 1, 2, 3, 4, 5 };
		Integer[] arr2 = new Integer[]{ 1, 2, 5, 7, 9 };
		Integer[] arr3 = new Integer[]{ 1, 3, 4, 5, 8 };
		List<Integer> l1 = Arrays.asList(arr1);
		List<Integer> l2 = Arrays.asList(arr2);
		List<Integer> l3 = Arrays.asList(arr3);
		
		List<Integer> result = new ArrayList<>();
		
		
		for(int i=0;i<l1.size();i++){
			if(l2.contains(l1.get(i)) && l3.contains(l1.get(i))){
				result.add(l1.get(i));
			}
		}
		System.out.println(result);
			
	}
	
	public static void task3_aug4(){
		 String input[] = new String[]{"Ajay", "Raja", "Keshav", "List", "Set", "Elephant", "Drone"/*,"Zebra","ball"*/};
		
		 String sortOrder=  "TESARDLK";
		 
		 
		 Comparator<String> customComparator = (input1, input2)->{
			String s1= input1.toUpperCase();
			String s2= input2.toUpperCase();
			
			int minStringLength = (s1.length()<s2.length())? s1.length(): s2.length();
			for(int i=0;i<minStringLength;i++){
				if(s1.charAt(i)== s2.charAt(i))
					continue;
				else{
					int orderValue1= sortOrder.indexOf(s1.charAt(i))>=0 ? sortOrder.indexOf(s1.charAt(i)): s1.charAt(i);
					int orderValue2= sortOrder.indexOf(s2.charAt(i))>=0 ? sortOrder.indexOf(s2.charAt(i)): s2.charAt(i);
					
					return orderValue1 - orderValue2;
				}
			}
			return 0;
		 };
		 Arrays.sort(input, customComparator);
		 System.out.println(Arrays.asList(input));
		 
	}
	public static void task3_aug5(){
		
		
		
		
	}

	public static void main(String[] args) {
    	
    	//task2();
		//task1_aug4();
    	task2_aug4();
		//task3_aug4();
   }

}