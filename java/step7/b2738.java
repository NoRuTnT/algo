package practice;
import java.util.Scanner;

public class b2738 {
	public static void main(String[] args) {
		int n;
		int m;
		int[][] map;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		
		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				map[i][j] += sc.nextInt();
			}
		}
		for(int i =0; i<n;i++) {
			for(int j=0; j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}			
	}
}
