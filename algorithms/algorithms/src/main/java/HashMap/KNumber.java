package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KNumber {

    public void KNumber() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(n);
        n = st.nextToken();
        String k = st.nextToken();

        String []arr = br.readLine().split(" ");

        TreeSet<Integer>hs = new TreeSet<>(Comparator.reverseOrder());

        for(int i = 0; i< Integer.parseInt(n) ; i++){
            for (int j = i+1; j < Integer.parseInt(n) ; j++){
                for(int l = j+1; (l < Integer.parseInt(n) ); l++){
                    hs.add(Integer.parseInt(arr[i]) + Integer.parseInt(arr[j]) + Integer.parseInt(arr[l]));
                }
            }
        }
        int cnt = 0;
        for(int x : hs){
            cnt ++;
            if(cnt == Integer.parseInt(k)){
                System.out.println(x);
                return;
            }
        }

        System.out.println(-1);


    }
}
