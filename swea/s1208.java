package test;

import java.util.Arrays;
import java.util.Scanner;

public class s1208 {
	static int[] arr;	
	static int max;
	static int min;
	
	public static int move_box(int move) {
        while (move > 0) {
            Arrays.sort(arr); 
            arr[99]--;
            arr[0]++; 
            move--;
        }
        max=0;
        min=101;
        for(int i=0;i<100;i++) {
        	if(arr[i]>max) {
        		max = arr[i];
        	}
        	if(arr[i]<min) {
        		min = arr[i];
        	}
        }
        return max-min;
    }	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<11;tc++) {
			int move = sc.nextInt();
			arr = new int [100];
			for(int i=0;i<100;i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			int result = move_box(move);			
			System.out.printf("#%d %d\n",tc,result);			
		}		
	}

}
