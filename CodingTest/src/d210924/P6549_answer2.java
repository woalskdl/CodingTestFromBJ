package d210924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P6549_answer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int n = Integer.parseInt(st.nextToken()); n != 0; st = new StringTokenizer(br.readLine()), n = Integer.parseInt(st.nextToken())){
            int[] shapes = new int[n];

            for(int i=0; i<n; i++)
                shapes[i] = Integer.parseInt(st.nextToken());

            System.out.println(getArea(0, n-1, shapes));
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

    public static long getArea(int l, int h, int[] shapes){
        if(l == h)
            return shapes[l];

        int mid = (l + h) / 2;

        long leftArea = getArea(l, mid, shapes);
        long rightArea = getArea(mid + 1, h, shapes);

        long max = Math.max(leftArea, rightArea);
        max = Math.max(max, getMidArea(l, h, mid, shapes));

        return max;
    }

    public static long getMidArea(int l, int h, int mid, int[] shapes){
        int toLeft = mid;
        int toRight = mid;

        long height = shapes[mid];
        long maxArea = height;

        while (l < toLeft && toRight < h){
            if(shapes[toLeft - 1] < shapes[toRight + 1]){
                toRight ++;
                height = Math.min(height, shapes[toRight]);
            }else{
                toLeft --;
                height = Math.min(height, shapes[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < h){
            toRight ++;
            height = Math.min(height, shapes[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (l < toLeft){
            toLeft --;
            height = Math.min(height, shapes[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
