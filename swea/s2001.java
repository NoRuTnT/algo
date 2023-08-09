package test;

import java.util.Scanner;

public class s2001 {
	static int sum;
	static int[][] map;
	static int n;
	static int m;
	static int max_sum;
	public static int fly_catch(int x, int y) {
		sum=0;		
		int nx = x;
		int ny = y;
		for(int i=0;i<m;i++) {
			for(int j=0;j<m;j++) {
				if(!(nx+i < 0 || ny+j < 0 || nx+i >= n || ny+j >= n)) {
					sum += map[nx+i][ny+j];					
				}
			}
		}		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc < t + 1; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][n];
			// 지도만들기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			max_sum=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum=fly_catch(i,j);
					if(sum>max_sum) {
						max_sum = sum;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,max_sum);

		}

	}
}