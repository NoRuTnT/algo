package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1240 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][]map = new int [n][m];
			for(int i=0;i<n;i++) {
				String[] str =br.readLine().split("");
				for(int j=0;j<m;j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			int[] idx=new int[2];
			loop:for(int i=0;i<n;i++) {
				for(int j=m-1;j>=0;j--) {
					if(map[i][j]==1) {
						idx[0]=i;
						idx[1]=j;
						break loop;
					}
				}
			}
			int dr=idx[0];
			int dc=idx[1];
			int []arr=new int [56];
			int [][] new_arr = new int[8][7];
			for(int i=dc-55;i<=dc;i++) {
				arr[i-dc+55] = map[dr][i];
			}
			int[] sum= new int[8];
			for(int i=0;i<8;i++) {
				new_arr[i] = Arrays.copyOfRange(arr, 7*i, 7*i+7);
				String str = Arrays.toString(new_arr[i]).replace(", ","").replace("[","").replace("]","");
				int num = 0;
				if(str.equals("0001101")) {
					num=0;
				}else if(str.equals("0011001")) {
					num=1;
				}else if(str.equals("0010011")) {
					num=2;
				}else if(str.equals("0111101")) {
					num=3;
				}else if(str.equals("0100011")) {
					num=4;
				}else if(str.equals("0110001")) {
					num=5;
				}else if(str.equals("0101111")) {
					num=6;
				}else if(str.equals("0111011")) {
					num=7;
				}else if(str.equals("0110111")) {
					num=8;
				}else if(str.equals("0001011")) {
					num=9;
				}
				sum[i] = num;
			}
			int total=0;
			for(int i=0;i<8;i++) {
				total += sum[i];
			}
			
			if(((sum[0]+sum[2]+sum[4]+sum[6])*3+sum[1]+sum[3]+sum[5]+sum[7])%10==0) {
				System.out.printf("#%d %d\n",tc,total);
			}else {
				System.out.printf("#%d %d\n",tc,0);
			}			
			
		}
	}

}
