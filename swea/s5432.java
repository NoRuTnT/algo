package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class s5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>(); 
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<t+1;tc++) {
			String str = br.readLine();
			stack.clear();  //스택초기화
			int high=0;  //파이프층수
			int pipe=0;  //파이프조각개수
			for(int i=0;i<str.length();i++) {
				char word = str.charAt(i);
				if(word=='(') {   //(나오면 층수+1 초각+1
					high++;
					pipe++;
					stack.push(word); //스택에추가					
				}else {					
					if (!(high==0)) {  //파이프가 존재할때 )나오면 
						high--;  // 파이프층수 -1
                        if (stack.peek() == '(') { // ()가 만들어진다면 
    						pipe--; // 일단 추가해주었던 조각+1 취소 <-파이프가아니라 레이저표시이기때문
                            pipe += high; //레이저로 절단할때 파이프층수만큼 조각생성
                        }
						stack.push(word);
                    }
				}
			}
			System.out.printf("#%d %d\n",tc,pipe);
		}
		br.close();
		
	}

}
