package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s1232 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] str = new String[1001];
		int[] num = new int[1001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int t = Integer.parseInt(br.readLine());
			for(int i=1;i<=t;i++) {
				String[] str1 = br.readLine().split(" ");
				int len = str.length;
				if(len==4) {
					str[i]=str1[1];
				}else {
					num[i]=Integer.parseInt(str1[1]);
				}
			}
		}
	}

}
