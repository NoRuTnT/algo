package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5099 {
	public static int[] queue; 
	public static int size;
	public static int front = 0, rear = 0; 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			queue = new int[n];
			size = n;
			front = 0;
			rear = 0;
			int i=0;
			String[] ci = br.readLine().split(" ");
			int num=0;
			while(num<m) {
				enQueue(Integer.parseInt(ci[i]));
				num=i;
				i++;
				if(isFull()) {
					while(isFull()) {
						queue[front]/=2;
						int a = queue[front];
						deQueue();
						if(a!=0) {
							enQueue(a);
						}
					}
				}else {
					while(!isEmpty()) {
						queue[front]/=2;
						int a = queue[front];
						deQueue();
						if(a!=0) {
							enQueue(a);
						}
				}
				
			}
			
			}
			
		}
		
	}

	public static boolean isEmpty() {
		return front == rear;
	}

	
	public static boolean isFull() {
		return (rear + 1) % size == front;
	}

	// 삽입 : boolean / 자료형 / void
	public static void enQueue(int item) {		
		if (isFull()) {
			System.out.println("가득 차서 더 이상 넣을 수 없다!");
			return;
		}
		
		queue[(++rear) % size] = item;
	}
	
	public static int deQueue() {		
		if (isEmpty()) {
			System.out.println("공백상태 입니다.");
			return 0;
		}
		return queue[(++front) % size];
	}

}
