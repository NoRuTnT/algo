package test;

import java.util.Scanner;

public class s1210 {
	static int[][] map = new int[102][102];
	static int[] loc = new int[2];

	public static void move_ladder() {
		//����������
		if (map[loc[0]][loc[1] + 1] == 1) {
			while (map[loc[0]][loc[1] + 1] != 0) {
				loc[1]++;
			}
		//��������
		} else if (map[loc[0]][loc[1]-1] == 1) {
			while (map[loc[0]][loc[1]-1] != 0) {
				loc[1]--;
			}
		}
		//���οö󰡱�
		if (map[loc[0]][loc[1]] == 1) {
			loc[0]--;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		// �׽�Ʈ���̽�
		for (int tc = 1; tc <= 10; tc++) {
			//100x100���� �ֺ��� 0���ε� �����߰�
			map = new int[102][102];
			loc = new int[2];
			// �����׸���
			int n = sc.nextInt();
			for (int i = 1; i < 101; i++) {
				for (int j = 1; j < 101; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//������ġã��
			for (int i = 1; i < 101; i++) {
				if (map[100][i] == 2) {
					loc[0] = 99;
					loc[1] = i;					
				}
			}
			//��ٸ�Ÿ��
			while (loc[0] != 1) {				
				move_ladder();				
			}
			//x��ã��
			int result = loc[1] - 1;
			System.out.printf("#%d %d\n",n,result);
		}
	}
}
