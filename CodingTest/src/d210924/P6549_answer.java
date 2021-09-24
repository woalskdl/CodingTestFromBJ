package d210924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P6549_answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int n = Integer.parseInt(st.nextToken()); n != 0; st = new StringTokenizer(br.readLine()), n = Integer.parseInt(st.nextToken())){
            int[] shapes = new int[n];

            for(int i=0; i<n; i++)
                shapes[i] = Integer.parseInt(st.nextToken());

            System.out.println(getArea(shapes));
        }
    }

    public static long getArea(int[] shapes){
        Stack<Integer> stack = new Stack<>();
        int length = shapes.length;

        long maxArea = 0;
        for(int i=0; i<length; i++){
            while ((!stack.isEmpty()) && shapes[stack.peek()] >= shapes[i]){
                int height = shapes[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            int height = shapes[stack.pop()];
            long width = stack.isEmpty() ? length : length - 1 - stack.peek();

            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}
