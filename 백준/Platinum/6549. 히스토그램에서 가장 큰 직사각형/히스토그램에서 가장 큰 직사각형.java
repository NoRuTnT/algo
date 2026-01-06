import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr,tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) {
				break;
			}
			arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}

			tree = new int[4*n];
			maketree(0,n-1,0);
			sb.append(maxarea(0,n-1)).append("\n");
		}
		System.out.println(sb);

	}
	private static int maketree(int start, int end, int node) {
		if(start == end) {
			return tree[node] = start;

		}
		int mid = (start+end)/2;
		int left = maketree(start,mid,node*2+1);
		int right = maketree(mid+1,end,node*2+2);

		if(arr[left]<arr[right]) {
			return tree[node]=left;
		}else {
			return tree[node]=right;
		}
	}

	private static long maxarea(int left, int right) {
		int index = minheight(0,n-1,left,right,0);
		//        System.out.println(index+" "+left+" "+right);
		long area = (long)(right-left+1) * arr[index];
		long tmp=0;
		if(left<index) {
			tmp=maxarea(left,index-1);
			if(area<tmp) {
				area=tmp;
			}
		}
		if(index<right){
			tmp=maxarea(index+1,right);
			if(area<tmp) {
				area=tmp;
			}
		}
		return area;

	}

	private static int minheight(int start, int end, int left, int right, int node) {
		if(right<start || left>end) {
			return -1;
		}
		if(left<=start && end<=right) {
			return tree[node];
		}

		int m = (start+end)/2;
		int l = minheight(start,m,left,right,node*2+1);
		int r = minheight(m+1,end,left,right,node*2+2);

		if(l==-1) {
			return r;
		}else if(r==-1) {
			return l;
		}else {
			if(arr[l]<arr[r]) {
				return l;
			}else {
				return r;
			}
		}
	}

}
