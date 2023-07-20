package practice;

import java.util.Scanner;

public class SwitchTest {	
	public static void main(String[] args) {	

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] sch = new int[n];
		
		for(int i =0;i<m;i++) {
			int a = sc.nextInt();
			for(int j=1;a*j-1<n;j++) {				
				if(sch[a*j-1]==0) {
					sch[a*j-1]=1;
				}else {
					sch[a*j-1]=0;
				}			
			}			
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.print(sch[i]+" ");
		}
				
	}	
}
