import java.util.*;
public class InfixToPostfixWithEval {
        public static int preference(char c)
        {
            if(c=='+'||c=='-')
                return 1;
            else if(c=='*'||c=='/')
                return 2;
            else
                return -1;
                
        }
        public static List<String>getPostFix(String s)
        {
            Stack<Character>stack=new Stack();
            List<String> postFix=new ArrayList<>();
            boolean flag=false;
            for(int i=0;i<s.length();i++)
            {
                char word=s.charAt(i);
                if(word==' ')
                {
                    continue;
                }
                if(word=='(')
                {
                    stack.push(word);
                    flag=false;
                }
                else if(word==(')'))
                {
                    flag=false;
                    while(!stack.isEmpty()){
                        if(stack.peek()=='(')
                        {
                            stack.pop();
                            break;
                        }
                        else
                        {
                            postFix.add(stack.pop()+"");
                        }
                        
                    }
                }
                else if(word=='+'||word=='-'||word=='*'||word=='/')
                {
                    flag=false;
                    if(stack.isEmpty())
                    {
                        stack.push(word);
                    }
                    else
                    {
                        while(!stack.isEmpty() && preference(stack.peek())>=preference(word))
                        {
                            postFix.add(stack.pop()+"");
                        }
                        stack.push(word);
                    }
                }
                else
                {
                    if(flag)
                    {
                        String l=postFix.get(postFix.size()-1);
                        l+=word;
                        postFix.set(postFix.size()-1,l);
                    }
                    else
                        postFix.add(word+"");
                        flag=true;
                }
            }
            while(!stack.isEmpty())
            {
                postFix.add(stack.pop()+"");
            }
            return postFix;
        }
        public static int evalPostFix(List<String> tokens)
        {
            if(tokens.size()==1)
            {
                return Integer.parseInt(tokens.get(0));
                
            }
            if(tokens.size()==0)
                return 0;
            Stack<Integer>x=new Stack();
            int res=0;
            for(int i=0;i<tokens.size();i++)
            {
                String token=tokens.get(i);
                if(token.charAt(0)=='*'||token.charAt(0)=='/'||token.charAt(0)=='+'||token.charAt(0)=='-')
                {
                    int b=x.pop();
                    int a=x.pop();
                    switch(token.charAt(0))
                    {
                        case '*':
                            res=a*b;
                            x.push(res);
                            break;
                        case '/':
                            res=a/b;
                            x.push(res);
                            break;
                        case '+':
                            res=a+b;
                            x.push(res);
                            break;
                        case '-':
                            res=a-b;
                            x.push(res);
                            break;
                    }
                }
                else
                {
                    int z=Integer.parseInt(token);
                    x.push(z);
                }
            }
            return res;
        }
        public static int calculate(String s) {
            List<String> postFix=getPostFix(s);
            return evalPostFix(postFix);
        }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String str =s.next();
        System.out.println(calculate(str));
        s.close();
    }
}