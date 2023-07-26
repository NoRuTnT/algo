package practice;

import java.util.Scanner;

public class b2563 {

	static int n;
	static int count;
	static int[][] map = new int[100][100];

	static void draw(int x, int y) {
		int nx = x;
		int ny = y;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if ((nx + i) >= 0 || (nx + i) < 100 || (ny + j) >= 0 || (ny + j) < 100) {
					map[nx + i][ny + j] = 1;
				}
			}
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			draw(a, b);
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					count += 1;
				}
			}
		}
		System.out.println(count);
	}
}
