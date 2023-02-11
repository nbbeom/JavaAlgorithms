package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

}
