import java.util.*;
class Node
{
    Node top=null;
    int data;
    Node next=null;
    Node()
    {

    }
    Node(int d)
    {
        data=d;
    }
}
public class LinkedList4
{
    public static Node insertAtBeg(Node root,int data)
    {
        Node newNode=new Node(data);
        if(root==null)
        {
            root=newNode;
        }
        else
        {
            if(root.data<data)
            {
                newNode.next=root;
                root=newNode;
            }
            else
            {
                newNode.next=root.next;
                root.next=newNode;
            }
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
    public static void display(Node root)
    {
        while(root!=null)
        {
            System.out.println(root.data);
            root=root.next;
        }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n=s.nextInt();
        Node root=null;
        for(int i=0;i<n;i++)
		{
			root=insertAtBeg(root,s.nextInt());
			peek(root);
		}
        //display(root);
		//peek(root);
        s.close();
    }
}
