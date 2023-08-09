package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class s1984 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i < tc + 1; i++) {
			list = new ArrayList<>();
			double sum = 0;
			for (int j = 0; j < 10; j++) {
				list.add(sc.nextInt());
			}
			list.sort(Comparator.naturalOrder());			
			list.remove(0);
			list.remove(8);
			for (int e : list) {
				sum += e;
			}
			double avg = Math.round(sum/list.size());
			System.out.println("#"+i+" "+(int)avg);
		}
	}
}
