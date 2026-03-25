import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static int[] cleaner;
	static int[][] map,cmap;
	static int[] dr = {0,-1,0,1}; //우상좌하
	static int[] dc = {1,0,-1,0};
	static int[] cdr1 = {0,-1,0,1};//우상좌하
	static int[] cdc1 = {1,0,-1,0};
	static int[] cdr2 = {0,1,0,-1};//우하좌상
	static int[] cdc2 = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		cleaner = new int[2];
		map = new int[R+2][C+2];

		for(int i=1;i<=R;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=C;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(cleaner[0]==0 && map[i][j]==-1){
					cleaner[0]=i;
					cleaner[1]=i+1;
				}
			}
		}
		for(int i=0;i<T;i++){
			diffusion();
			clean();
			change();
		}
		int ans = 0;
		for(int i=1;i<=R;i++){
			for(int j=1;j<=C;j++){
				if(map[i][j]!= -1){
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
	}


	private static void diffusion() {
		cmap = new int[R+2][C+2];
		cmap[cleaner[0]][1]=-1;
		cmap[cleaner[1]][1]=-1;
		for(int i=1;i<=R;i++){
			for(int j=1;j<=C;j++){
				if(j==1 && (cleaner[0]==i || cleaner[1]==i)){
					continue;
				}
				int dir=0;
				for(int d=0;d<4;d++){
					int r = i+dr[d];
					int c = j+dc[d];
					if(r>=1 && r<=R && c>=1 && c<=C && cmap[r][c]!= -1 && map[r][c]!= -1){
						cmap[r][c] += map[i][j]/5;
						dir++;
					}
				}
				cmap[i][j] += map[i][j] - (map[i][j]/5)*dir;
			}
		}
	}

	private static void clean() {
		int r = cleaner[0];
		int c = 1;
		int prev = 0;
		for(int d=0;d<4;d++){
			while(true){
				if(r+cdr1[d]<1 || r+cdr1[d]>cleaner[0] || c+cdc1[d]<1 || c+cdc1[d]>C){
					break;
				}
				if(map[r+cdr1[d]][c+cdc1[d]]==-1){
					break;
				}
				r+=cdr1[d];
				c+=cdc1[d];
				int tmp = cmap[r][c];
				cmap[r][c] = prev;
				prev = tmp;
			}
		}

		r = cleaner[1];
		c = 1;
		prev = 0;
		for(int d=0;d<4;d++){
			while(true){
				if(r+cdr2[d]<cleaner[1] || r+cdr2[d]>R || c+cdc2[d]<1 || c+cdc2[d]>C){
					break;
				}
				if(map[r+cdr2[d]][c+cdc2[d]]==-1){
					break;
				}

				r+=cdr2[d];
				c+=cdc2[d];

				int tmp = cmap[r][c];
				cmap[r][c] = prev;
				prev = tmp;

			}
		}
		cmap[cleaner[0]][1]=-1;
		cmap[cleaner[1]][1]=-1;

	}
	private static void change() {
		for(int i=1;i<=R;i++){
			for(int j=1;j<=C;j++){
				map[i][j] = cmap[i][j];
				// System.out.print(map[i][j]+" ");
			}
			// System.out.println();
		}
	}
}
