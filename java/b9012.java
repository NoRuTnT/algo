package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class b9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i =0; i<n; i++) {
			String a = br.readLine();
			int b = a.length();
			
			for(int j=0;j<b;j++) {
				char ch = a.charAt(j);
				if (ch == '(') {
					stack.push(ch);					
				}else {
					if(stack.size()==0) {
						stack.push(ch);
						break;
					}else {
						stack.pop();
					}
				}
				
			}
			if(stack.isEmpty()) {
				bw.write("YES"+"\n");
			}else {
				bw.write("NO"+"\n");
			}			
			stack.clear();	
		}
		br.close();
		bw.close();
		
		
	}

}
