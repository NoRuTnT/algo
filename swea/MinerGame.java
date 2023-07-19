package practice;

import java.util.Scanner;

public class MinerGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int[] loc = new int[2];
		
		
		for (int i=0; i<n ; i++ ) {
			for ( int j=0 ; j<n ; j++ ) {
				map[i][j] = sc.nextInt();
				if (map[i][j]==0) {
					loc[0] = i;
					loc[1] = j;
				}
			}
		}
		
		int m = sc.nextInt();		
		
		
		for (int i=0;i<m;i++) {
			String order = sc.next();
			if (order.equals("U")) {
				if(loc[0]-1>=0) {
					if(map[loc[0]-1][loc[1]]==0) {
						loc[0] = loc[0]-1;
					}else {
						map[loc[0]-1][loc[1]] -= 1;
						if(map[loc[0]-1][loc[1]]==0) {
							loc[0] = loc[0]-1;
						}
					}
					
				}
			}else if(order.equals("D")){
				if(loc[0]+1<n) {
					if(map[loc[0]+1][loc[1]]==0) {
						loc[0] = loc[0]+1;
					}else {
						map[loc[0]+1][loc[1]] -= 1;
						if(map[loc[0]+1][loc[1]]==0) {
							loc[0] = loc[0]+1;
						}
					}
					
				}
			}else if(order.equals("L")){
				if(loc[1]-1>=0) {
					if(map[loc[0]][loc[1]-1]==0) {
						loc[1] = loc[1]-1;
					}else {
						map[loc[0]][loc[1]-1] -= 1;
						if(map[loc[0]][loc[1]-1]==0) {
							loc[1] = loc[1]-1;
						}
					}
					
				}
			}else if(order.equals("R")){
				if(loc[1]+1<n) {
					if(map[loc[0]][loc[1]+1]==0) {
						loc[1] = loc[1]+1;
					}else {
						map[loc[0]][loc[1]+1] -= 1;
						if(map[loc[0]][loc[1]+1]==0) {
							loc[1] = loc[1]+1;
						}
					}
					
				}
			}else {
				if(loc[1]+1<n) {
					map[loc[0]][loc[1]+1]=0;
				}
				if(loc[1]-1>=0) {
					map[loc[0]][loc[1]-1]=0;
				}
				if(loc[0]+1<n) {
					map[loc[0]+1][loc[1]]=0;
				}
				if(loc[0]-1>=0) {
					map[loc[0]-1][loc[1]]=0;
				}
				if(loc[0]-1>=0 && loc[1]-1>=0) {
					map[loc[0]-1][loc[1]-1]=0;
				}
				if(loc[0]-1>=0 && loc[1]+1<n) {
					map[loc[0]-1][loc[1]+1]=0;
				}
				if(loc[0]+1<n && loc[1]+1<n) {
					map[loc[0]+1][loc[1]+1]=0;
				}
				if(loc[0]+1>=0 && loc[1]-1>=0) {
					map[loc[0]+1][loc[1]-1]=0;
				}
			}
					
		}
		int broken_stone = -1;
		for (int i=0; i<n ; i++ ) {
			for ( int j=0 ; j<n ; j++ ) {
				if (map[i][j]==0) {
					broken_stone += 1;
				}
			}
		}
		System.out.printf("광부 위치 : (%d,%d)",loc[0],loc[1]);
		System.out.println();
		System.out.printf("부순 암석 개수 : %d", broken_stone);
		
	}
	
	
}

