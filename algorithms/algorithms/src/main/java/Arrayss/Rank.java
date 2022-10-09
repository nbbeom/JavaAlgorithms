package Arrayss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Rank {

    public void Rank(){
//        N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
//        같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
//        즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

//        5
//        87 89 92 100 76
//        4 3 2 1 5
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        Integer [] input2 = new Integer[input1];
        int [] temp2 = new int[input1];

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<input1; i++){
            input2[i] = sc.nextInt();
            temp2[i] = input2[i];
        }
        Arrays.sort(input2, Collections.reverseOrder());

        for(int i =0 ; i<input1; i++){
            ans.add(input2[i]);
        }

        for (int i = 0 ; i <input1; i++){
            System.out.println(ans.indexOf(temp2[i])+1 );
        }


    }
}
