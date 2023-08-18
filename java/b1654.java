package test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1654 {
	static int[] arr2;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static long sum;
	static long result;
	static long max;

	private static long binarySearch(int m, int[] arr2) {
		long leftIndex = 0;
		max=0;
		for(int e:arr2) {
			max = Math.max(e, max);
		}
		long rightIndex = max;

		while (leftIndex <= rightIndex) {
			long midIndex = leftIndex + (rightIndex - leftIndex) / 2;
			sum = 0;
			for (int i = 0; i < n; i++) {
				int length = arr2[i];				
				if (midIndex != 0) {
				    sum += length / midIndex;
				}else {
					sum += length;
				}
			}
			if (sum < m) {
				rightIndex = midIndex - 1;
			} else {
				result = midIndex;
				leftIndex = midIndex + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
//		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr2 = new int [n];
		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(br.readLine());
		}
		long min = binarySearch(m, arr2);
		bw.write(min + "");
		bw.flush();
		br.close();
		bw.close();
	}

}
