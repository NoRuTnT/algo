package test.day4;

import java.util.Arrays;
import java.util.Scanner;

public class s1209 {
	public static void main(String[] args) {
		int[][] map = new int [100][100];
		int sum;
		int max_sum;
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int t = sc.nextInt();
			max_sum=0;
			//�Է�
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					 map[i][j] = sc.nextInt();
					 
					
				}
			}
			//������
			for(int i=0;i<100;i++) {
				sum =0;
				for(int j=0;j<100;j++) {
					
					sum += map[i][j];
					max_sum = Math.max(max_sum, sum);					
				}
			}
			//������
			for(int j=0;j<100;j++) {
				sum =0;
				for(int i=0;i<100;i++) {					
					sum += map[i][j];
					max_sum = Math.max(max_sum, sum);					
				}
			}
			//�밢����
			sum =0;
			for(int i=0;i<100;i++) {				
				sum += map[i][i];
				max_sum = Math.max(max_sum, sum);					
				
			}
			//�밢��2��
			sum =0;
			for(int i=0;i<100;i++) {
				sum += map[99-i][i];
				max_sum = Math.max(max_sum, sum);			
			}
			System.out.printf("#%d %d\n",tc,max_sum);
		}
	}

}
