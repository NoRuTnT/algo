package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class b10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int num=0;
		for(int i=0;i<t;i++) {
			String[] str = br.readLine().split(" ");			
			if(str[0].equals("push")) {
				queue.offer(Integer.parseInt(str[1]));
				num=Integer.parseInt(str[1]);
			}else if (str[0].equals("pop")) {
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(queue.poll()+"\n");					
				}
			}else if (str[0].equals("size")) {
				bw.write(queue.size()+"\n");
			}else if (str[0].equals("empty")) {
				if(queue.isEmpty()) {
					bw.write(1+"\n");
				}else {
					bw.write(0+"\n");					
				}
			}else if (str[0].equals("front")) {
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(queue.peek()+"\n");
				}
			}else {
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(num+"\n");
				}
			}
			
		}
		bw.flush();
		br.close();
		bw.close();	
		
	}

}
