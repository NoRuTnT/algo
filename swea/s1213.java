package test.day5;

import java.util.Scanner;

public class s1213 {
	static String p;
	static String t;
	public static int bruteForceFor(String t, String p) {
		int n = t.length(); //문장
		int m = p.length(); //검색할문자열
		int total=0; //문자열반복횟수
		int cnt=0; //문자열확인카운트
		for(int i=0;i<n-m+1;i++) {
			cnt=0;
			for(int j=0;j<m;j++) {
				if(p.charAt(j) == t.charAt(i+j)){ //같은문자매칭
					cnt+=1;					
				}
				if(cnt==m) { //연속으로 문자열길이m만큼 누적되면 cnt초기화 total+1
					total++;
					cnt=0;	
				}
			}
					
		}
		if(total!=0) {
			return total;
		}	
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<11;tc++) {
			int num= sc.nextInt();
			p = sc.next();
			t = sc.next();
			int ans = bruteForceFor(t, p);
			System.out.printf("#%d %d\n",tc,ans);
		}		
	}
}
