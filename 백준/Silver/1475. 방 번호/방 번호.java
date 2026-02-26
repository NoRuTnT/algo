import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] count = new int[10];
		for(int i=0;i<s.length();i++){
			int now = s.charAt(i)-'0';
			count[now] += 1;
		}
		
		int change = (count[6]+count[9]+1)/2;
		count[6] = change;
		count[9] = 0;
		int max = -1;
		for(int i=0;i<10;i++){
			max = Math.max(count[i],max);
		}
		System.out.println(max);
	}
}
