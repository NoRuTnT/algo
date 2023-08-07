package test;

import java.util.Scanner;

public class s1206 {
	static int[] arr;
	static int result;
	static int sum;
	
	public static int search_Goodroom(int i){
		if (arr[i]>arr[i+1]&&arr[i]>arr[i+2]&&arr[i]>arr[i-1]&&arr[i]>arr[i-2]) {
			result = arr[i]-Math.max(Math.max(arr[i-2], arr[i-1]),Math.max(arr[i+1], arr[i+2]));			
		}else {
			return 0;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int a=0;a<10;a++) {
			int t= sc.nextInt();
			sum=0;
			arr = new int [t];
			for(int i=0;i<t;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=2;i<t-2;i++) {
				int num = search_Goodroom(i);
				sum += num;
			}
			System.out.printf("#%d %d\n",a+1,sum);
		}
		
	}
	
}
