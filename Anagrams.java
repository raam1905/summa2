package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagrams {
	
	static Map<String, Map<Character, Integer>> charOccurrencesCache = new HashMap<>();

	public static List<String> funWithAnagrams(List<String> input) {
		List<String> result = new ArrayList<>();
		int flag = 0;
		Set<String> uniqueInputStrings = new LinkedHashSet<>(input); // Using Set to avoid duplicates if any to avoid extra processing time

		for (String s1 : uniqueInputStrings) {
			if (result.size() == 0)
				result.add(s1);
			else {
				for (String resultStr : result) {
					flag = 0;
					if (isAnagram(s1, resultStr)) {
						flag = 1;
						break;
					}
				}

				if (flag == 0)
					result.add(s1);
			}

		}
		Collections.sort(result);
		return result;

	}

	public static boolean isAnagram(String s1, String s2) {

		Map<Character, Integer> charOccurrences1 = new HashMap<>();
		Map<Character, Integer> charOccurrences2 = new HashMap<>();
		if (s1.length() != s2.length()) {
			return false;
		} else {

			if (charOccurrencesCache.containsKey(s1)) {
				charOccurrences1 = charOccurrencesCache.get(s1);
			}
			if (charOccurrencesCache.containsKey(s2)) {
				charOccurrences2 = charOccurrencesCache.get(s2);
			}

			if (charOccurrences1.isEmpty() && charOccurrences2.isEmpty()) { // both inputs are not in character count cache
				for (int i = 0; i < s1.length(); i++) {
					Character currentLetter1 = s1.charAt(i);
					Character currentLetter2 = s2.charAt(i);

					if (charOccurrences1.get(currentLetter1) == null)
						charOccurrences1.put(currentLetter1, 1);
					else
						charOccurrences1.put(currentLetter1, charOccurrences1.get(currentLetter1) + 1);

					if (charOccurrences2.get(currentLetter2) == null)
						charOccurrences2.put(currentLetter2, 1);
					else
						charOccurrences2.put(currentLetter2, charOccurrences2.get(currentLetter2) + 1);

				}
				charOccurrencesCache.put(s1, charOccurrences1);
				charOccurrencesCache.put(s2, charOccurrences2);
			}

			else if (charOccurrences1.isEmpty()) { // first input alone not in character count cache
				for (int i = 0; i < s1.length(); i++) {
					Character currentLetter1 = s1.charAt(i);

					if (charOccurrences1.get(currentLetter1) == null)
						charOccurrences1.put(currentLetter1, 1);
					else
						charOccurrences1.put(currentLetter1, charOccurrences1.get(currentLetter1) + 1);

				}
				charOccurrencesCache.put(s1, charOccurrences1);
			} else if (charOccurrences2.isEmpty()) {  // second input alone not in character count cache
				for (int i = 0; i < s1.length(); i++) {

					Character currentLetter2 = s2.charAt(i);

					if (charOccurrences2.isEmpty()) {
						if (charOccurrences2.get(currentLetter2) == null)
							charOccurrences2.put(currentLetter2, 1);
						else
							charOccurrences2.put(currentLetter2, charOccurrences2.get(currentLetter2) + 1);
					}
				}
				charOccurrencesCache.put(s2, charOccurrences2);
			}
		}

		Set<Character> keys1 = charOccurrences1.keySet();
		Set<Character> keys2 = charOccurrences2.keySet();

		if (keys1.size() != keys2.size())
			return false;
		else {
			for (Character c : keys1) {
				if (charOccurrences1.get(c) != charOccurrences2.get(c))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str[] = { "code", "aaagmnrs", "anagrams", "doce" };
		// String str[] = {"poke","pkoe","okpe","ekop"};
		 List<String> input = Arrays.asList(str);
		 System.out.println(funWithAnagrams(input));
	}



}
