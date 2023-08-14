package test.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s11315 {
	static int direction[][] = {{0,1},{1,1},{1,0},{-1,1}};
	static String[][] map;
	static String[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		//�Է°���
		int t = Integer.parseInt(br.readLine());
		loop: for(int tc =1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new String [n][n];
			arr= new String[n];
			for (int i = 0; i < n; i++) {
                arr = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    map[i][j] = arr[j];
                }
            }
			//Ž��
			for(int nr=0;nr<n;nr++) {
				int cnt=0;				
				 for(int nc=0;nc<n;nc++) {
					 //o��ã����
					if(map[nr][nc].equals("o")) {
						//4�������� Ž��
						for(int[] dir:direction) {
							int x=nr;
							int y=nc;
							cnt=0;
							while(y>=0 && x>=0 && y<n && x<n) {	
								//o�� ������ cnt+1 �ٸ����������� cnt�ʱ�ȭ
								if(map[x][y].equals("o")) {
									cnt++;
								} else {
									cnt=0;
								}
								//cnt��5���׿������ YES����ϰ� ó��for������ ���ư��� ����tc����
								if(cnt==5) {
									bw.write("#"+tc+" YES\n");
									continue loop;
								}
								//������������ ����
								x += dir[0];
								y += dir[1];
							}
							
						}
					
					}
				
				}
				 
			}
			bw.write("#"+tc+" NO\n");	
			
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}

}
