package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s10726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int cnt=0;
			for(int i=0;i<n;i++) {
				if((m&(1<<i))>0) {
					cnt++;
				}
			}
			if(cnt==n) {
				System.out.printf("#%d ON\n",tc);
			}else {
				System.out.printf("#%d OFF\n",tc);
			}
		}
		
	}

}
