package Arrayss;

import java.util.Scanner;

public class TwoArrayMax {

    public void TwoArray(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[][] = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j =0 ; j< n; j++){
                arr[i][j] = sc.nextInt();
            }

        }
        int ans = 0;

        for (int i =0; i < n; i++){
            int sum1 = 0, sum2 =0;
            for (int j = 0; j< n ; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            ans = Math.max(ans, sum1);
            ans = Math.max(ans, sum2);
        }
        int sum3 = 0, sum4 = 0;
        for(int i= 0 ; i<n ; i++){
            sum3 += arr[i][i];
            sum4 += arr[i][n-i-1];
        }
        ans = Math.max(ans, sum3);
        ans = Math.max(ans, sum4);
        System.out.println(ans);


    }
}
