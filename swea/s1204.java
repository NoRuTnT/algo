package test;

import java.util.Scanner;

public class s1204 {
	static int[] score = new int[101];
	static int[] student = new int[1000];
	static int idx;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i < tc + 1; i++) {
			int tc_num = sc.nextInt();
			student=new int [1000];
			score=new int [101];
			for (int j = 0; j < 1000; j++) {
				student[j] = sc.nextInt();
				score[student[j]]++;				
			}			
			max = 0;
			idx = 0;
			for (int k = 0; k < 101; k++) {
				if (score[k] >= max) {
					max = score[k];
					idx=k;					
				}
			}			
			System.out.printf("#%d %d\n",tc_num,idx);
		}
	}
}
