package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack01 {
    public void Stack01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<a.length; i++){

            if(a[i] == '(') {
                stack.push(a[i]);
            }
            else{
                if(!stack.isEmpty()) {
                    if (stack.pop() != '(') {
                        System.out.println("NO");
                        return;
                    }
                }else{
                    System.out.println("NO");
                    return;
                }
            }
        }

        if(!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

    }
}
