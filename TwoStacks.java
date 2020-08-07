import java.util.*;
public class TwoStacks {
    static int max=1000;
    static int a[]=new int[max];
    static int top1=-1;
    static int top2=1000;
    public static void push1(int x)
    {
        if(top1>=max/2)
        {
            System.out.println("Stack overflow");
        }
        else
        {
            a[++top1]=x;
        }
    }
    public static void push2(int x)
    {
        if(top2<max/2)
        {
            System.out.println("Stack overflow");
        }
        else
        {
            a[--top2]=x;
        }
    }
    public static void pop1()
    {
        if(top1<0)
        {
            System.out.println("Underflow");
        }
        else
        {
            System.out.println("popped element "+a[top1--]);
        }
    }
    public static void pop2()
    {
        if(top2>1000)
        {
            System.out.println("Underflow");
        }
        else
        {
            System.out.println("popped element "+a[top2++]);
        }
    }
    public static void peek1()
    {
        if(top1<0)
        {
            System.out.println("Underflow");
        }
        else
        {
            System.out.println(a[top1]);
        }
    }
    public static void peek2()
    {
        if(top2>=1000)
        {
            System.out.println("Underflow");
        }
        else
        {
            System.out.println(a[top2]);
        }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter elements in stack1 and stack 2");
        int n1=s.nextInt();
        int n2=s.nextInt();
        System.out.println("Enter elements of stack1");
        for(int i=0;i<n1;i++)
        {
            push1(s.nextInt());
        }
        System.out.println("Enter elements of stack2");
        for(int i=0;i<n2;i++)
        {
            push2(s.nextInt());
        }
        peek1();
        peek2();
        pop1();
        pop2();
        peek1();
        peek2();
        s.close();
    }
}