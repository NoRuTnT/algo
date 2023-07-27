import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class b15686 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] chicken_map;
	static int sum;
	static int store;
	static int distance;
	static int min_distance;
	static List<Integer> sum_distance = new ArrayList<>();
	
	static void drawchicken(int x, int y) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distance=Math.abs(x-i)+Math.abs(y-j);
				sum += distance;				
				if (distance<chicken_map[i][j]) {
					chicken_map[i][j]=distance;					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		chicken_map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = 100;
			}
		}	
		
		min_distance = 0;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if(map[r][c]==2) {
					store+=1;
					drawchicken(r, c);
					sum_distance.add(sum);
				}
				if(store>m) {
					sum_distance.sort(Comparator.naturalOrder());
					for(int i=0;i<(store-m);i++) {
						sum_distance.remove(0);
					}
					
				}
					
				}
			}		
		
		}

}
