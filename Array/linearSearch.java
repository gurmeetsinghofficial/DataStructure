import java.util.*;
public class linearSearch
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
		for(int i=0;i<n;i++)
		{
			if(a[i]==z)
			{
				System.out.println("element found at index "+i);
				q=1;
				break;
			}
		}
		if(q==0)
		System.out.println("Element not found");
	}
}
