import java.util.*;

class Solution
{
	public List<String> letterCasePermutation(String S)
	{
		final List<String> result = new ArrayList<>();
		_findPermutations(S.toCharArray(), 0, result, Arrays.asList(""));
		return result;
	}

	private void _findPermutations(char[] chars, int i, List<String> result, List<String> partialResult)
	{
		if (i == chars.length)
		{
			result.addAll(partialResult);
			return;
		}

		final char chr = chars[i];
		final Set<Character> permutations = new HashSet<>();

		if (Character.isAlphabetic(chr))
		{
			permutations.add(Character.toUpperCase(chr));
			permutations.add(Character.toLowerCase(chr));
		}
		else
		{
			permutations.add(chr);
		}

		final ArrayList<String> newPartialResult = new ArrayList<>();
		permutations.forEach(c -> partialResult.forEach(s -> newPartialResult.add(s + c)));

		_findPermutations(chars, i + 1, result, newPartialResult);
	}
}