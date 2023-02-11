package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    int ans = 0;
    static int [] dis = {1, -1, 5};// 1회 -1회 5회 이동
    static int [] ch ; // 한번 방문한곳은 다시 가지 않음
    static Queue<Integer> Q = new LinkedList<>();
    public static int Bfs(int s, int e){
        ch = new int [10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size(); // 레벨 사이즈 체크
            for(int i =0; i<len; i++){
                int x = Q.poll();
                for(int y : dis){
                    int nx = x+y;
                    if(nx==e) return L+1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
         L++;
        }
        return L;
    }
    public static void littelCow(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        System.out.println(Bfs(input1,input2));
        return ;
    }



}
