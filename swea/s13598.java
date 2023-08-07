package test;

import java.util.Scanner;

public class s13598 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int max_num=0;
		int max_index=0;
		int max_indexdiff=0;
		int cnt =0;
		int fall;
		for(int i=0;i<n;i++) {
			if(max_num<arr[i]) {
				max_num=arr[i];
				max_index=i;
				cnt=0;
			}else if(max_num==arr[i]) {
				cnt+=1;
				if(max_indexdiff<i-max_index) {
					max_indexdiff=i-max_index;					
				}
				max_index=i;
			}
		}
		if(cnt==0) {
			fall=n-1-max_index;
		} else {
			fall=Math.max(n-1-max_index, max_indexdiff);
		}
		System.out.println(fall);
	}

}
