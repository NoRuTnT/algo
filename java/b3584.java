package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class b3584 {
    static StringTokenizer st;
    static boolean[] visit;
    static int[] parent;
    static int y;
    static int count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void find(int x,int y) throws IOException {
        while(x>0) {
            visit[x]=true;  //start1정점부터 root까지 경로체크
            x=parent[x];
        }
        while(y>0) {     //start2정점부터 root까지 올라가다가 
            if(visit[y]) {  //start1이 지나간곳만나면 출력후 break;
                bw.write(y+"\n");
                break;
            }
            y=parent[y];
        }
        
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {      
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점의개수            
            parent = new int[v+1]; //각노드의 부모노드 저장용
            visit = new boolean[v+1]; //지나간곳저장용
            ArrayList<ArrayList<Integer>> child = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                child.add(new ArrayList<>()); //각 정점마다 자식 노드들을 저장하는 리스트의리스트
            } 
            for(int i=0;i<v-1;i++) { 
            	st= new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); //부모정점입력
                int y = Integer.parseInt(st.nextToken()); //자식정점입력
                parent[y]=x; //parent배열에 저장
                child.get(x).add(y); //child 배열에 저장                 
            }
            st= new StringTokenizer(br.readLine());
            int start1 = Integer.parseInt(st.nextToken()); //시작1
            int start2 = Integer.parseInt(st.nextToken()); //시작2
            find(start1,start2);         
                      
        }
        bw.flush();
        br.close();
        bw.close();
    }
 
}