package swea;

import java.util.Scanner;

public class AppleTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		
		for (int i=0; i<n ; i++ ) {
			for ( int j=0 ; j<n ; j++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dr1 = { -1,1,0,0 };
		int[] dc1 = { 0,0,-1,1 };
		int maxnutrient = 0;
		for (int i=0; i<n ; i++) {
			for(int j=0; j<n ; j++) {
				int nutrient = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr1[k];
					int nc = j + dc1[k];
					if (nr>=0 && nc>=0 && nr<5 && nc<5) {
						nutrient = Math.addExact(nutrient, map[nr][nc]);
					}					
				}
				nutrient = Math.addExact(nutrient, map[i][j]);
				maxnutrient = Math.max(nutrient, maxnutrient);			
				
				
			}
		}
		System.out.println(maxnutrient);
		
	}

}

