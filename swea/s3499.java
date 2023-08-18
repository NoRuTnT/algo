package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class s3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int mid;
		Queue<String> queue = new LinkedList<>(); //queue생성
		Queue<String> queue2 = new LinkedList<>(); //queue2생성
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			mid=0;
			queue = new LinkedList<>(); //queue초기화
			queue2 = new LinkedList<>();//queue2초기화
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			if(str.length%2==0) {  //단어가 짝수개일때 홀수개일때 mid를 다르게 설정
				mid = ((str.length/2)-1);				
			}else {
				mid = str.length/2;	
			}
			for(int i=0;i<=mid;i++) { //mid를 기준으로 두개의 queue에 저장
				queue.add(str[i]);
			}
			for(int i=mid+1;i<str.length;i++) {
				queue2.add(str[i]);
			}
			bw.write("#"+tc+" ");
			while(!queue.isEmpty()) {
				if(!queue.isEmpty()) {  //번갈아가면서 두스택의 원소가 모두 빠질때까지 반복
					bw.write(queue.poll()+" ");					
				}
				if(!queue2.isEmpty()) {
					bw.write(queue2.poll()+" ");
				}
			}
			bw.write("\n");			
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
