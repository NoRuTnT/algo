package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class s2063 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			list.add(sc.nextInt());
		}
		list.sort(Comparator.naturalOrder());
		int result = list.get(t/2);
		System.out.println(result);
	}

}
