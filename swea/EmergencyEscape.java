package practice;

import java.util.Scanner;

public class EmergencyEscape {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] speed = new int [n];
		int[] height = new int [n];
		int Mintime = 1000;
		for (int i=0; i<n;i++) {
			speed[i] = sc.nextInt();
		}
		for (int i=0; i<n;i++) {
			height[i] = sc.nextInt();
		}
		for (int i=4; i<n; i++) {
			if ((speed[i-4]+speed[i-3]+speed[i-2]+speed[i-1])/4>=900 && (((height[i-4]-height[i])>=4000)||((height[i-3]-height[i])>=4000)||((height[i-2]-height[i])>=4000)||((height[i-1]-height[i])>=4000))){
				Mintime = Math.min(Mintime, i+1);
			}			
		}
		for (int i=3; i<n; i++) {
			if((speed[i-3]+speed[i-2]+speed[i-1])/3>=1000 && (((height[i-3]-height[i])>=3000)||((height[i-2]-height[i])>=3000)||((height[i-1]-height[i])>=3000))) {
				Mintime = Math.min(Mintime, i+1);
			}
		}
		for (int i=2; i<n; i++) {
			if((speed[i-2]+speed[i-1])/2>=1100 && ((height[i-2]-height[i])>=2000)||((height[i-1]-height[i])>=2000)) {
				Mintime = Math.min(Mintime, i+1);
			}			
		}
		if (Mintime==1000) {
			System.out.println(-1);
		}else {
			System.out.println(Mintime);
		}
	}

}

