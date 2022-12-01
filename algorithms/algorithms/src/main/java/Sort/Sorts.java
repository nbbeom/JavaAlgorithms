package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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


}
