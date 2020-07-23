import java.util.*;
public class Duplicate2
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
		System.out.println("The repeating elements are : "); 
     
        for (int i = 0; i < n; i++) 
        { 
            if (a[ Math.abs(a[i])] >= 0) 
                a[ Math.abs(a[i])] = -a[ Math.abs(a[i])]; 
            else
                System.out.print(Math.abs(a[i]) + " "); 
        }
        s.close();  
	}
}