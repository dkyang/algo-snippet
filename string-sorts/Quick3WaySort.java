public class Quick3WaySort {
	public static void sort(String[] a) {
		sort(a, 0, a.length-1, 0);
	}

	private static void sort(String[] a, int lo, int hi, int d) {
		if (lo >= hi)
			return;
	
		int i = lo + 1;
		int lt = lo;
		int gt = hi;
		int v = charAt(a[lo], d);
		while (i <= gt) {
			int t = charAt(a[i], d); 
			if (v > t) exch(a, i++, lt++);
			else if (v < t) exch(a, i, gt--);
			else i++;
		}

		sort(a, i, lt-1, d);
		if (v >= 0) sort(a, lt, gt, d+1);
		sort(a, gt+1, hi, d);
	}

	private static int charAt(String a, int d) {
		if (d < a.length()) return a.charAt(d);
		else return -1;
	}

	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}

	public static void main(String[] args) {
		String[] a = new String[6];
                a[0] = "wersdf";
                a[1] = "a";
                a[2] = "b";
                a[3] = "cd";
                a[4] = "wercd";
                a[5] = "er";
		Quick3WaySort.sort(a);
		for (int i = 0; i < a.length; i++)	
			System.out.println(a[i]);
	}
}
