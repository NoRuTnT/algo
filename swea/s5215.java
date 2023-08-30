package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5215 {
	static int n;
	static int l;
	static int max_t;
	static int[] T;
	static int[] K;
	
	public static boolean[] sel;
	public static void powerset(int idx , int[] T, int[] K) {
		if (idx == n) { 
			int sumt=0;			
			int sumk=0;			
			for (int i = 0; i < n; i++) {
				if (sel[i]) {
					sumt+=T[i];
					sumk+=K[i];					
				}
			}
			if(sumk<=l) {
				max_t=Math.max(sumt, max_t);
			}
			
			return;
		}
		// 재귀파트
		sel[idx] = false;
		powerset(idx + 1,T,K);

		sel[idx] = true;
		powerset(idx + 1,T,K);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			T = new int[n];
			K = new int[n];
			for(int i=0;i<n;i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st1.nextToken());
				K[i] = Integer.parseInt(st1.nextToken());
			}
			sel = new boolean[n];
			max_t=0;
			powerset(0,T,K);
			System.out.printf("#%d %d\n",tc,max_t);
		}
	}

}
