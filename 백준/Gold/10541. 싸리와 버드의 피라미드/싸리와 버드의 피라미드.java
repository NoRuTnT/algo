import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		long N = Long.parseLong(br.readLine());
		String s = br.readLine();
		int len = s.length();
		long[] cnt = new long[26];
		long[][] sum = new long[len+1][26];
		
		for(char c:s.toCharArray()) {
			cnt[c-'A']++;
		}		
		
        for(int i=0;i<len;i++) {
            for(int j=0;j<26;j++) {
            	sum[i+1][j] = sum[i][j];
            }
            sum[i+1][s.charAt(i)-'A']++;
        }		
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			int c = st.nextToken().charAt(0)-'A';			
			long half;
            if(a%2==0) {
                half = (a/2%len)*((a-1)%len)%len;
            }else {
                half = (a%len)*(((a-1)/2)%len)%len;
            }
            int index = (int) half;
			int remain = (int)(a%len);
			long ans = cnt[c] * (a/len);
			
			if(index+remain<=len) {		
				ans += sum[index+remain][c]-sum[index][c];
			}else {
				ans += sum[len][c]-sum[index][c];
				ans += sum[(index+remain)%len][c];
			}
			
			sb.append(ans).append("\n");			
		}
		System.out.println(sb);
	}	

}
