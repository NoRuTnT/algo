import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] rev = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++){
			rev[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rev[b].add(a);
		}

		for(int i = 0; i < q; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());


			int[] umove = bfs(u,rev);
			int[] vmove = bfs(v,rev);

			int ans = Integer.MAX_VALUE;
			for(int j = 1; j <= n; j++){
				if(umove[j] != -1 && vmove[j] != -1){
					ans = Math.min(ans, Math.max(umove[j], vmove[j]));
				}

			}
			if(ans == Integer.MAX_VALUE){
				ans = -1;
			}
			sb.append(ans).append("\n");

		}
		System.out.println(sb);
	}

	public static int[] bfs(int start, ArrayList<Integer>[] rev) {
		int[] move = new int[n+1];
		Arrays.fill(move, -1);

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		move[start] = 0;
		while(!q.isEmpty()){
			int now = q.poll();
			for(int next : rev[now]){
				if(move[next] == -1){
					move[next] = move[now]+1;
					q.add(next);
				}
			}
		}
		return move;

	}
}
