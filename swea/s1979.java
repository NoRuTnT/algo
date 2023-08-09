package test;

import java.util.Arrays;
import java.util.Scanner;

public class s1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] map;
		int[] loc;
		int result;

		for (int tc = 1; tc < t + 1; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			map = new int[n][n];
			loc = new int[2];
			result = 0;
			// 지도만들기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 가로퍼즐
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
                        cnt++;
                    } else {
                        cnt = 0;
                    }
                    if (cnt == k && (j == n - 1 || map[i][j + 1] == 0)) {
                        result++;
                    }
				}
			}
			// 세로퍼즐
			for (int j = 0; j < n; j++) {
				int cnt=0;
				for (int i = 0; i < n; i++) {
					if (map[i][j] == 1) {
                        cnt++;
                    } else {
                        cnt = 0;
                    }
                    if (cnt == k && (i == n - 1 || map[i + 1][j] == 0)) {
                        result++;
                    }
				}
			}
			System.out.printf("#%d %d\n", tc, result);
		}

	}

}
