public class KeyIndexSorting {
	public String sort(String str) {
		int len = str.length();
		int[] count = new int[256];
		for (int i = 0; i < 256; i++) 
			count[i] = 0;
		for (int i = 0; i < len; i++) {
			count[str.charAt(i) - 'a' + 1]++;
		}
		for (int i = 0; i < 256 - 1; i++) {
			count[i+1] += count[i];
		}
		char[] res = new char[len];
		for (int i = 0; i < len; i++)
			res[count[str.charAt(i) - 'a']++] = str.charAt(i); 

		return new String(res);
	}

	public static void main(String[] args) {
		String str = "bbaedrsdfaaaee";
		KeyIndexSorting keySort = new KeyIndexSorting();
		System.out.println("original string is :" + str);
		System.out.println("sorted string is :" + keySort.sort(str));
	}
}
