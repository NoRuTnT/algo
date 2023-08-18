package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class s1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> queue = new LinkedList<>(); //queue����
		for(int tc=1;tc<=10;tc++) {  //testcase 10��
			int t = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(String e:str) {
				queue.add(Integer.parseInt(e)); 	
			}
			loop : while(true) {  //break�ɋ����� ���ѹݺ�
				for(int i=1;i<=5;i++) {  
					int num = queue.poll();	 //queue front�� �����ϳ��������� i������ �ٽ��߰�		
					if(num-i<=0) {   //�׷��� ���ڿ���i���Q���� 0���� �۾����� 0���߰��ϰ� break
						queue.add(0);
						break loop;
					}
					queue.add(num-i);//i�����ش��� queue�� �ٽ��߰�
				}
			}
			bw.write("#"+tc+" ");
			for(int i=0;i<8;i++) {
				bw.write(queue.poll()+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
