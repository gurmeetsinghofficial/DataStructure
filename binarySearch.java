import java.util.*;
public class binarySearch
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
		System.out.println("Enter element to search");
		int z=s.nextInt();
		int q=0;
		int st=0,end=n-1;
		int m=st+(end-st)/2;
		while(st<=end)
		{
			if(a[m]==z)
			{
				System.out.println("element found at index "+m);
				q=1;
				break;
			}
			else if(a[m]>z)
			{
				//System.out.println(" > ");
				end=m-1;
				m=st+(end-st)/2;
			}
			else
			{
				//System.out.println(" < ");
				st=m+1;
				m=st+(end-st)/2;
			}
		}
		if(q==0)
		System.out.println("Element not found");
	}
}