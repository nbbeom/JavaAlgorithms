package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.ValueRange;
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
    public void Queue2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();
        char[] k = br.readLine().toCharArray();
        Queue queue = new LinkedList();

//        for (int i = 0; i < k.length; i++) {
//            queue.offer(k[i]);
//        }
        for (int i = 0; i < n.length; i++) {
            queue.offer(n[i]);
        }

        int i = 0;
//        while (!queue.isEmpty()) {
//            if(n.length <= i)
//                break;
//            if (String.valueOf(n[i]).equals(queue.poll().toString()) )
//                i++;
//        }
//        if (i == n.length){
//            System.out.println("YES");
//        }else{
//            System.out.println("No");
//        }

        for(int j = 0 ; j < k.length; j++){
            if(queue.contains(k[j])
            && queue.peek().toString().equals(String.valueOf(k[j]))){
                queue.poll();
                i++;
            }
        }
        if(queue.isEmpty() && i == n.length) {
            System.out.println("TRUE");
            return;
        }else{
            System.out.println("NO");
            return;
        }



    }

}
