package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class b1920 {
	static ArrayList<Integer> list = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	
	private static boolean binarySearch(int num) {
        int leftIndex = 0;
        int rightIndex = n - 1;

        while(leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = list.get(midIndex);
            if(num < mid) rightIndex = midIndex - 1;
            else if(num > mid) leftIndex = midIndex + 1;
            else return true;
        }
        return false;
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		
		n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		for(int i =0; i<n; i++) {
			list.add(Integer.parseInt(arr[i]));
		}
		list.sort(Comparator.naturalOrder());
		m = Integer.parseInt(br.readLine());
		String[] arr2 = br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			if(binarySearch(Integer.parseInt(arr2[i]))) {
				bw.write(1+"\n");
			} else {
				bw.write(0+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();		
	}
	
}
