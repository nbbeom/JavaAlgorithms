package DFSBFS;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdjacencyMatrix {
    static int [][] matrix;
    static int [] ch;
    static int edge;

    static ArrayList<ArrayList<Integer>> graph;
    static int answer = 0;
    public static void AdjacencyMatrix() throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertax = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        matrix = new int[edge+1][edge+1];
        ch = new int[edge+1];

        for(int i = 0; i < vertax; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            matrix[a][b] = 1;
        }
        ch[1] = 1; //출발점 chk
        dfs(1);
    }
    public static void dfs(int v){
        if(v == edge) answer ++;
        else{
            for(int i=0; i<=edge; i++){
                if(matrix[v][i] == 1 && ch[i] ==0){
                    ch[i] =1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }
    //인접행렬로 하면 큰 데이터로 할때 메모리 로스가 심함
    //인접 리스트로 하는 방법
    public static void AdjacencyList() throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertax = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        ch = new int[edge+1];
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
        dfs2(1);
        System.out.println(answer);
    }
    public static void dfs2(int v){
        if(v == edge) answer ++;
        else{
            for(int nv : graph.get(v)){
                if(ch[nv] ==0){
                    ch[nv] = 1;
                    dfs2(nv);
                    ch[nv] = 0;
                }
            }
        }
    }


}
