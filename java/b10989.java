package test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int n = Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(arr[i], max);
		}
		int[] count = new int [max+1];
		for(int i=0;i<n;i++) {
			count[arr[i]]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i]+=count[i-1];
		}
		int[] sort_arr=new int[n];
		for(int i=n-1;i>=0;i--) {
			sort_arr[--count[arr[i]]] = arr[i];
		}
		for(int i=0;i<n;i++) {
			bw.write(sort_arr[i]+"\n");			
		}		
		bw.flush();
		br.close();
		bw.close();
		
	}

}
