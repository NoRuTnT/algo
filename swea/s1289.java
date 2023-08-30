package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class s1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> list = new ArrayList<>();
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {			
			String[] str = br.readLine().split("");
			for(int i=0;i<str.length;i++) {
				list.add(Integer.parseInt(str[i]));
			}
			int cnt=0;			
			for(int i=1;i<list.size();i++) {
				if(list.get(i)==1) { //1만났을때
					if(list.get(i-1)==0) cnt++; //바로전이 0이면 카운트 +1
				}else { //0만났을때					
					if(list.get(i-1)==1) {
						if(cnt==0) {
							cnt++; // 처음카운트쌓을때 1후에 0을만나면 카운트+1추가
						}
						cnt++;	//바로전이 1이면 카운트 +1
					}
				}
			}
			bw.write("#"+tc+" "+cnt+"\n");
			list.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
