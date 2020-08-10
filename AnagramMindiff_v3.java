package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramMindiff_v3 {

	public static List<Integer> getMinimumDifference(String[] input1, String[] input2) {
		List<Integer> minDiffList = new ArrayList<>();
		int value = 0;

		for (int i = 0; i < input1.length; i++) {
			if (input1[i].length() != input2[i].length()) {
				value = -1;
			} else {
				value = 0;
				Map<Character, Integer> charOccurrences1 = new HashMap<>();
				Map<Character, Integer> charOccurrences2 = new HashMap<>();

				for (int j = 0; j < input1[i].length(); j++) {
					Character currentLetter1 = input1[i].charAt(j);
					Character currentLetter2 = input2[i].charAt(j);

					if (charOccurrences1.get(currentLetter1) == null)
						charOccurrences1.put(currentLetter1, 1);
					else
						charOccurrences1.put(currentLetter1, charOccurrences1.get(currentLetter1) + 1);

					if (charOccurrences2.get(currentLetter2) == null)
						charOccurrences2.put(currentLetter2, 1);
					else
						charOccurrences2.put(currentLetter2, charOccurrences2.get(currentLetter2) + 1);
				}

				Set<Character> keys1 = charOccurrences1.keySet();
				Set<Character> keys2 = charOccurrences2.keySet();

				for (Character c : keys1) {
					int charCount1 = charOccurrences1.get(c) == null ? 0 : charOccurrences1.get(c);
					int charCount2 = charOccurrences2.get(c) == null ? 0 : charOccurrences2.get(c);
					if (charCount1 != charCount2) {
						value = value + Math.abs(charCount1 - charCount2);
					}

				}

			}
			minDiffList.add(value);
		}

		return minDiffList;
	}

	public static void main(String[] args) {

		// String s1[] = { "tea", "tea", "act" };
		// String s2[] = {"ate","toe","acts"};
		// String s1[] = { "a", "jk", "abb", "mn","abc" };
		// String s2[] = {"bb","kj","bbc","op","def"};
		// String s1[] = {"apple" };
		// String s2[] = {"abcde" };
		String s1[] = { "aacde" };
		String s2[] = { "bacde" };
		System.out.println(getMinimumDifference(s1, s2));
	}
}
