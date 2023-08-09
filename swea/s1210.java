package test;

import java.util.Scanner;

public class s1210 {
	static int[][] map = new int[102][102];
	static int[] loc = new int[2];

	public static void move_ladder() {
		//오른쪽으로
		if (map[loc[0]][loc[1] + 1] == 1) {
			while (map[loc[0]][loc[1] + 1] != 0) {
				loc[1]++;
			}
		//왼쪽으로
		} else if (map[loc[0]][loc[1]-1] == 1) {
			while (map[loc[0]][loc[1]-1] != 0) {
				loc[1]--;
			}
		}
		//위로올라가기
		if (map[loc[0]][loc[1]] == 1) {
			loc[0]--;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스
		for (int tc = 1; tc <= 10; tc++) {
			//100x100지도 주변에 0으로된 한줄추가
			map = new int[102][102];
			loc = new int[2];
			// 지도그리기
			int n = sc.nextInt();
			for (int i = 1; i < 101; i++) {
				for (int j = 1; j < 101; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//시작위치찾기
			for (int i = 1; i < 101; i++) {
				if (map[100][i] == 2) {
					loc[0] = 99;
					loc[1] = i;					
				}
			}
			//사다리타기
			while (loc[0] != 1) {				
				move_ladder();				
			}
			//x값찾기
			int result = loc[1] - 1;
			System.out.printf("#%d %d\n",n,result);
		}
	}
}
