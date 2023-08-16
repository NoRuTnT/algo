package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class s8931 {
	public static void main(String[] args) {
		int a;
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<t+1;tc++) { //테스트케이스
			int k = sc.nextInt();
			list.clear();			
			for(int i=0;i<k;i++) {
				a = sc.nextInt();
				if(a!=0) {  //0이아니면
					list.add(a);	 //리스트에 추가			
				}else {
					if(!(list.isEmpty())){ //0일때 리스트가 비어있지않으면
						list.remove(list.size()-1); //리스트마지막원소를 제거
					}
				}
			}
			Long sum=(long) 0;
			for(int e:list) {
				sum+=e;
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
		
		
	}

}
