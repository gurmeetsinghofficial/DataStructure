import java.util.*;
public class InfixToPostfix {
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
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String str =s.next();
        List<String> postFix=calculate(str);
        for(int i=0;i<postFix.size();i++)
        {
            System.out.print(postFix.get(i));
        }
        s.close();
    }
}