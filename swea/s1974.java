package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class s1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] count = new int[9];
		int t = Integer.parseInt(br.readLine());
		boolean sudoku = true;
		for (int tc = 1; tc <= t; tc++) {
			sudoku = true;
			count = new int[9];
			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			loop: while (true) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						count[map[i][j]-1]++;
					}
					
					for (int k = 0; k < 9; k++) {
						if (count[k] >= 2) {
							sudoku = false;
							break loop;
						}
					}
					count = new int[9];
				}
				count = new int[9];
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						count[map[j][i]-1]++;
					}
					
					for (int k = 0; k < 9; k++) {
						if (count[k] >= 2) {
							sudoku = false;
							break loop;
						}
					}
					count = new int[9];
				}
				count = new int[9];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						for(int x =0;x<3;x++) {
							for(int y=0;y<3;y++) {
								count[map[x+(3*i)][y+(3*j)]-1]++;								
							}							
						}
						for (int k = 0; k < 9; k++) {
							if (count[k] >= 2) {
								sudoku = false;
								break loop;
							}
						}
						count = new int[9];
					}
					
					
				}
//				count = new int[9];
//				for (int i = 0; i < 9; i++) {
//					for (int j = 0; j < 9; j++) {
//						count[map[i % 3][3 * (j / 3) + j % 3]-1]++;
//					}
//					for (int k = 0; k < 9; k++) {
//						if (count[k] >= 2) {
//							sudoku = false;
//							break loop;
//						}
//					}
//					count = new int[9];
//				}
				break;

			}

			bw.write("#" + tc + " ");
			if (sudoku) {
				bw.write(1+"\n");				
			}else {
				bw.write(0+"\n");				
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
