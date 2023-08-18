package test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class b13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int[] diff = new int[n-1];
		int k = Integer.parseInt(arr[1]);		
		String[] child = br.readLine().split(" ");
		int num = child.length;
		for(int i=0;i<num-1;i++) {
			diff[i] = Integer.parseInt(child[i+1]) - Integer.parseInt(child[i]);
		}
		Arrays.sort(diff);
		int sum=0;
		for(int i=0;i<n-k;i++) {
			sum += diff[i];
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
