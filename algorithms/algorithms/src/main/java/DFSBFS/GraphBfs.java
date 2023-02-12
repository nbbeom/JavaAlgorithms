package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GraphBfs {
    static int [] ch, dis;
    static int edge;
    static ArrayList<ArrayList<Integer>> graph;

    public static void GraphBfs() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertax = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        ch = new int[edge+1];
        dis = new int[edge+1];
        graph = new ArrayList<ArrayList<Integer>>();

        for(int i =0; i<= edge; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < vertax; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
        }
        ch[1] = 1;
        bfs(1);

        for(int i =2; i<= edge; i++){
            System.out.println( i + " : "+dis[i]);
        }

    }
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.offer(v);
        while(!q.isEmpty()){
            int cv = q.poll();//현재지점
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }

    }

}
