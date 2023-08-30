package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int min_res;
	static ArrayList<int[]> list;
	static ArrayList<int[]> list2;
	static ArrayList<int[]> list3;
	static ArrayList<Integer> remainNums;
	static ArrayList<Integer> num;
	static int[] select;
	static int[] sel;
	static int[] sel2;
	static int[] imsi;
	public static void comb(int a,int b) {
		if(b==n/2) {
			list.add(Arrays.copyOf(select, select.length));
			return;
		}
		if(a == n) {
			return;
		}
		select[b] = num.get(a);
		comb(a+1,b+1);
		comb(a+1,b);
	}
	public static void combination(int idx, int sidx) {		
		if (sidx == 2) {
			list2.add(Arrays.copyOf(sel, sel.length));
			return;
		}
		if (idx == n/2)
			return;		
		sel[sidx] = imsi[idx]; 
		combination(idx + 1, sidx + 1); 
		combination(idx + 1, sidx);

	}
	public static void combination2(int idx, int sidx) {		
		if (sidx == 2) {
			list3.add(Arrays.copyOf(sel2, sel2.length));
			return;
		}
		if (idx == n/2)
			return;		
		sel2[sidx] = remainNums.get(idx); 
		combination2(idx + 1, sidx + 1); 
		combination2(idx + 1, sidx);

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringTokenizer st;
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			n= Integer.parseInt(br.readLine());
			int[][]map=new int [n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			num=new ArrayList<>();
			for(int k=1;k<=n;k++) {
				num.add(k);
			}
			list=new ArrayList<int[]>();
			select = new int[n/2];
			sel = new int[n/2];
			sel2 = new int[n/2];
			comb(0,0);
			min_res=Integer.MAX_VALUE;
			for(int i=0;i<list.size();i++) {				
				imsi=list.get(i);
				num.clear();
				for(int j=1;j<=n;j++) {
					num.add(j);
				}			
				remainNums = new ArrayList<>(num);
				for (int j = 0; j < n/2; j++) {
				    remainNums.remove(Integer.valueOf(imsi[j]));
				}				
				list2=new ArrayList<int[]>();
				combination(0,0);
				list3=new ArrayList<int[]>();
				combination2(0,0);
				int sum1=0;
				int sum2=0;	
				
				for(int j=0;j<list2.size();j++) {
					sum1+=map[list2.get(j)[0]-1][list2.get(j)[1]-1]+map[list2.get(j)[1]-1][list2.get(j)[0]-1];
				}				
				for(int j=0;j<list3.size();j++) {
					sum2+=map[list3.get(j)[0]-1][list3.get(j)[1]-1]+map[list3.get(j)[1]-1][list3.get(j)[0]-1];
				}				
				int res = Math.abs(sum1-sum2);
				
				min_res = Math.min(res, min_res);		
			}
			bw.write("#"+tc+" "+min_res+"\n");			
			
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
