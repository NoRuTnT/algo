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
			int n = Integer.parseInt(str[0]); //�Է�
			int m = Integer.parseInt(str[1]); //�Է�
			bw.write("#"+tc+" ");
			if(n==m) { //n��m�� ������ �ִ��� 1+m������
				bw.write(1+m+" ");
			}else if(n>m) {  //n��m�� �ٸ����� �ִ��� 1+������ ���� 1+ū�� ���������Ѱ����γ����� m+n�� �����ʴ´�
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
