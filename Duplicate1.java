import java.util.HashSet;
import java.util.Set;
import java.util.*;
public class Duplicate1 
{
    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] array = new int[n];
         for(int i=0;i<n;i++)
         array[i]=s.nextInt();
        Set<Integer> set = new HashSet<Integer>();
         
        for(int i = 0; i < array.length ; i++) 
        {
            //If same integer is already present then add method will return FALSE 
            if(set.add(array[i]) == false) 
            {
                System.out.println("Duplicate element found : " + array[i]);
            }
        }
        s.close();
    }
}