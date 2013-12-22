// using boyer-moore substring search algorithm

public class BoyerMoore {
	private int R = 256; // number of characters
	private int M; // length of pattern
	private String pat;
	private int[] right;
	public BoyerMoore(String pat) {
		this.pat = pat;
		M = pat.length();
		right = new int[R];
		for (int i = 0; i < R; i++) 
			right[i] = -1;
		for (int i = 0; i < M; i++)
			right[pat.charAt(i)] = i;
	}

	public int search(String txt) {
		int N = txt.length();
		int skip = 0;
		for (int i = 0; i <= N-M; i += skip) {
			skip = 0;
			for (int j = M-1; j >= 0; j--) {
				if (pat.charAt(j) != txt.charAt(i+j))
					skip = Math.max(1, j-right[txt.charAt(i+j)]);
			}

			if (skip == 0)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		String txt = "abcedaewrsadf";
		String pat = "aewr";
		BoyerMoore bm = new BoyerMoore(pat);
		int pos = bm.search(txt);
		System.out.println(pos);
	}
	
}
