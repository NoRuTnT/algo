package test.day5;

import java.util.Scanner;

public class s1989 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=1;tc<t+1;tc++) {
			String word=sc.next();
			int num=1;
			for(int i=0;i<word.length()/2;i++) {
				if(word.charAt(i)!= word.charAt(word.length()-i-1)) {
					num=0;
					break;
				}
			}
			System.out.printf("#%d %d\n",tc,num);
		}
	}
		
		
}
