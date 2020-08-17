import java.util.*;
public class PrefixToPostfix {
    public static boolean isOp(char c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/')
        return true;
    return false;
    }
    public static String prefixToPostfix(String s)
    {
        Stack<String>st=new Stack<>();
        int l=s.length();
        for(int i=l-1;i>=0;i--)
        {
            if(isOp(s.charAt(i)))
            {
                String o1=st.peek();
                st.pop();
                String o2=st.peek();
                st.pop();
                st.push(o1+o2+s.charAt(i));
            }
            else
            {
                st.push(s.charAt(i)+"");
            }
        }
        return st.peek();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(prefixToPostfix(s));
        sc.close();
    }
}
