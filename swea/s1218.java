package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class s1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();

		for (int tc = 1; tc <=10; tc++) { //testcase
			boolean res = true;  //testcase마다 기본상태true설정
			int n = Integer.parseInt(br.readLine());
			String a = br.readLine();
			stack.clear();  //testcase마다 스택초기화

			 for (int j = 0; j < n; j++) {
	                char ch = a.charAt(j);
	                if (ch == '(' || ch == '<' || ch == '{' || ch == '[') { //4개의 문자는 스택에넣는다
	                    stack.push(ch);
	                } else { //4개제외 다른거일때
	                    if (stack.isEmpty()) { //비어있을때 여는괄호아니면 false
	                        res = false;
	                        break;
	                    } else {
	                        char top = stack.pop();  //스택맨위에 저장되있는것을 top으로 저장
	                        if ((ch == ')' && top != '(') || (ch == '>' && top != '<') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
	                            res = false;  //짝이 맞지않으면 false
	                            break;
	                        }
	                    }
	                }
	            }				
				if (res == false) {
					bw.write("#"+tc+" 0" + "\n");
				} else {
					bw.write("#"+tc+" 1" + "\n");
				}				
				bw.flush();				
			}		
		br.close();
		bw.close();	
		}
		

	

}
