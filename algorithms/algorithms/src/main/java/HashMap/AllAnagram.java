package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AllAnagram {

    public void Anagram() throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        char [] a = br.readLine().toCharArray();
        char [] b = br.readLine().toCharArray();


        HashMap<Character,Integer> hash = new HashMap<>();
        HashMap<Character,Integer> hashb = new HashMap<>();
//        HashMap<Character,Integer> hashB = new HashMap<>();

        for(int rt = 0; rt < b.length; rt ++){
            hash.put(a[rt], hash.getOrDefault(a[rt],0) + 1);
            hashb.put(b[rt], hashb.getOrDefault(b[rt],0) + 1);
        }
        int ans = 0;
        int lt =0;
        for(int rt = b.length; rt < a.length  ; rt++){
            if(hash.equals(hashb) ) {
                ans ++;
            }
            hash.put(a[lt], hash.getOrDefault(a[lt],0) - 1);
            if(hash.get(a[lt]) == 0){
                hash.remove(a[lt]);
            }
            lt++;
            hash.put(a[rt], hash.getOrDefault(a[rt],0) + 1);

        }
        if(hash.equals(hashb) ) {
            ans ++;
        }
        System.out.println(ans);
    }
}
