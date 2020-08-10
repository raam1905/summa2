package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

class CharactersCount {
	String name;
	int distinctCharacterCount;

	CharactersCount(String name, int distinctCharCount) {
		this.name = name;
		this.distinctCharacterCount = distinctCharCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistinctCharacterCount() {
		return distinctCharacterCount;
	}

	public void setDistinctCharacterCount(int distinctCharacterCount) {
		this.distinctCharacterCount = distinctCharacterCount;
	}
}

class Filter {
	Predicate<String> nameStartingWithPrefix(String prefix) {
		return (e) -> e.startsWith(prefix);

	}
}

class Mapper {
	Function<String, CharactersCount> getDistinctCharactersCount() {
		return (s) -> {
			Set<Character> charSet = new HashSet<>();
			for (Character c : s.toCharArray()) {
				charSet.add(c);
			}
			return new CharactersCount(s, charSet.size());
		};

	}
}

public class Distinct_chars_count {
	public static void main(String[] args) {
		String str[] = { "aaryanna", "aayanna", "airianna", "allessandra" };

		List<String> namelist = Arrays.asList(str);
		Filter filter = new Filter();
		Mapper mapper = new Mapper();

		namelist.stream().filter(filter.nameStartingWithPrefix("aa")).map(mapper.getDistinctCharactersCount())
				.forEach((e) -> {
					System.out.println(e.getName() + " has " + e.getDistinctCharacterCount() + " distinct characters");

				});

		
	}
}
