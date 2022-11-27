package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue1 {
    public void Queue1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue queue = new LinkedList();

        for (int i= 0; i <n; i++){
            queue.offer(i+1);
        }

        while(true){
            if(queue.size() == 1 ){
                System.out.println(queue.poll());
                return;
            }
            for(int j =0 ; j <k-1; j++)
                queue.offer(queue.poll());
            queue.poll();
        }


    }

}
