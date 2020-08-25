import java.util.*;
class QueueArr
{
    static int max=1000;
    static int f=0;
    static int e=0;
    public static int a[]=new int[max];
    public static void Enqueue(int x)
    {
        
        if(f>e||e>=max)
        {
            System.out.println("Stack overflow");
        }
        else
        {
            a[e]=x;
            e++;
        }
    }
    public static void Dequeue()
    {
        if(f>=e)
        {
            System.out.println("stack underflow");
        }
        else
        {
            f++;
        }
    }
    public static void Display()
    {
        if(f>=e)
        {
            System.out.println("stack is empty");
        }
        else
        {
            //int q=f;
            for(int i=f;i<e;i++)
            {
                System.out.println(a[i]+" "+f+" "+e);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter total operations");
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("1. To enqueue\n 2.to Dequeqe\n 3.To display\n");
            int c=s.nextInt();
            switch(c)
            {
                case 1:
                    Enqueue(s.nextInt());
                    break;
                case 2:
                    Dequeue();
                    break;
                case 3:
                    Display();
                    break;
            }
        }
    }
}
