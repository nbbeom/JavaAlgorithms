package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.util.StringTokenizer;

public class SellRecord {

    public void sellRecord() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str= br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String sell = br.readLine();
        String [] arr = sell.split(" ");

        HashMap<String, Integer> hs = new HashMap<>();
        for(int i= 0; i<k-1; i++){
            hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> ar =new ArrayList<>();
        int lt =0;
        for (int rt  =k-1 ; rt< n ; rt++){
            hs.put(arr[rt], hs.getOrDefault(arr[rt],0)+1);
            ar.add(hs.size());
            hs.put(arr[lt],hs.get(arr[lt])-1);
            if(hs.get(arr[lt])==0){
                hs.remove(arr[lt]);
            }
            lt++;
        }
        for(int a:ar)
            System.out.print(a + " ");




    }
}
