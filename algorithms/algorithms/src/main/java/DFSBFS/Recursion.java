package DFSBFS;

import Arrayss.Pibonacci;

public class Recursion {

    //스택프레임 (StackFrame)
    //D(3) -> D(2) 호출 D(2)에 D(3)복귀주소를 저장
    //출력결과는 스택 맨위에 쌓인 D(0) -> D(1) -> D(2) -> D(3)
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    //10 진수를 2진수로 교환
    //DFS 위와 같은 원리로 작동함.
    public void BinPrint(int n) {
        if (n == 0) {
            return;
        } else {
            BinPrint(n / 2);
            System.out.print(n % 2 + " ");
        }
    }

    public int Factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }
    //p(4) == p(3) + p(2)
    //p(3) == p(2) + p(1)
    public int Recursionfibbonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n==2) {
            return 1;
        } else {
            return Recursionfibbonacci(n-2)+Recursionfibbonacci(n-1);
        }
    }
    static int[] fibo;
    public int Memorizationfibbonacci(int n) {
        if(fibo[n] >0){
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n==2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = Memorizationfibbonacci(n-1)+Memorizationfibbonacci(n-2);
        }
    }
    public void printFibo(){
        int n =4;
        fibo= new int[n+1];
        Memorizationfibbonacci(4);
        for(int i :fibo){
            System.out.print(i);
        }
    }



}



