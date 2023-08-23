package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1244 {
	public static String change(String str) {
		if(str.equals("0")) {
			return "1";
		}else {
			return "0";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String[] str1 = br.readLine().split(" ");
			int sex = Integer.parseInt(str1[0]);
			int order = Integer.parseInt(str1[1]);
			if(sex==1) {
				for(int j=1;j<=n;j++) {
					if(order*j-1>=n||order*j-1<0) {
						break;
					}
					str[order*j-1] = change(str[order*j-1]);					
				}
			} else {
				str[order-1] = change(str[order-1]);
				for(int j=1;j<=n;j++) {
					if(order+j-1>=n || order-j-1 <0 || !(str[order+j-1].equals(str[order-j-1]))){
						break;
					}
					str[order+j-1]=change(str[order+j-1]);
					str[order-j-1]=change(str[order-j-1]);					
				}
			}
		}
		int cnt=0;
		for(String e:str) {			
			cnt+=1;			
			bw.write(Integer.parseInt(e)+" ");
			if(cnt==20||cnt==40||cnt==60||cnt==80) {
				bw.write("\n");
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
