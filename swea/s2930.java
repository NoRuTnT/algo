package swea;

import java.util.Scanner;

public class s2930 {
	public static int[] heap = new int[100000];
	public static int heapSize = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			heap = new int[100];
			heapSize = 0;
			int num = sc.nextInt();
			System.out.print("#"+tc+" ");
			for(int i=0;i<num;i++) {
				int order = sc.nextInt();
				if(order==1) {
					int add = sc.nextInt();
					heapPush(add);
				} else {
					int res=heapPop();
					System.out.print(res+" ");
				}
			}
			System.out.println();
			
		}
		
	}
	
	public static void heapPush(int item) {
		heap[++heapSize] = item; // 마지막 자리에 삽입

		int ch = heapSize; // 자식
		int p = ch / 2; // 부모

		while (p > 0 && heap[ch] > heap[p]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			//부모 자식을 한레벨 위로 다시 결정
			ch = p;
			p = ch / 2;
		}
	}
	
	public static int heapPop() {
		if(heapSize <= 0) {
			return -1; 
		}
		
		int item = heap[1]; //루트노드
		heap[1] = heap[heapSize--]; //마지막 값을 루트에 덮어씌우기
		
		int p = 1;
		int ch = p * 2;
		//앞에 조건은 오자가 있다면~~
		if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
			ch += 1; //만약 오자가 더크면 오자로 변경 세팅
		
		//내려가 살수 있는 만큼 내려보내기 
		while(ch<=heapSize && heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;
			
			p = ch;
			ch = p * 2;
			
			if(ch + 1 <= heapSize && heap[ch] < heap[ch+1])
				ch += 1; //만약 오자가 더크면 오자로 변경 세팅
		}
		
		
		return item;
	}

}
