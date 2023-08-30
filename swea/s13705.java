package swea;

import java.util.Scanner;

public class s13705 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); //배열크기
			int[][] map = new int[n][n];
			int m = sc.nextInt(); //파동시작값
			int r = sc.nextInt()-1; 
			int c = sc.nextInt()-1;
			int d = sc.nextInt(); //증감
			
			
			for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                int dm = m + d *(Math.max(Math.abs(i - r), Math.abs(j - c)));
	                if (dm > 255) {
	                    dm = 255;
	                } else if (dm < 0) {
	                    dm = 0;
	                }
	                map[i][j] = dm;	                
	            }
	        }	
			
			int sum = 0;
			System.out.print("#" + tc + " ");
			for (int i = 0; i < n; i++) {
				sum = 0;
				for (int j = 0; j < n; j++) {					
					sum += map[i][j];
				}
				System.out.print(sum + " ");

			}
			System.out.println();

		}
	}
}
