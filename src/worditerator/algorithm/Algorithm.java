package worditerator.algorithm;

public class Algorithm {

	public static String[] iterate(String word) {

		WordsContainer wc = new WordsContainer(word);
		
		iter(wc, "", word.toLowerCase());

		return wc.toStringArray();

	}

	private static void iter(WordsContainer wc, String word, String free) {
		if (free.isEmpty()) {
			wc.add(word);
			return;
		}

		for (int i = 0; i < free.length(); i++) {
			iter(wc, word + free.charAt(i), free.substring(0, i) + free.substring(i + 1));
		}
	}

	private static class WordsContainer {

		private int counter = 0;

		private String[] words;

		private WordsContainer(String word) {
			words = new String[factorial(word.length())];
		}

		private void add(String word) {
			words[counter++] = word;
		}

		private String[] toStringArray() {
			return words.clone();
		}

		private static int factorial(int n) {
			if (n <= 1)
				return 1;
			return n * factorial(n - 1);
		}

	}

}
