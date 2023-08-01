package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class b10773 {
	public static void main(String[] args) {
		int a;
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for(int i=0;i<k;i++) {
			a = sc.nextInt();
			if(a!=0) {
				list.add(a);				
			}else {
				if(!(list.isEmpty())){
					list.remove(list.size()-1);
				}
			}
		}
		int sum=0;
		for(int e:list) {
			sum+=e;
		}
		System.out.println(sum);
		
	}

}
