package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class b1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				while(true) {
					if(stack.isEmpty()||order(ch)>order(stack.peek())) {
						stack.push(ch);
						break;
					}else {
						char word = stack.pop();
						bw.write(word);						
					}
				}
				
			} else if(ch=='(') {
				stack.push(ch);				
			} else if(ch==')') {				
				while(true) {
					char word = stack.pop();
					if(word=='(') {
						break;
					}
					bw.write(word);															
				}
			} else {
				bw.write(ch);
			}
		}
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				char word = stack.pop();
				bw.write(word);
			}
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static int order(char ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		}
		return -1;
	}

}
