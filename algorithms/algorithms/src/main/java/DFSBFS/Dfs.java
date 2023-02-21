package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    int answer = 0;
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


}
