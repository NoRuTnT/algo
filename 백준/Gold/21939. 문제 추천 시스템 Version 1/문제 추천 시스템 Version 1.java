import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static class Problem implements Comparable<Problem>{
		int num;
		int level;

		Problem(int num, int level){
			this.num=num;
			this.level=level;
		}
		@Override
		public int compareTo(Problem o) {
			if(this.level != o.level) {
				return this.level-o.level;
			}else {
				return this.num-o.num;
			}
		}
	}

	static TreeSet<Problem> treeset = new TreeSet<>();
	static HashMap<Integer,Problem> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			Problem problem = new Problem(p, l);
			map.put(p, problem);
			treeset.add(problem);
		}
		m = Integer.parseInt(br.readLine());
		int p,l,x;

		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			switch(str){
				case "add":
					p = Integer.parseInt(st.nextToken());
					l = Integer.parseInt(st.nextToken());
					add(p,l);
					break;

				case "recommend":
					x = Integer.parseInt(st.nextToken());
					recommend(x);
					break;

				case "solved":
					p = Integer.parseInt(st.nextToken());
					solved(p);
					break;

			}
		}

		System.out.println(sb);
	}

	static void add(int p, int l){
		Problem problem = new Problem(p, l);
		map.put(p, problem);
		treeset.add(problem);
	}

	static void recommend(int x) {
		if(x==1) {
			sb.append(treeset.last().num).append("\n");
		}else {
			sb.append(treeset.first().num).append("\n");
		}
	}

	static void solved(int p){
		Problem problem = map.get(p);
		map.remove(p);
		treeset.remove(problem);
	}
}
