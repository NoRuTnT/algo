package practice;

import java.util.Scanner;

public class ProductValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int arr[] = new int[n];
		int save[] = new int[n];
		
		for (int i=0;i<n;i++) {
			int price = sc.nextInt();
			save[i]=price;
			if(i==0) {
				arr[0]=price;
			}else {
		        int j = i;
		        while (j > 0 && arr[j - 1] < price) {
		            arr[j] = arr[j - 1];
		            j--;
		        }
		        arr[j] = price;
		    }		
//			for(int k=0;k<n;k++) {
//				System.out.print(arr[k]+" ");
//				System.out.print(save[k]+" ");
//			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]==save[i]) {
					System.out.print(j+1+" ");
					break;
				}		
			}			
		}		
	}
}

