package practice;

import java.util.Scanner;

public class AirCrashes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dead[] = new int[n];
		int max = 1;
		int min = 101;
		int count = 0;
		
		for(int i=0; i<n;i++) {
			dead[i] = sc.nextInt();
		}
		for(int e: dead) {
			if (e<min) {
				min = e;
				count = 0;
			} else if(e==min) {
				count++;
			}
			if (e>max) {
				max = e;
			}
			
		}
		if (min==dead[n-1] && count==0) {
			System.out.println(-1);				
		} else {
			System.out.println(max-min);
		}		
	}

}
