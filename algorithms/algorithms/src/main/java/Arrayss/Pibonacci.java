package Arrayss;

import java.util.ArrayList;

public class Pibonacci {

    public void pibo(){
//        String res =  sol("ksekkset");
        int temp = 1;
        String ans = "";
        int input = 7;
        int [] a = new int[input];

        a[0] = 1;
        a[1] = 1;

        for(int i = 2; i < input ; i++){
            a[i] = a[i-1]+ a[i-2];
        }
        for(int i=0; i<input; i++){
            System.out.print(a[i]+ " ");
        }

    }
}
