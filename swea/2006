package com.ssafy.ws.step3;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		int game_count = 0;
		int win_count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("가위바위보 게임을 시작합니다. 아래 보기중 하나를 고르세요: \n"
				+ "1.5판3승\n"
				+ "2.3판2승\n"
				+ "3.1판1승\n");
		int game = sc.nextInt();
		if (game==1) {
			game_count=5;
			win_count=3;
		} else if (game==2) {
			game_count=3;
			win_count=2;
		} else {
			game_count=1;
			win_count=1;
		}	
		int com_win=0;
		int me_win=0;
		int count=0;
		int com=(int)(Math.random()*3)+1;
		while (count!=game_count) {
			Scanner sc2 = new Scanner(System.in);
			System.out.print("번호를 입력하세요 : ");
			int me = sc2.nextInt();
			if ((com==1&&me==3)||(com==2&&me==1)||(com==3&&me==2)) {
				System.out.println("졌습니다!!");
				count++;
				com_win++;			
			} else if (com==me) {
				System.out.println("비겼습니다");
				count++;
			} else {
				System.out.println("이겼습니다!!");
				count++;
				me_win++;
			}
			if (com_win==win_count) {
				System.out.println("### 컴퓨터 승!!!");
				break;
			} else if (me_win==win_count) {
				System.out.println("### 플레이어 승!!!");
				break;
			}
			
		}
		
	}
	
	
	
	

}
