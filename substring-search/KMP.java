// Knuth-Morris-Pratt substring search algorithm
// using concept of determinstic finite automaton
public class KMP {
	private final int R = 256; // extended ASCII
	private int M;
	private int[][] dfa;
	public KMP(String pat) {
		M = pat.length();
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for (int j = 1, x = 0; j < M; j++) {
			// miss-match
			for (int r = 0; r < R; r++)
				dfa[r][j] = dfa[r][x];
			// match
			dfa[pat.charAt(j)][j] = j+1;
			// update x
			x = dfa[pat.charAt(j)][x];
		}
	}

	public int search(String txt) {
		int N = txt.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			j = dfa[txt.charAt(i)][j];
		}

		if (j == M)
			return i - M;
		else
			return -1;
	}

	public static void main(String[] args) {
		String txt = "abcedaewrsadf";
                String pat = "aewr";
		KMP kmp = new KMP(pat);
                int pos = kmp.search(txt);
                System.out.println(pos);
	}
}
