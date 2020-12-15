import java.util.*;
public class largestElement
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
		int m=a[0];
		for(int i=1;i<n;i++)
		{
			if(m<a[i])
			m=a[i];
		}
		System.out.println("Max element : "+m+" ");
		Arrays.sort(a);
		System.out.println("Sorted array");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]+" ");
		}
	}
}
