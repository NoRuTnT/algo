package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class s1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<>(); //queue생성
		for(int tc=1;tc<=10;tc++) {  //testcase 10개
			int t = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(String e:str) {
				queue.add(Integer.parseInt(e)); 	
			}
			loop : while(true) {  //break될떄까지 무한반복
				for(int i=1;i<=5;i++) {  
					int num = queue.poll();	 //queue front의 숫자하나를꺼내서 i를빼고 다시추가		
					if(num-i<=0) {   //그런데 숫자에서i를뻈을때 0보다 작아지면 0을추가하고 break
						queue.add(0);
						break loop;
					}
					queue.add(num-i);//i를빼준다음 queue에 다시추가
				}
			}
			bw.write("#"+tc+" ");
			for(int i=0;i<8;i++) {
				bw.write(queue.poll()+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
