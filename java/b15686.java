package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//노드로풀기연습 
class node1 {
	int x;
	int y;

	node1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class b15686 {
	static int[][] map;
	static ArrayList<node1> home, chicken;
	static int n, m;
	static int result = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if (a == 1) {
					home.add(new node1(i, j));
				} else if (a == 2) {
					chicken.add(new node1(i, j));
				}
			}
		}
		node1[] arr = new node1[m];
		dfs(0, 0, arr);
		System.out.println(result);
	}

	public static void dfs(int depth,int start, node1[] arr) {
		 if (depth == m) {
	            int res = 0;
	            for(int i=0;i<home.size();i++) {
            			if (map[home.get(i).x][home.get(i).y] == 1) {
            				res += getDistance(arr, home.get(i).x, home.get(i).y);
            				
            			}
        			}	                
	                if (res < result) {
	    				result = res;
	    			}
	    			return;
	            }
	           
	        
			for (int i=start;i<chicken.size();i++) {
				arr[depth] = chicken.get(i);
	            dfs(depth+1,i+1,arr);
	        }
		}

	public static int getDistance(node1[] arr, int x, int y) {
		int tmp = Integer.MAX_VALUE;
		for (int j2 = 0; j2 < arr.length; j2++) {
			int distance = Math.abs(x - arr[j2].x) + Math.abs(y - arr[j2].y);

			tmp = Math.min(tmp, distance);
		}
		return tmp;

	}
}
