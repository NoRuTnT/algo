package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class b28278 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i =0;i<n;i++) {
			String[] a = bf.readLine().split(" ");
			int order = Integer.parseInt(a[0]);			
			if(order==1) {
				int input = Integer.parseInt(a[1]);
				stack.push(input);
			}else if(order==2){
				if(stack.empty()==true) {
					bw.write(-1+"\n");
				} else {
					bw.write(stack.peek()+"\n");
					stack.pop();				
				}
			}else if(order==3) {
				bw.write(stack.size()+"\n");
			}else if(order==4) {
				if(stack.empty()==true) {
					bw.write(1+"\n");
				}else {
					bw.write(0+"\n");
				}
			}else if(order==5) {
				if(stack.empty()==true) {
					bw.write(-1+"\n");
				}else {
					bw.write(stack.peek()+"\n");
				}
			}			
		}
		bw.flush();
		bf.close();
		bw.close();
	}
}

