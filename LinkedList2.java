import java.util.*;
class Node
{
    Node top=null;
    char data;
    Node next=null;
    Node()
    {

    }
    Node(char d)
    {
        data=d;
    }
}
public class LinkedList2
{
    public static Node insertAtBeg(Node root,char data)
    {
        Node newNode=new Node(data);
        if(root==null)
        {
            root=newNode;
        }
        else
        {
            newNode.next=root;
            root=newNode;
        }
		return root;
    }
    public static Node deleteNode(Node root,int data)
    {
        if(root==null)
        {
            System.out.println("Under Flow");
            return root;
        }
        else
        {
            root=root.next;
        }
        return root;
    }
    public static void peek(Node root)
    {
        if(root==null)
        {
            System.out.println("Stack is empty");
            //root=root.next;
            return;
        }
        System.out.println(root.data+" ");
    }
	public static int palin(Node root,String str)
	{
		Node temp=root;
		for(int i=0;i<str.length();i++)
		{
			if(temp.data==str.charAt(i))
			{
				temp=temp.next;
			}
			else
			{
				return -1;
			}
		}
		return 1;
	}
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter String to enter in linkedlist");
        String str=s.nextLine();
        Node root=null;
            for(int i=0;i<str.length();i++)
            root=insertAtBeg(root,str.charAt(i));
            peek(root);
			int x=palin(root,str);
			if(x==1)
			{
				System.out.println("palindrome");
			}
			else
			{
				System.out.println("not palindrome");

			}
        s.close();
    }
}