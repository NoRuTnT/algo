package test;

import java.util.Scanner;

public class s2068 {
	static int max_num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		int[] arr = new int [10];
		
		for(int i=0;i<t;i++) {
			max_num=0;
			for(int j=0;j<10;j++) {
				arr[i]=sc.nextInt();
				if(arr[i]>max_num) {
					max_num = arr[i];
				}
			}
			System.out.printf("#%d %d\n",i+1,max_num);			
		}		
	}
}
