package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1231 {
	public static String[] arr;
	public static int n;
	public static void inorder(int i) {
		if(i < n) {
			inorder(i*2);   
			if(!arr[i].equals(" "))
				System.out.print(arr[i]); 
			inorder(i*2+1); 
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int t = Integer.parseInt(br.readLine());
			arr = new String[t+1];
			n = arr.length;
			for(int i=1;i<=t;i++) {
				String[] str = br.readLine().split(" ");
				arr[i]=str[1];
			}	
			System.out.print("#"+tc+" ");
			inorder(1);
			System.out.println();
		}
		
	}

}
