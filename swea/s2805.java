package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n= Integer.parseInt(br.readLine());
			int[][]map = new int[n][n];
			for(int i=0;i<n;i++) {
				String[] str = br.readLine().split("");
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			int sum=0;
			for(int i=0;i<n;i++) {				
				for(int j=0;j<n;j++) {
					if(Math.abs((n/2)-i)+Math.abs((n/2)-j) <= n/2) {
						sum+=map[i][j];					
					}
				}
			}
			bw.write("#"+tc+" "+sum+"\n");
			
			
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
