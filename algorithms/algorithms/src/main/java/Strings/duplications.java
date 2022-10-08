package Strings;

import java.util.Scanner;

public class duplications {
    public static String sol(String str){
        String ans = "";

//        6. 중복문자제거
//        설명
//        소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
//        중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
        for (int i =0 ; i <str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i ){
                System.out.print(str.charAt(i));

            }
        }
        return ans;
    }

}
