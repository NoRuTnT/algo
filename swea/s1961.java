package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s1961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n= Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[][] new_map = new int[n][n];
			int[][] neww_map = new int[n][n];
			int[][] newww_map = new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n;i++) {  				//90도회전 1번
				for(int j=0;j<n;j++) {
					new_map[j][n-1-i] = map[i][j];			
				}
			}
			for(int i=0;i<n;i++) {					//90도회전 2번
				for(int j=0;j<n;j++) {
					neww_map[j][n-1-i] = new_map[i][j];			
				}
			}
			for(int i=0;i<n;i++) {					//90도회전 3번
				for(int j=0;j<n;j++) {
					newww_map[j][n-1-i] = neww_map[i][j];			
				}
			}
			bw.write("#"+tc+"\n");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					bw.write(new_map[i][j]+"");
				}
				bw.write(" ");
				for(int j=0;j<n;j++) {												
					bw.write(neww_map[i][j]+"");				
				}
				bw.write(" ");
				for(int j=0;j<n;j++) {												
					bw.write(newww_map[i][j]+"");							
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	

}
