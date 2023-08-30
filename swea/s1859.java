package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n= Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] num = new int[n];
			int idx = -1;			
			int max=-1;
			
			for(int i=0;i<str.length;i++) {
				num[i] = Integer.parseInt(str[i]);
				if(num[i]>max) {
					max=num[i];
					idx=i;
				}
			}
			int sum=0;
			for(int i=0;i<idx;i++) {
				sum+=(max-num[i]);
			}
			bw.write("#"+tc+" "+sum+"\n");
				
			
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
