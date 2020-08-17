import java.util.*;
public class PostfixEval {
       public static int evalRPN(String[] token) {
            if(token.length==1)
            {
                return Integer.parseInt(token[0]);
                
            }
            if(token.length==0)
                return 0;
            Stack<Integer>x=new Stack();
            int res=0;
            for(int i=0;i<token.length;i++)
            {
                
                if(token[i].equals("*")||token[i].equals("/")||token[i].equals("+")||token[i].equals("-"))
                {
                    int b=x.pop();
                    int a=x.pop();
                    switch(token[i])
                    {
                        case "*":
                            res=a*b;
                            x.push(res);
                            break;
                        case "/":
                            res=a/b;
                            x.push(res);
                            break;
                        case "+":
                            res=a+b;
                            x.push(res);
                            break;
                        case "-":
                            res=a-b;
                            x.push(res);
                            break;
                    }
                }
                else
                {
                    int z=Integer.parseInt(token[i]);
                    x.push(z);
                }
            }
            return res;
        }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter total elements in String");
        int n=s.nextInt();
        String str[] =new String[n];
        for(int i=0;i<n;i++)
        {
            str[i]=s.nextLine();
            s.nextChar();
        }
        System.out.println(evalRPN(str));
        s.close();
    }
}