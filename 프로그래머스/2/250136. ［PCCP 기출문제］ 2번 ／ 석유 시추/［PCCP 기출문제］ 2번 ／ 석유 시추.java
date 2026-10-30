import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        int answer = 0;        
        int n = land.length;
        int m = land[0].length;     
        int[] total = new int [m];
        boolean[][] check = new boolean[n][m];    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1 && !check[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    int minc=j;
                    int maxc=j;
                    int cnt=1;                    
                    check[i][j]=true;                    
                    q.offer(new int[]{i,j});  
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        for(int d=0;d<4;d++){
                            int nowr=r+dr[d];
                            int nowc=c+dc[d];
                            if(nowr<n && nowr >=0 && nowc<m && nowc >=0 && land[nowr][nowc]==1 && !check[nowr][nowc]){
                                q.offer(new int[]{nowr,nowc});
                                check[nowr][nowc]=true;
                                cnt++;
                                if(nowc>maxc){
                                    maxc=nowc;
                                }
                                if(nowc<minc){
                                    minc=nowc;
                                }                                
                            }
                        }
                    }
                    
                    for(int a=minc;a<=maxc;a++){
                        total[a]+=cnt;
                    }                    
                    
                }
            }
        }
        for(int i=0;i<m;i++){
            if(answer < total[i]){
                answer = total[i];                
            }
            
        }
        
        
        return answer;
    }
}