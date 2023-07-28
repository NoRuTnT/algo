import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b15686 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] chicken_map;
	static int sum;
	static int store;
	static int distance;
	static int min_distance;
	static List<Integer> sum_distance = new ArrayList<>();
	static List<Integer> save = new ArrayList<>();

	static void drawchicken(int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					distance = Math.abs(x - i) + Math.abs(y - j);
					sum += distance;
				}
			}
		}
	}

	static void drawchicken1(int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					distance = Math.abs(x - i) + Math.abs(y - j);
					sum += distance;
				}

				if (distance < chicken_map[i][j]) {
					chicken_map[i][j] = distance;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		chicken_map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chicken_map[i][j] = 100;
			}
		}

		min_distance = 0;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == 2) {
					sum = 0;
					store += 1;
					drawchicken(r, c);
					sum_distance.add(sum);
					save.add(r);
					save.add(c);
					if (store > m) {
						int a = sum_distance.indexOf(Collections.max(sum_distance));
						map[save.get(2 * a)][save.get(2 * a + 1)] = 0;
						sum_distance.remove(a);
						save.remove(2 * a);
						save.remove(2 * a);
					}
				}

			}
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.println(map[r][c]);				
				
			}
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == 2) {
					sum = 0;
					drawchicken1(r, c);
				}
			}
		}
		System.out.println(chicken_map);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (chicken_map[r][c] != 100) {
					min_distance += chicken_map[r][c];
				}
			}
		}
		System.out.println(min_distance);

	}

}
