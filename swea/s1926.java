package swea;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class s1926 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			boolean check = true;
			String a = Integer.toString(i);
			for(int j=0;j<a.length();j++) {
				if(a.charAt(j)=='3') {
					bw.write("-");
					check=false;
				}
				if(a.charAt(j)=='6') {
					bw.write("-");
					check=false;
				}
				if(a.charAt(j)=='9') {
					bw.write("-");
					check=false;
				}
			}			
			if(check) {
				bw.write(a);
			}
			bw.write(" ");					
			
		}
		bw.flush();
		bw.close();
	}

}
