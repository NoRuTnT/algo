import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[][] map,gmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		gmap = new boolean[N][M];
		int cnt = 0;

		for(int i=0;i<N;i++){
			String[] tmp = br.readLine().split("");
			for(int j=0;j<M;j++){
				if(tmp[j].equals("1")){
					map[i][j]=true;
				}
			}
		}
		for(int i=0;i<N;i++){
			String[] tmp = br.readLine().split("");
			for(int j=0;j<M;j++){
				if(tmp[j].equals("1")){
					gmap[i][j]=true;
				}
			}
		}

		if(N>=3 && M>=3){
			for(int i=0;i<N-2;i++){
				for(int j=0;j<M-2;j++){
					if(map[i][j]!=gmap[i][j]){
						check(i,j);
						cnt++;
					}
				}
			}
		}

		loop:for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]!=gmap[i][j]){
					cnt=-1;
					break loop;
				}
			}
		}

		System.out.println(cnt);

	}

	static void check(int a,int b){
		for(int i=a;i<a+3;i++){
			for(int j=b;j<b+3;j++){
				map[i][j] = !map[i][j];
			}
		}
	}
}
