import java.util.*;
class StackArr
{
    static int max=1000;
    static int a[]=new int[max];
    static int top=-1;
    public static void push(int x)
    {
        if(top-1>max)
        {
            System.out.println("stack overflow");
        }
        else
        {
            a[++top]=x;
        }
    }
    public static int pop()
    {
        if(top==-1)
        {
            return -1;
        }
        else
        {
            return a[top--];
        }
    }
    public static int peek()
    {
        if(top==-1)
        {
            return -1;
        }
        else
        {
            return a[top];
        }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of operations");
        int n=s.nextInt();
        System.out.println("1. push\n2. pop\n3.peek");
        for(int i=0;i<n;i++)
        {
            int c=s.nextInt();
            if(c==1)
            {
                System.out.println("Enter element to push");
                int x=s.nextInt();
                push(x);
            }
            else if(c==2)
            {
                int z=pop();
                if(z==-1)
                System.out.println("Stack underflow");
                else
                System.out.println(z);
            }
            else if(c==3)
            {
                int z=peek();
                if(z==-1)
                System.out.println("Stack underflow");
                else
                System.out.println(z);
            }
        }
        s.close();
    }
}