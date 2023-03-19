package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Dfs {
    static int n;
    static int [] ch;
    public void Subset() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        n = a;
        ch = new int[n+1];

        SubsetDfs(n);

    }
    public void SubsetDfs(int i){
        if(i == n+1){
            String tmp = "";
            for(int ii=1; ii<=n; ii++){
                if(ch[i] == 1) tmp += i +" ";
            }if(tmp.length()>0) System.out.println(tmp);
        }else{
            ch[i] = 1;
            SubsetDfs(i+1);
            ch[i] = 0;
            SubsetDfs(i+1);
        }
    }
    int sum = 0;
    int [] arr;
    String s = "No";
    public void SameSumSubset() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        arr =new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        dfs(0,0);
        System.out.println(s);
    }
    public void dfs(int l, int ans){
        if(sum - ans == ans){
            s = "Yes";
            return;
        }else{
            if(l < arr.length) {
                dfs(l + 1, ans + arr[l]);
                dfs(l + 1, ans);
            }
        }
    }


    int N = 0;
    int C = 0;
    int [] ans;
    public void Dog() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        ans = new int[N+1];
        arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs2(0,0);
        System.out.println(answer);

    }
    static int answer = 0;
    public void dfs2(int l ,int w){
        if(w >= C){
            return;
        } else if (l == N) {
            answer = Math.max(answer,w);
        } else {
            dfs2(l+1,w + arr[l]);
            dfs2(l+1, w);
        }
    }

    int tt [];
    int ts [];
    int m;
    public void MaximumScore() throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        ts = new int[n];
        tt = new int[n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            ts[i] = Integer.parseInt(st.nextToken());
            tt[i] = Integer.parseInt(st.nextToken());
        }

        dfs3(0,0,0);
        System.out.println(answer);
    }


    public void dfs3 (int l , int ScoreSum , int TimeSum){
        if(m < TimeSum){
            return;
        } else if (l == n) {
            answer = Math.max(answer,ScoreSum);
        }else{
            dfs3(l+1 , ScoreSum + ts[l] , TimeSum + tt[l]);
            dfs3(l+1 , ScoreSum , TimeSum);
        }
    }


    public void PerbutationOfRepetition() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrs = new int[m];

        
        porDfs(0);
    }

    int [] arrs;
    public void porDfs(int l){
        if (l == m) {
            for(int i = 0; i < m; i++){
                System.out.print(arrs[i]+ " ");
            }
            return;
        } else{
            int i = 0;
            for (i =0 ; i < n; i++){
                arrs[l] = i+1;
                porDfs( l+1 );
            }
        }
    }
    int [] coins ;
    int cnt;
    public void coinChange() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        coins = new int[n];
        cnt = 0;
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        coinDfs(0,0);
        System.out.println(answer);
    }

    public void coinDfs(int l , int sum){
        if (sum > m ) {
            return;
        } else if (sum == m) {
            if(answer == 0){
                answer = l;
            }
            answer =  Math.min(answer, l);
        } else{
            int i = 0;
            for (i =0 ; i < n; i++){
                cnt ++;
                coinDfs( l+1 ,sum+ coins[i]);
            }
        }
    }

    static int r = 0;
    static int [][] com;
    public void combination() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        com = new int[n+1][r+1];
        ;
        System.out.println(combinationDfs(n,r));
    }
    public static int combinationDfs(int n,int r) {
        if(com[n][r]>0){
            return com[n][r];
        }
        if(n==r || r ==0) return com[n][r] = 1;
        else return com[n][r] = combinationDfs(n-1,r-1) + combinationDfs(n-1,r);
    }

    static int []combi ;
    public void combination2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        combi = new int[r];

        combinationDfs2(n,r);
    }
    public static void combinationDfs2(int l,int s) {
        if(l == r){
            for(int x : combi) System.out.println(x +" ");
            System.out.println();
        }else{
            for (int i = 0; i< n; i++){
                combi[l] = i;
                combinationDfs2(l+1, i+1);
            }
        }

    }


    static int [] b ;
    static int [] p  ;
    static int finalNum;
    static boolean flag;
    public void combination3() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        finalNum = Integer.parseInt(st.nextToken());

        b = new int[n];
        p = new int[m];
        com = new int[n+1][n+1];
        ch = new int[n+1];

        for(int i = 0 ; i < n; i++){
           b[i] = combinationDfss(n-1,i);
        }
        combinationDfs3(0,0);
    }
    public static int combinationDfss(int n,int r) {
        if(com[n][r]>0){
            return com[n][r];
        }
        if(n==r || r ==0) return com[n][r] = 1;
        else return com[n][r] = combinationDfss(n-1,r-1) + combinationDfss(n-1,r);
    }

    public static void combinationDfs3(int l,int sum) {
        if(flag)return;
        if(l == n){
            if(sum == finalNum){
                for(int x : p) System.out.print(x +" ");
                flag = true;
            }
        }else{
            for (int i = 1; i< n; i++){
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    combinationDfs3(l + 1, (p[l]*b[l])+sum);
                    ch[i] = 0;
                }
            }
        }

    }


    static int [][] miro ;
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    public void miro() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        miro = new int[7][7];
        answer = 0;
        for(int i =0; i <7; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++){
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        miro[0][0] = 1;
        mirodfs(0,0);
        System.out.println(answer);

    }


    public static void mirodfs(int x , int y){
        if(x == 6 && y ==6){
            answer ++;
        }else {
            for(int i =0 ; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx >= 0 && nx<=6 && ny >=0 &&ny <=6 && miro[nx][ny] == 0){
                    miro[nx][ny] = 1;
                    mirodfs(nx,ny);
                    miro[nx][ny] = 0;
                }

            }

        }
    }

    static int mm ;
    static int nn;
    static int [][]dis;
    static Queue<Point> Q = new LinkedList<>();
    public void tomato() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        nn = Integer.parseInt(s.nextToken());
        mm = Integer.parseInt(s.nextToken());
        miro = new int[mm][nn];
        dis= new int[mm][nn];
        answer = 0;
        for(int i =0; i <mm; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nn; j++){
                dis[i][j] =0;
                miro[i][j] = Integer.parseInt(st.nextToken());
                if(miro[i][j] == 1) Q.offer(new Point(i,j));
            }
        }

        miro[0][0] = 1;
        tomatoDfs(0,0);
        boolean flag = true;
        for(int i =0; i<n; i++){
            for (int j=0 ; j<n; j++){
                if(miro[i][j] ==0) flag =false;
            }
        }
        answer = 0;
        if(flag){
            for(int i =0; i<n; i++){
                for (int j=0 ; j<n; j++){
                answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }else System.out.println("-1");

    }


    public void tomatoDfs(int x, int y){
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i =0; i< 4 ; i++){
                int nx =tmp.x + dx[i];
                int ny =tmp.y + dy[i];
                if(nx>=0 && nx<nn &&ny>=0 && ny<nn && miro[nx][ny] == 0){
                    miro[nx][ny] = 1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void island() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        nn = Integer.parseInt(s.nextToken());
        miro = new int[nn][nn];
        answer = 0;
        for(int i =0; i <nn; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nn; j++){
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i <nn; i++){
            for (int j = 0; j < nn; j++){
                if(miro[i][j] == 1){
                    answer ++;
                    miro[i][j] = 0;
                    System.out.println(i +" "+ j);
                    islandDfs(i,j);
                    System.out.println("-----------------------------------");
                }
            }
        }
        System.out.println(answer);

    }
    static int[] dx2 ={-1,-1,0,1,1,1,0,-1};
    static int[] dy2 ={0,1,1,1,0,-1,-1,-1};
    public static void islandDfs(int x, int y){
        for (int i = 0; i < dx2.length; i++){
            int nx = x + dx2[i];
            int ny = y + dy2[i];

            if(nx >= 0 && nx < nn && ny >= 0 && ny < nn ){
                if(miro[nx][ny] == 1){
                    miro[nx][ny] = 0;
                    System.out.println(nx+" "+ny);
                    islandDfs(nx,ny);
                }

            }

        }


    }
}
