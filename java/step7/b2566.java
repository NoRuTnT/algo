package practice;

import java.util.Scanner;

public class b2566 {
	public static void main(String[] args) {
		int max = 0;
		int[] maxloc = new int[2];
		int[][] map = new int[9][9];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > max) {
					max = map[i][j];
					maxloc[0] = i;
					maxloc[1] = j;
				}
			}
		}
		System.out.println(max);
		System.out.println((maxloc[0] + 1) + " " + (maxloc[1] + 1));
	}

}
