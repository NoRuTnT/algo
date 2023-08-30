package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1248 {
	static StringTokenizer st;
	static boolean[] visit;
	static int[] parent;
	static int y;
	static int count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int find(int x,int y) throws IOException {
		while(x>0) {
			visit[x]=true;  //start1정점부터 root까지 경로체크
			x=parent[x];
		}
		while(y>0) {		//start2정점부터 root까지 올라가다가 
			if(visit[y]) {	//start1이 지나간곳만나면 출력후 break;
				bw.write(y+" ");
				break;
			}
			y=parent[y];
		}
		return y;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 정점의개수
			int e = Integer.parseInt(st.nextToken()); // 간선의 개수
			int start1 = Integer.parseInt(st.nextToken()); //시작1
			int start2 = Integer.parseInt(st.nextToken()); //시작2
			parent = new int[v+1]; //각노드의 부모노드 저장용
			visit = new boolean[v+1]; //지나간곳저장용
			ArrayList<ArrayList<Integer>> child = new ArrayList<>();
			for (int i = 0; i <= v; i++) {
				child.add(new ArrayList<>()); //각 정점마다 자식 노드들을 저장하는 리스트의리스트
			}
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<e;i++) {				
				int x = Integer.parseInt(st.nextToken()); //부모정점입력
				int y = Integer.parseInt(st.nextToken()); //자식정점입력
				parent[y]=x; //parent배열에 저장
				child.get(x).add(y); //child 배열에 저장
				
			}
			bw.write("#"+tc+" ");
			y=find(start1,start2);
			
			//최소공통조상 찾은후에 그곳으로부터 부분트리 갯수세기
			count = 1; //최소공통조상노드에서 시작해서 기본값을 1로설정
			Queue<Integer> q = new LinkedList<>();
			q.add(y); //queue에 최소공통조상노드추가
			while(!q.isEmpty()) {
				int now = q.poll();	//큐에서빼낸뒤에	
				for (int i = 0; i < child.get(now).size(); i++) {
					q.add(child.get(now).get(i)); //노드의 자식을 모두 큐에추가
					count++;
				}
			}
			bw.write(count+"\n");			
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
