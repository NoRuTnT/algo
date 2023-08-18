package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) { //testcase
			String[] str = br.readLine().split(" ");			
			int n = Integer.parseInt(str[0]); //입력
			int m = Integer.parseInt(str[1]); //입력
			bw.write("#"+tc+" ");
			if(n==m) { //n과m이 같으면 최댓값은 1+m만나옴
				bw.write(1+m+" ");
			}else if(n>m) {  //n과m이 다를때는 최댓값은 1+작은수 부터 1+큰수 까지동일한갯수로나오며 m+n을 넘지않는다
				for(int i=1+m;i<=1+n;i++) {
					if(i>m+n)break;
					bw.write(i+" ");
				}
			}else {
				for(int i=1+n;i<=1+m;i++) {
					if(i>m+n)break;
					bw.write(i+" ");
				}
			}
			bw.write("\n");			
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
