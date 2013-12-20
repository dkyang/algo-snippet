// MSD radix sort

public class MSD {
	private static final int R = 256; // extended ASCII
	private static final int CUTOFF = 2; 

	public static void sort(String[] a) {
		int N = a.length;
		String[] aux = new String[N];
		sort(a, 0, N-1, 0, aux);
	}

	private static void sort(String[] a, int lo, int hi, int d, String[] aux) {
	//	if (lo + CUTOFF <= hi) {
	//		insertSort(a, lo, hi);
	//		return;
	//	}

		if (lo >= hi)
			return;

		int[] count = new int[R + 2];
		for (int i = lo; i <= hi; i++) {
			count[charAt(a[i], d) + 2]++;
		}

		for (int r = 0; r < R+1; r++)
			count[r+1] += count[r];

		for (int i = lo; i <= hi; i++) {
			aux[count[charAt(a[i], d)+1]++] = a[i];
		}

		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];

		for (int r = 0; r < R; r++)
			sort(a, lo+count[r], lo+count[r+1]-1, d+1, aux);
	}

	private static int charAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else 
			return -1;
	} 

	public static void main(String[] args) {
		String[] a = new String[6];
		a[0] = "wersdf";
		a[1] = "a";
		a[2] = "b";
		a[3] = "cd";
		a[4] = "wercd";
		a[5] = "er";
		MSD.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		
	}
}
