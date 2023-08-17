package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class b1427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		ArrayList<Integer> list = new ArrayList<>();
		
		String[] str = br.readLine().split("");	
		for(int i=0;i<str.length;i++) {
			list.add(Integer.parseInt(str[i]));			
		}
		list.sort(Comparator.reverseOrder());
		for(int i=0;i<list.size();i++) {			
			bw.write(list.get(i)+"");
		}	
		bw.flush();
		br.close();
		bw.close();
	}

}
