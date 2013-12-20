// LSD radix sort for fixed length strings


public class LSD {
	private final static int R = 256;
	
	public static void sort(String[] strings, int W) {
		int N = strings.length;	
		String[] aux = new String[N];
		
		for (int i = W-1; i >= 0; i--) {
			int[] count = new int[R+1];
			for (int k = 0; k < N; k++) {
				count[strings[k].charAt(i)+1]++;
			}

			for (int k = 1; k <= R; k++) 
				count[k] += count[k-1];

			for (int k = 0; k < N; k++) {
				aux[count[strings[k].charAt(i)]++] = strings[k];
			}
			
			for (int k = 0; k < N; k++)
				strings[k] = aux[k];
		}
	} 

	public static void main(String[] args) {
		String[] strings = new String[4];
		strings[0] = "aer";
		strings[1] = "cer";
		strings[2] = "aew";
		strings[3] = "cbd";

		LSD.sort(strings, 3);
		for (String s : strings)
			System.out.println(s);
	}
}
