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

}
