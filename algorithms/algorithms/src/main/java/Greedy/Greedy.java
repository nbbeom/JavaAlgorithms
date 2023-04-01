package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Greedy {
    public void Greedy1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] tall   = new int [n];
        int [] weight = new int [n];

        for(int i = 0 ; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            tall[i] =   Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());

        }
        int answer = n;
        int flag = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(tall[i] < tall[j] && weight[i] < weight[j])
                    flag =1;
            }
            if(flag == 1){
                flag = 0;
                answer --;
            }
        }

        System.out.println(answer);

    }

    static class Time implements Comparable<Time>{
        public int s ,e;
        Time(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Time o){
            if(this.e ==o.e) return this.s-o.s;
            else return this.e-o.e;
        }
    }

    public void CommunicationRoom() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0 ; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Time time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr.add(time);
        }
        int ans = 0 ;

        Collections.sort(arr);
        int et =0;
        for(Time t : arr){
            if(t.s >= et){
                ans ++;
                et = t.e;
            }
        }
        System.out.println(ans);

    }

}
