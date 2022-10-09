package Arrayss;

import java.util.ArrayList;

public class BigNumber {
//    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
//    (첫 번째 수는 무조건 출력한다)


    public ArrayList<Integer> BigNumbers(){
        int a = 0;

        int n = 3;
        int [] arr = new int [n];
        arr[0] = 3;
        arr[1] = 4;
        arr[2] = 1;
//        Scanner sc = new Scanner(System.in);
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = sc.nextInt();
//        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for( int i = 1 ; i < n; i++){
            if(arr[i]>arr[i-1])
                ans.add(arr[i]);
        }

        return ans;

    }



}
