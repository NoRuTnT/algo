package test.day5;

import java.util.Scanner;

public class s1213 {
	static String p;
	static String t;
	public static int bruteForceFor(String t, String p) {
		int n = t.length(); //����
		int m = p.length(); //�˻��ҹ��ڿ�
		int total=0; //���ڿ��ݺ�Ƚ��
		int cnt=0; //���ڿ�Ȯ��ī��Ʈ
		for(int i=0;i<n-m+1;i++) {
			cnt=0;
			for(int j=0;j<m;j++) {
				if(p.charAt(j) == t.charAt(i+j)){ //�������ڸ�Ī
					cnt+=1;					
				}
				if(cnt==m) { //�������� ���ڿ�����m��ŭ �����Ǹ� cnt�ʱ�ȭ total+1
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
