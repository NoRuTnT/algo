package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class b2750 {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);            
        }
		int size = list.size();		
		for (int i = 0; i < size; i++) {
		    int num = list.get(i);
		    if (num < min) min = num;
		    if (num > max) max = num;
		}

		int[] count = new int[max - min + 1];
		for(int i = 0 ; i<size; i++) {
			count[list.get(i)-min]++;
		}
		for(int i = 1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		int[] sortArr = new int[size];
		for(int i = size-1; i>=0; i--) {
			sortArr[--count[list.get(i)-min]] = list.get(i);
		}
		for(int e:sortArr) {
			bw.write(e+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
