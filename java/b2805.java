package test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class b2805 {
	static ArrayList<Integer> list = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static Long sum;
	static Long result;

	private static Long binarySearch(int m, ArrayList<Integer> list) {
		int leftIndex = 0;
		int rightIndex = Collections.max(list);

		while (leftIndex <= rightIndex) {

			int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
			sum = (long) 0;
			for (int i = 0; i < n; i++) {
				int length = list.get(i);
				if (length > midIndex) {
					sum += length - midIndex;
				}
			}
			if (sum < m) {
				rightIndex = midIndex - 1;
			} else {
				result = (long) midIndex;
				leftIndex = midIndex + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {

		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		String[] arr2 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(arr2[i]));
		}
		Long minhigh = binarySearch(m, list);
		bw.write(minhigh + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
