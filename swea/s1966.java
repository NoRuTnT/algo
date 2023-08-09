package test;

import java.util.Arrays;
import java.util.Scanner;

public class s1966 {
	static int[] arr;
	public static void main(String[] args) {
		int max;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc < t + 1; tc++) {
			int n = sc.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {				
				arr[i] = sc.nextInt();
			}
			max = 0;
			for (int i = 0; i < n - 1; i++) {
				int minIdx = i;
				for (int j = i + 1; j < n; j++) {
					if (arr[j] < arr[minIdx]) {
						minIdx = j;
					}
				}
				int tmp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;
			}
			System.out.print("#" + tc + " ");
			for (int e : arr) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

}
