import java.util.*;
class Node
{
    Node head=null;
    int data;
    Node next=null;
    Node(int d)
    {
        data=d;
    }

}
public class LinkedList1
{
    public static void insertAtEnd(Node root,int data)
    {
        Node newNode=new Node(data);
        if(root==null)
        {
            root=newNode;
        }
        else
        {
            Node c=root;
            while(c.next!=null)
            {
                c=c.next;
            }
            c.next=newNode;
        }
    }
    public static void insertIn(Node root,int data,int po)
    {
        int x=1;
        Node newNode=new Node(data);
        if(root==null)
        {
            root=newNode;
        }
        else
        {
            Node c=root;
            while(x!=po-1)
            {
                if(c.next==null)
                {
                    System.out.println("Cannot insert element");
                    return;
                }
                c=c.next;
                x++;
            }
            //Node temp=c.next;
            newNode.next=c.next;
            c.next=newNode;
        }
    }
    public static Node Merge(Node root,Node sec)
    {
        if(root==null)
        {
            root=sec;
        }
        else if(sec==null)
        {
            return root;
        }
        else
        {
            Node cur=root;
            while(cur.next!=null)
                cur=cur.next;
            cur.next=sec;
        }
        return root;
    }
    public static Node insertAtBeg(Node root,int data)
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
    public static int Search(Node root,int data)
    {
        int x=0;
        if(root==null)
        {
            return -1;
        }
        else
        {
            Node newNode=root;
            while(newNode!=null)
            {
                if(newNode.data==data)
                    return x;
                newNode=newNode.next;
                x++;
            }
        }
        return -1;
    }
    public static Node deleteNode(Node root,int data)
    {
        if(root==null)
        {
            System.out.println("Element not found");
            return root;
        }
        else
        {
            Node prev=null;
            if(root.data==data)
            {
                root=root.next;
                return root;
            }
            else
            {
                Node newNode=root;
                while(newNode!=null)
                {
                    if(newNode.data==data)
                        break;
                        prev=newNode;
                    newNode=newNode.next;
                }
                if(newNode==null)
                {
                    System.out.println("Element not found");
                    return root;
                }
                else
                {
                    prev.next=newNode.next;
                    return root;
                }
            }
        }
        //return root;
    }
    public static void display(Node root)
    {
        while(root!=null)
        {
            System.out.print(root.data+" ");
            root=root.next;
        }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of elements in linkedlist");
        int n=s.nextInt();
        Node root=null;
        if(n!=0)
        {
            root=new Node(s.nextInt());
            for(int i=0;i<n-1;i++)
            insertAtEnd(root,s.nextInt());
            display(root);
        }
        int ch;
        int flip=0;
        do{
            System.out.println("Enter your choice:-\n1. To insert at end\n2. To insert at begning\n 3. To insert in between\n4. Merge 2 linked List\n5.To search an element\n6.Enter element to remove\n-1. To exit");
            ch=s.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter element to add");
                    int ele=s.nextInt();
                    insertAtEnd(root,ele);
                    display(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter element to add");
                    int ele1=s.nextInt();
                    root=insertAtBeg(root,ele1);
                    display(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter element to add and it's position");
                    int ele2=s.nextInt();
                    int po=s.nextInt();
                    insertIn(root,ele2,po);
                    display(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter number of elements of second LL");
                    int nn=s.nextInt();
                    Node Second=new Node(s.nextInt());
                    for(int i=1;i<nn;i++)
                    {
                        insertAtEnd(Second,s.nextInt());
                    }
                    root=Merge(root,Second);
                    display(root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Enter element to search");
                    int e=s.nextInt();
                    int found=Search(root,e);
                    if(found!=-1)
                    {
                        System.out.println("Element found at index "+found);
                    }
                    else
                    {
                        System.out.println("Not found");
                    }
                    break;
                case 6:
                    System.out.println("Enter element to delete6");
                    int del=s.nextInt();
                    root=deleteNode(root,del);
                    display(root);
                    break;
                case -1:
                    flip=1;
                    break;
            }
            if(flip==-1)
                break;
        }while(ch!=-1);
        s.close();
    }
}