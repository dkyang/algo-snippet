// brute-force substring search

public class BruteForce {
	public static int searchBackup(String pat, String txt) {
		int N = txt.length();
		int M = pat.length();
		for (int i = 0; i <= N-M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (txt.charAt(i+j) != pat.charAt(j))
					break;
			}  
			if (j == M)
				return i;
		}

		return -1;
	}


	public static int search(String pat, String txt) {
		int N = txt.length();
		int M = pat.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++, j++) {
			if (pat.charAt(j) != txt.charAt(i)) {
				i -= j;
				j = -1;
			}
		}

		if (j == M)
			return i - j;

		return -1;
	}

	public static void main(String[] args) {
		String txt = "abcedaewrsadf";
		String pat = "aewr";
		int pos = BruteForce.search(pat, txt);
		System.out.println(pos);
	}
}
