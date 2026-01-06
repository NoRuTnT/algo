import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,t;
	static int[] exp,expCut;
	static int[][] move,dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		exp = new int[n+1];
		dp = new int[t+1][n+1];
		move = new int[n+1][n+1];
		expCut = new int[n+1];
		for (int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			int cut = Integer.parseInt(st.nextToken());
			int gain = Integer.parseInt(st.nextToken());

			expCut[i] = cut;
			exp[i] = gain;

		}

		for (int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++){
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0;i<=t;i++){
			Arrays.fill(dp[i],-1);
		}

		for (int i=1;i<=n;i++) {
			if(expCut[i]==0) {
				dp[0][i] = 0;
			}
		}

		for(int time=0;time<=t;time++){
			for(int place=1;place<=n;place++){
				if(dp[time][place]<0){
					continue;
				}

				if (dp[time][place]>=expCut[place] && time+1<=t) {
					dp[time+1][place] = Math.max(dp[time+1][place],dp[time][place]+exp[place]);
				}

				for(int next=1;next<=n;next++) {
					int newtime=time + move[place][next];
					
					if(newtime<=t && dp[time][place]>=expCut[next]) {
						dp[newtime][next] = Math.max(dp[newtime][next],dp[time][place]);
					}
				}
			}
		}

		int ans = 0;
		for (int i=1;i<=n;i++) {
			ans = Math.max(ans,dp[t][i]);
		}

		System.out.println(ans);


	}


}
