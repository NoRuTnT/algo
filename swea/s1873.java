package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1873 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][]map = new char [h][w];
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				map[i]=str.toCharArray();
			}
			int n = Integer.parseInt(br.readLine());
			char[] order = br.readLine().toCharArray();
			int dir =0;  //탱크방향
			int[] loc = new int[2]; //탱크현재위치
			for(int i=0;i<h;i++) {  //탱크초기위치찾기
				for(int j=0;j<w;j++) {
					if(map[i][j]=='>') { 
						loc[0]=i;
						loc[1]=j;
						dir=0;
					}else if(map[i][j]=='v') {
						loc[0]=i;
						loc[1]=j;
						dir=1;
					}else if(map[i][j]=='<') {
						loc[0]=i;
						loc[1]=j;
						dir=2;
					}else if(map[i][j]=='^') {
						loc[0]=i;
						loc[1]=j;
						dir=3;
					}
				}
			}
			for(int i=0;i<n;i++) { //명령n개수행
				int dr=loc[0];
				int dc=loc[1];
				if(order[i]=='U') {
					map[loc[0]][loc[1]]='^';
					dir=3;
					if(dr-1>=0 && dr-1<h && dc>=0 && dc<w && map[dr-1][dc]=='.') {
						loc[0]--;
						map[dr][dc]='.';
						map[loc[0]][loc[1]]='^';
					}
				}else if(order[i]=='D') {
					map[loc[0]][loc[1]]='v';
					dir=1;
					if(dr+1>=0 && dr+1<h && dc>=0 && dc<w && map[dr+1][dc]=='.') {
						loc[0]++;
						map[dr][dc]='.';
						map[loc[0]][loc[1]]='v';						
					}
				}else if(order[i]=='L') {
					map[loc[0]][loc[1]]='<';
					dir=2;
					if(dr>=0 && dr<h && dc-1>=0 && dc-1<w && map[dr][dc-1]=='.') {
						loc[1]--;
						map[dr][dc]='.';
						map[loc[0]][loc[1]]='<';
					}
				}else if(order[i]=='R') {
					map[loc[0]][loc[1]]='>';
					dir=0;
					if(dr>=0 && dr<h && dc+1>=0 && dc+1<w && map[dr][dc+1]=='.') {
						loc[1]++;
						map[dr][dc]='.';
						map[loc[0]][loc[1]]='>';
					}
				}else {
					if(dir==0) {
						while(dc>=0 && dc<w && map[dr][dc]!='*' && map[dr][dc]!='#') {							
							dc++;							
						}
						if(dc>=0 && dc<w) {
							if(map[dr][dc]=='*') {
								map[dr][dc]='.';							
							}
							
						}
						
					}else if(dir==2) {
						while(dc>=0 && dc<w && map[dr][dc]!='*' && map[dr][dc]!='#') {							
							dc--;							
						}
						if(dc>=0 && dc<w) {
							if(map[dr][dc]=='*') {
								map[dr][dc]='.';							
							}
							
						}
						
					}else if(dir==1) {
						while(dr>=0 && dr<h && map[dr][dc]!='*' && map[dr][dc]!='#') {							
							dr++;							
						}
						if(dr>=0 && dr<h) {
							if(map[dr][dc]=='*') {
								map[dr][dc]='.';
								
							}
							
						}
						
					}else {
						while(dr>=0 && dr<h && map[dr][dc]!='*' && map[dr][dc]!='#') {							
							dr--;							
						}
						if(dr>=0 && dr<h) {
							if(map[dr][dc]=='*') {
								map[dr][dc]='.';								
							}							
						}
						
					}
				}
				
				
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}

}
