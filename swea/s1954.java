package test.day4;

import java.util.Arrays;
import java.util.Scanner;

public class s1954 {
	static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		int[][] map;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			map = new int[n][n];
			int num = 0;
			int i = 0;
			int j = 0;
			for (int run = 0; run < n-1; run++) {
				num++;
				map[i][j] = num;
				j += direction[0][0];

			}
			System.out.println(Arrays.deepToString(map));
			for (int a = 1; a < n; a++) {
				for (int run = a; run < n; run++) {
					
					num++;
					map[i][j] = num;
					i += direction[(2*a-1) % 4][1];
					

				}
				System.out.println(Arrays.deepToString(map));
				for (int run = a; run < n; run++) {					
					num++;
					map[i][j] = num;
					j += direction[(2*a)%4][0];					

				}
				System.out.println(Arrays.deepToString(map));
			}
			System.out.println("#" + tc);
			for (int nr = 0; nr < n; nr++) {
				for (int nc = 0; nc < n; nc++) {

					System.out.printf("%d ", map[nr][nc]);

				}
				System.out.println();
			}

		}
	}

}
