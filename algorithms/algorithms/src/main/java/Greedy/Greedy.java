package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
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

    static class Time2 implements Comparable<Time2>{
        private int s , e;
        Time2(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Time2 time2){
            if(this.s ==time2.s) return this.e-time2.e;
            else return this.s-time2.s;
        }
    }

    public void Wedding() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Time2> arr = new ArrayList<>();
        for(int i = 0 ; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time2(s ,1));
            arr.add(new Time2(e, 0));
        }

        Collections.sort(arr);
        int cnt = 0;
        int ans = 0;
        for (Time2 t :arr){
            if(t.e == 1 ) cnt++;
            else cnt--;
            ans =Math.max(ans,cnt);
        }
        System.out.println(ans);
    }

    static class Lecture implements Comparable<Lecture>{
        public int money;
        public int time;

        Lecture(int money, int time){
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture lc){
            return lc.time -this.time;
        }

    }

    public void PQ() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0 ; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Lecture(s ,e));
        }

        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);

        int ans = 0;
        int j = 0;
        int max = arr.get(0).time;
        for(int i = max; i>= 1 ; i--){
            for (;j < n;j++){
                if(arr.get(j).time < i)break;
                pq.offer(arr.get(j).money);
            }
            if(!pq.isEmpty()) ans+=pq.poll();
        }

        System.out.println(ans);
    }

}
