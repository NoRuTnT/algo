package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b2573 {
	//우하좌상
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] visit_dfs;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int year=0;
		while(true) {
			year++;
			visit = new boolean[n][m];
			visit_dfs = new boolean[n][m];
			list = new ArrayList<>();
			melt();
			if(list.isEmpty()) {
				System.out.println(0);
				break;
			}
			for(int[]e:list) {
				int x=e[0];
				int y=e[1];
				int num=e[2];
				if(map[x][y]-num<0) {
					map[x][y]=0;
				}else {
					map[x][y]-=num;
				}			
			}
			int count=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]!=0 && !visit_dfs[i][j]) {
						count++;
						visit_dfs[i][j]=true;
						dfs(i,j);					
					}
				}			
			}
			if(count>=2) {
				System.out.println(year);
				break;
			}			
		}		
	}

	public static void dfs(int i, int j) {
		for(int k=0;k<4;k++) {
			int x=i+dr[k];
			int y=j+dc[k];
			if(x>=0 && x<n && y>=0 && y<m ) {
				if(map[x][y]!=0 && !visit_dfs[x][y]) {
					visit_dfs[x][y]=true;
					dfs(x,y);					
				}
			}
		}
		return;
	}
	public static void melt() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0 && !visit[i][j]) {
					int cnt=0;
					for(int k=0;k<4;k++) {
						int x=i+dr[k];
						int y=j+dc[k];
						if(map[x][y]==0) {
							cnt++;
						}
					}
					list.add(new int[]{i,j,cnt});
				}
			}			
		}		
	}

}
