package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class s1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());		
			String[] str = br.readLine().trim().split(" ");
			LinkedList<String> list = new LinkedList<>(Arrays.asList(str));
			int order_num = Integer.parseInt(br.readLine());
			String[] order = br.readLine().trim().split("I");
			for (int i = 1; i <= order_num; i++) {
				String[] str1 = order[i].trim().split(" ");
				int location = Integer.parseInt(str1[0]);
				int num = Integer.parseInt(str1[1]);
				for (int j = 2; j <= num + 1; j++) {
					list.add(location + j - 2, str1[j]);
				}
			}
			bw.write("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				bw.write(list.get(i) + " ");
			}
			bw.write("\n");			

		}
		bw.flush();
		br.close();
		bw.close();
	}

}
