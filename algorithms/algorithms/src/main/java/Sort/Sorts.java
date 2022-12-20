package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sorts {

    public void SelectionSort() throws IOException {
        //n^2 의 시간이 걸리는 선택정렬
        //알고리즘이 단순하지만, 성능상 제약이있다,
        //메모리가 제한적인경우 성능상 이점이 있다.
        // 버블정렬보단 빠르다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int [] k = new int[n];

        for(int i = 0 ; i < n; i++){
            k[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0; i < n; i++){
            int tmp = 0;
            for(int j =i+1 ; j<n; j++){
                //리스트의 최소값을 찾는다.
                //그 값을 맨 앞에 위치한 값과 교체한다.
                if(k[i] > k[j]){
                    tmp = k[j];
                    k[j] = k[i];
                    k[i] = tmp;
                }
            }

        }

        for(int x : k){
            System.out.print(x + " ");
        }

    }
    public void BubbleSort() throws IOException {
        //배열의 두수를 비교한다
        // 두수가 정렬되었다면 놔두고 아니면 두수를 바꾼다
        // 이를 처음부터 끝까지 반복한다.
        //상당히 느리지만 코드가 단순해서 자주 사용된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int [] k = new int[n];

        for(int i = 0 ; i < n; i++){
            k[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        for(int i =0; i < n; i++){
            for(int j =0; j <n-1; j++){
                if(k[j] > k[j+1]){
                    temp=  k[j] ;
                    k[j] = k[j+1];
                    k[j+1] =temp;
                }
            }

        }

        for(int x : k){
            System.out.print(x + " ");
        }

    }
    public void InsertionSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int [] k = new int[n];

        for(int i = 0 ; i < n; i++){
            k[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =1; i < n ;i++){
            int temp = k[i];
            int j = 0;
            for ( j = i-1; j>=0; j--){
                if(k[j] > temp) {
                    k[j + 1] = k[j];
                }else{
                    break;
                }
            }
            k[j+1] =temp;
        }
        for( int i : k){
            System.out.print(i + " ");
        }

    }
    public void LRU() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());

        int [] arr = new int[k];
        int [] chache = new int[n];

        for(int i = 0 ; i < k; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : arr){
            int pos = -1;
            for(int i = 0 ; i< n; i++) if( x == chache[i]) pos = i;
            //missing
            if(pos == -1){
                for( int i = n-1; i >=1; i--){
                    chache[i] = chache[i-1];
                }
            }else{//hit
                for(int i = pos; i>=1 ; i--)
                    chache[i] = chache[i-1];
            }
            chache[0] = x;
        }


        for( int i : chache){
            System.out.print(i + " ");
        }

    }

    public void duplication() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());

            int [] arr = new int[n];


            for(int i = 0 ; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(arr);

            for(int i= n-1; i>0;  i--){
                if(arr[i] == arr[i-1]){
                    System.out.println("D");
                    return;
                }
            }
            System.out.println("U");
            return ;

        }
    public void Joke() throws IOException{
        //120 125 152 130 135 135 143 127 160
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int [] arr = new int[n];
            int [] t = new int[n];

         for(int i = 0 ; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                t[i]= arr[i];
            }


            Arrays.sort(arr);

            for(int j =0; j<n; j++){
                if(arr[j] != t[j]){
                    System.out.print(j+1+" ");
                }
            }

        }

    class Point implements Comparable<Point>{
        public int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if(this.x ==o.x) return this.y-o.y;
            return this.x - o.x ;
        }
    }

    public void Xy() throws IOException{

        //120 125 152 130 135 135 143 127 160
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());

            ArrayList<Point> arrs = new ArrayList<>();

         for(int i = 0 ; i < n; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
             int x= Integer.parseInt(st.nextToken());
              int y= Integer.parseInt(st.nextToken());
              arrs.add(new Point(x,y));
            }
        Collections.sort(arrs);

         for(Point o  : arrs){
             System.out.println(o.x + " "+o.y);
         }

        }
    public void BinarySearch() throws IOException {

        //120 125 152 130 135 135 143 127 160
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int [] arrs = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arrs[i] = (Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arrs);

        int lt = 0, rt = n;

        for(int i = 0 ; i<n; i++){
            int mid = (lt + rt) / 2;
            if(arrs[mid] == m){
                System.out.println(mid+1);
                break;
            } else if (arrs[mid] > m) {
                rt = mid;
            }else {
                lt = mid;
            }
        }

    }


}

