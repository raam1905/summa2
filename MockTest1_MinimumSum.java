package hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MockTest1_MinimumSum {
	
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(10);
		list.add(4);
		
		list.add(10);
		list.add(20);
		list.add(7);
		
		int k = 4;
		
		System.out.println(minSum(list,k));
	}
	
	public static int minSum(List<Integer> num, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		queue.addAll(num);
		for(int i=0;i<k ; i++){
			queue.add((int)Math.ceil(queue.poll()/2.0));

		}
		return queue.stream().mapToInt(n->n).sum();
	}
}
