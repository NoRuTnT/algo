package swea;

import java.util.Scanner;

public class s13772 {
	public static void main(String[] args) {
		int[][] dir1 = {{1,0},{-1,0},{0,1},{0,-1}};
		int[][] dir2 = {{1,1},{-1,-1},{-1,1},{1,-1}};
		Scanner sc = new Scanner(System.in);
		int sum;
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			int n= sc.nextInt();
			int [][]map= new int[n][n];
			int p = sc.nextInt();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int max =0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sum=map[i][j];
					for(int[] dir:dir1) {						
						int dr=i;
						int dc=j;
						int pcnt=0;
						while(true) {
							dr += dir[0];
							dc += dir[1];
							pcnt++;
							if(dr<0 || dr>=n||dc<0||dc>=n||pcnt>=p+1) {
								break;								
							}
							sum+=map[dr][dc];
						}				
						
					}
					max=Math.max(sum, max);
					sum=map[i][j];
					for(int[] dir:dir2) {						
						int dr=i;
						int dc=j;
						int pcnt=0;
						while(true) {
							dr += dir[0];
							dc += dir[1];
							pcnt++;
							if(dr<0 || dr>=n||dc<0||dc>=n||pcnt>=p+1) {
								break;								
							}
							sum+=map[dr][dc];
						}						
					}
					max=Math.max(sum, max);
				}
			}
			System.out.printf("#%d %d\n",tc,max);
		}
		
	}
}
