package practice;
import java.util.Scanner;

public class SpiderWeb {

	static int n;
	static int[][] map;
	static int maxWeb;
	static int[] bestStart = new int[2];
	static int count;

	static void drawSpiderWeb(int x, int y) {
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		for (int[] dir : directions) {
			int nx = x;
			int ny = y;
			int wall = 0;

			while (true) {
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || wall == 2)
					break;

				if (map[nx][ny] == 0) {
					count++;
					wall = 0;
				} else if (map[nx][ny] == 1) {
					wall++;
				}

				nx += dir[0];
				ny += dir[1];
			}					
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		maxWeb = 0;

		for (int r = 0; r < n; r++) {

			for (int c = 0; c < n; c++) {
				count=0;
				drawSpiderWeb(r, c); // 8방향으로 거미줄 그리기
				count -= 7;
				if (count > maxWeb) {
					maxWeb = count;
					bestStart[0] = r;
					bestStart[1] = c;
				}
			}
		}

		System.out.println(maxWeb);
		System.out.println(bestStart[0] + "," +bestStart[1]);

	}
}

