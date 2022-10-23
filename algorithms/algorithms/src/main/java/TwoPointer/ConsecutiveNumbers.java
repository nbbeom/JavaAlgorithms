package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsecutiveNumbers {

    public void consencutiveNumbers() throws IOException {

//        N
//        입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
//        만약 N=15이면
//        7+8=15
//        4+5+6=15
//        1+2+3+4+5=15
//        와 같이 총 3가지의 경우가 존재한다.
//        입력
//        첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
//        출력
//        첫 줄에 총 경우수를 출력합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0,ans = 0;
        int p1 = 1,p2 =2;

//        sum = p1 + p2;
//
//        while(p1 < n/2+1){
//            if(sum > n){
//                p1++;
//                p2 = p1+1;
//                sum = p1+p2;
//            }else if(sum == n){
//                ans++;
//                p1++;
//                p2 = p1+1;
//                sum = p1+p2;
//            }else{
//                p2++;
//                sum += p2;
//            }
//        }

        //수학적 방법
        n--;
        int cnt =0;
        while(n>0){
            cnt++;
            n= n-cnt;
            if(n%cnt == 0 ) ans ++;
        }


        System.out.println(ans);
    }
}
