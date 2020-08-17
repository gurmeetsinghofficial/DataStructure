import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBracketsStack {

    // Complete the isBalanced function below.
    static int max=1000;
    static char a[]=new char[max];
    static int top=-1;
    static void push(char c)
    {
        a[++top]=c;
    }
    static char peek()
    {
        return a[top];
    }
    static void pop()
    {
        --top;
        //a[++top]=c;
    }
    static String isBalanced(String str) {
        top=-1;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            System.out.print(c+" ");
            switch(c)
            {
                case '{':
                    push(c);
                    break;
                case '[':
                    push(c);
                    break;
                case '(':
                    push(c);
                    break;
                case ']':
                    if(top<0||(peek()!='['))
                    {
                        return "NO";
                    }
                    pop();
                    break;
                case '}':
                    if(top<0||(peek()!='{'))
                    {
                        return "NO";
                    }
                    pop();
                    break;
                case ')':
                    if(top<0||(peek()!='('))
                    {
                        return "NO";
                    }
                    pop();
                    break;
            }
        }
    if(top<0)
    {
        return "YES";
    }
    return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
