package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ClassPresident {

    public void ClassPresident() throws IOException {
//        학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
//        투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
//        선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String voted = br.readLine();
        char [] arr = voted.toCharArray();
        int max = 0;
        String ans = "";
        HashMap<String, Integer> vote = new HashMap<String, Integer>();
        for(int i = 0 ; i < voted.length(); i++){
            vote.put(String.valueOf(arr[i]),0);
        }
        for(int i = 0; i< voted.length(); i++){

            int num = vote.get(String.valueOf(arr[i]))+1;
            vote.put(String.valueOf(arr[i]),num);

            if(max <= num){
                max = num;
                ans = String.valueOf(arr[i]);
            }
        }
        System.out.println(ans);
    }

}
