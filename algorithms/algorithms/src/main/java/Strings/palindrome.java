package Strings;

public class palindrome {
    public void sol(){

//        앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
//        문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

        String ans = "Goog";
        ans = ans.toUpperCase();
        int end = ans.length();
        int j = 1;
        for(int i = 0; i<ans.length()/2; i++){
            System.out.println(ans.charAt(i)+ " "+ ans.charAt(end-j));
            j++;
        }

    }
}
