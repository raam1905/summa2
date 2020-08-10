package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottery {

	// static Map<Integer, Map<Integer, Map<Integer,String>>> knightMoves = new
	// HashMap<>();
	
	public static int lottery(int n) {
		Map<Integer, Integer> lotteryNumbersPartition = new HashMap<>();
		lotteryNumbersPartition.put(-1, 1); // using -1 as position variable to use inside lambda expression
		lotteryNumbersPartition.put(-2, 1); // using -2 as position for storing maxValue
		List<Integer> l = Stream.iterate(1, (i) -> {
			int partition = lotteryNumbersPartition.get(-1);
			if (i < 10) {
				lotteryNumbersPartition.put(partition, 1);
			} else {
				lotteryNumbersPartition.put(partition, lotteryNumbersPartition.get(partition)+1);
				int maxCount =lotteryNumbersPartition.get(-2);
				if(maxCount<lotteryNumbersPartition.get(partition))
					lotteryNumbersPartition.put(-2,lotteryNumbersPartition.get(partition));
			}
			partition = (partition +1)%10;
			if(partition==0)
				partition++;
			lotteryNumbersPartition.put(-1, partition);
			return i + 1;
		}).limit(n+1).collect(Collectors.toList());
		
		
		
		int recentlyFilledPartitionCount = lotteryNumbersPartition.get(-1)==1?9:lotteryNumbersPartition.get(-1)-1;
		
		
	
	//	System.out.println(lotteryNumbersPartition);
		

		return recentlyFilledPartitionCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lottery(11));
	}

}
