package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class KnightMoves {

	// static Map<Integer, Map<Integer, Map<Integer,String>>> knightMoves = new
	// HashMap<>();
	static Map<Integer, Map<Integer, Integer>> knightMoves = new HashMap<>();

	static List<Integer> xPos = Arrays.asList(1,  1, -1, -1, 2,  2, -2, -2);
	static List<Integer> yPos = Arrays.asList(2, -2,  2, -1, 1, -1,  1, -1);

	public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {

		for (int i = 0; i < xPos.size(); i++) {
			
			int nextX = startRow + xPos.get(i);
			int nextY = startCol + yPos.get(i);
			
			
			if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
				System.out.println( "start " +startRow + " end " + startCol + " next " + nextX+ " nextc " +nextY );
				if (!knightMoves.containsKey(nextX))
					knightMoves.put(nextX, new HashMap<>());

				if (!knightMoves.get(nextX).containsKey(nextY))
					knightMoves.get(nextX).put(nextY, 0);
				
				if (!knightMoves.containsKey(startRow))
					knightMoves.put(startRow, new HashMap<>());

				if (!knightMoves.get(startRow).containsKey(startCol))
					knightMoves.get(startRow).put(startCol, 0);

				Integer currentNodeData = knightMoves.get(startRow).get(startCol);
				Integer nextNodeData = knightMoves.get(nextX).get(nextY);
				if (currentNodeData == null) {
					currentNodeData = 0;
					knightMoves.get(startRow).put(startCol, 0);
				}
			/*	if (nextNodeData == null) {
					nextNodeData = 0;
					knightMoves.get(nextX).put(nextY, 0);
				}*/

				if (nextNodeData == 0 || nextNodeData > currentNodeData + 1)
					knightMoves.get(nextX).put(nextY, currentNodeData + 1);
				if(nextX<= endRow)
					minMoves(n, nextX, nextY, endRow, endCol);
			} else {
				continue;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*minMoves(10, 0, 0, 0, 2);*/
		//minMoves(6, 5, 1, 0, 5);
		minMoves(6, 0, 5, 5, 1);
		System.out.println(knightMoves);
	}

}
