import java.util.*;
public class bubbleSortOpt
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		for(int i=0;i<n-1;i++)
		{
			boolean x=false;;
			for(int j=0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
					x=true;
				}
			}
			if(x==false)
				break;
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]+" ");
		}
	}
}