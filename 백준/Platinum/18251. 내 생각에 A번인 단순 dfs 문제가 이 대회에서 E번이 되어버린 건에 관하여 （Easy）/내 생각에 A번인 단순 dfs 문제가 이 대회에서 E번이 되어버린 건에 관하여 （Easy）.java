import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, index, maxdepth;
	static int[] weight, node, x, y, xindex, xsum;
	static ArrayList<Integer>[] xdepth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		weight = new int[n + 1];
		node = new int[n + 1];
		x = new int[n + 1];
		y = new int[n + 1];
		xindex = new int[n + 1];
		xdepth = new ArrayList[n + 1];
		long answer = Long.MIN_VALUE;

		maxdepth = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			xdepth[i] = new ArrayList<>();
		}
		index = 0;
		inorder(1, 0);

		for (int y1 = 0; y1 <= maxdepth; y1++) {
			xsum = new int[n + 1];
			boolean[] xcheck = new boolean[n+1];
			for (int y2 = y1; y2 <= maxdepth; y2++) {
				for (int nowx : xdepth[y2]) {
					xsum[nowx] += weight[xindex[nowx]];
					xcheck[nowx]=true;

				}
				answer = Math.max(answer, scan(xsum,xcheck));

			}

		}
		System.out.println(answer);

	}

	private static void inorder(int node, int depth) {
		if (node > n) {
			return;
		}
		if (maxdepth < depth) {
			maxdepth = depth;
		}
		inorder(node * 2, depth + 1);
		x[node] = ++index;
		y[node] = depth;
		xindex[index] = node;
		xdepth[depth].add(index);
		inorder(node * 2 + 1, depth + 1);

	}

	private static long scan(int[] sumarr,boolean[] xcheck) {
		long now = Long.MIN_VALUE;
		long max = Long.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			if (now < 0 && xcheck[i]) {
				now = sumarr[i];
			} else {
				now += sumarr[i];
			}
			if (now > max) {
				max = now;
			}
		}

		return max;
	}
}
