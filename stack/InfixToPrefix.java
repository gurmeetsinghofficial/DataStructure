import java.util.*;
public class InfixToPrefix {
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
        
        public static List<String> calculate(String s) {
            List<String> postFix=getPostFix(s);
            return (postFix);
        }
    public static List<String> infixtoprefix(char c[])
    {
        int len=c.length;
        c=StrRev(c);
        String x="";
        for(int i=0;i<len;i++)
        {
            if(c[i]=='(')
            c[i]=')';
            else if(c[i]==')')
            c[i]='(';
            x+=c[i];
        }
        List<String>z=calculate(x); 
        Collections.reverse(z);
        //System.out.println(c);
        return z;
    }
    public static char[] StrRev(char c[])
    {
        for(int i=0;i<(c.length)/2;i++)
        {
            char z=c[i];
            c[i]=c[(c.length)-i-1];
            c[(c.length)-i-1]=z;
        }
        return c;
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String str=s.next();
        char c[]=str.toCharArray();
        List<String>z=infixtoprefix(c);
        for(int i=0;i<z.size();i++)
        System.out.print(z.get(i));
    }
}