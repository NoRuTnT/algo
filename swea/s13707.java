package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s13707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			char[][]map = new char[n][n];
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();						
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {					
					if(map[i][j]=='A') {
						for(int[] dir:direction) {
							int dr = i+dir[0];
							int dc = j+dir[1];
							if(dr>=0 && dr<n && dc<n && dc>=0) {
								map[dr][dc]='X';
							}
						}
					} else if(map[i][j]=='B') {
						for(int[] dir:direction) {
							int dr = i+dir[0];
							int dc = j+dir[1];
							for(int k=0;k<2;k++) {
								if(dr>=0 && dr<n && dc<n && dc>=0) {
									map[dr][dc]='X';
									dr+=dir[0];
									dc+=dir[1];
								}								
							}
						}
					} else if(map[i][j]=='C') {
						for(int[] dir:direction) {
							int dr = i+dir[0];
							int dc = j+dir[1];
							for(int k=0;k<3;k++) {
								if(dr>=0 && dr<n && dc<n && dc>=0) {
									map[dr][dc]='X';
									dr+=dir[0];
									dc+=dir[1];
								}								
							}
						}
					}
					
				}
			}
			int cnt=0;
			for(int i=0;i<n;i++) {				
				for(int j=0;j<n;j++) {
					if(map[i][j]=='H') cnt++;									
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}

}
