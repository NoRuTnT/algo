package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class s1230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());		
			String[] str = br.readLine().trim().split(" ");
			LinkedList<String> list = new LinkedList<>(Arrays.asList(str));
			int order_num = Integer.parseInt(br.readLine());
			String[] order = br.readLine().trim().split(" ");
			int order_cnt=0;
			int i=0;
			while(order_cnt<=order_num && i<order.length) {				
				if(order[i].equals("I")) {	
					order_cnt++;
					int location = Integer.parseInt(order[i+1]);
					int num = Integer.parseInt(order[i+2]);
					for (int j = 0; j < num; j++) {
						list.add(location + j, order[i+3+j]);
					}
				}
				if(order[i].equals("D")) {
					order_cnt++;
					int del_location = Integer.parseInt(order[i+1]);
					int del_num = Integer.parseInt(order[i+2]);
					for(int j=0;j<del_num;j++) {
						list.remove(del_location+j);						
					}
				}
				if(order[i].equals("A")) {
					order_cnt++;
					int add_num = Integer.parseInt(order[i+1]);
					for(int j=i+2;j<i+2+add_num;j++) {
						list.addLast(order[j]);						
					}
				}
				i++;			
			}
			bw.write("#" + tc + " ");
			for (int j = 0; j < 10; j++) {
				bw.write(list.get(j) + " ");
			}
			bw.write("\n");			

		}
		bw.flush();
		br.close();
		bw.close();
	}

}
