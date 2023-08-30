package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class s6190 {
	static int danzo(String str) {
		String[] num_str = str.split(" ");
		int len = num_str.length;
		int[] num = new int [len];		
		for(int i=0;i<len;i++) {			
			num[i] = Integer.parseInt(num_str[i]);
		}
		int max =-1;
		int cnt=0;		
		for(int i=0;i<len-1;i++) {
			for(int j=i+1;j<len;j++) {				
				int dup = num[i] * num[j];
				if (dup <= max) {
                    continue; 
                }
				String[] dup_str = Integer.toString(dup).split("");
				int len2 = dup_str.length;
				int[] num2 = new int [len];		
				for(int k=0;k<len2;k++) {			
					num2[k] = Integer.parseInt(dup_str[k]);
				}					
				for(int k=0;k<len2-1;k++) {
					if(num2[k]<=num2[k+1]) {
						cnt++;
					}
				}
				if(cnt==len2-1) {
					max = Math.max(dup, max);					
				}					
				cnt=0;							
			}			
		}
		if(max==0) return -1;		
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());			
			String word = br.readLine();
			int res = danzo(word);
			bw.write("#"+tc+" "+res+"\n");
		}
		bw.flush();
		bw.close();
		br.close();		
	}

}
