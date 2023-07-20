package practice;

import java.util.Scanner;

public class Fernace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int t = sc.nextInt();
		int[] btn = new int[t];
		int min_diff = Math.abs(a-b);
		int count = 0;
		
		
		for(int i=0;i<t;i++) {
			btn[i] = sc.nextInt();
		}
		for(int i=0;i<t;i++) {
			if(min_diff>Math.abs(btn[i]-b)) {
				min_diff = Math.abs(btn[i]-b);
			}	
		}
		
		if(min_diff!=Math.abs(a-b)) {
			count += 1;
		}
		if(min_diff+count>600) {
			System.out.println(-1);
		}else {
			System.out.println(min_diff+count);
		}		
	}
}
