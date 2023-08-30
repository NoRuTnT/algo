package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2817 {
	static int n;
	static int k;
	static int cnt;
	public static boolean[] sel;
	public static void powerset(int idx , int[]num) {
		if (idx == n) { 
			int sum=0;			
			for (int i = 0; i < n; i++) {
				if (sel[i])
					sum+=num[i];
			}
			if(sum==k) {
				cnt++;
			}
			
			return;
		}
		// 재귀파트
		sel[idx] = false;
		powerset(idx + 1,num);

		sel[idx] = true;
		powerset(idx + 1,num);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			sel = new boolean[n];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int[] num = new int[n];
			for(int i=0;i<n;i++) {				
				num[i]=Integer.parseInt(st1.nextToken());
			}
			cnt=0;			
			powerset(0,num);
			System.out.print("#"+tc+" "+cnt+"\n");
		}
	}

}
