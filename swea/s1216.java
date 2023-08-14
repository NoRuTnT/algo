package test.day5;

import java.util.Scanner;

public class s1216 {
	public static void main(String[] args) {
		char[][] map = new char [100][100];
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<11;tc++) {
			int t=sc.nextInt();
			for(int i=0;i<100;i++) {				
				map[i]=sc.next().toCharArray();				
			}
			int max =0;
			int cnt=0;
			//가로검색
			for(int i=0;i<100;i++) {
				for(int j=1;j<99;j++) {					
					if(map[i][j]==map[i][j+1]) {
						int l = j;
						int k = j+1;
						
						while(l>=0 && k<100) {
							if(map[i][l--]==map[i][k++]) {
								cnt+=2;
								
							}else {
								break;
							}
						}
						max = Math.max(cnt, max);
						cnt=0;
					}
					if(map[i][j-1]==map[i][j+1]) {
						int a = j-1;
						int b = j+1;
						cnt=1;
						while(a>=1 && b<99) {
							if(map[i][a--]==map[i][b++]) {
								cnt+=2;
							}else {
								break;
							}
						}
						max = Math.max(cnt, max);
						cnt=0;
					}
				}
			}
			//세로검색
			for(int i=1;i<99;i++) {
				for(int j=0;j<100;j++) {					
					if(map[i][j]==map[i+1][j]) {
						int l = i;
						int k = i+1;
						cnt=0;
						while(l>=0 && k<99) {
							if(map[l--][j]==map[k++][j]) {
								cnt+=2;
							}else {
								break;
							}
						}
						max = Math.max(cnt, max);
						cnt=0;
					}
					if(map[i-1][j]==map[i+1][j]) {
						int a = i-1;
						int b = i+1;
						cnt=1;
						while(a>=1 && b<99) {
							if(map[a--][j]==map[b++][j]) {
								cnt+=2;
							}else {
								break;
							}
						}
						max = Math.max(cnt, max);
						cnt=0;
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,max);			
			
		}
		
	}

}
