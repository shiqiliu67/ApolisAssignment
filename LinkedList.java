import java.io.*;
import java.util.*;
public class LinkedList {
//creat node
Node first, last;
int ctr;
ArrayList<Integer> res = new ArrayList<Integer>();//use in reverse order
public static class Node {
	int data;
	Node next;
}
//create linkedlist
public void createfirstNode(int data)throws IOException {
//create first node
	first = new Node();
	first.data=data;
	first.next = null;
	last = first;}
//rest of list
public void createRestNode(int data)throws IOException {
	Node temp =new Node();
	temp.data = data;
	temp.next =null;
	last.next=temp;
	last=temp;
}
public void printList() {
	Node temp = first;
	while(temp!=null) {
		System.out.print(temp.data+"\t");
		temp = temp.next;
	}
	//System.out.println("\n"+last.data);
}
//1) Write a program to search element in linked list
public boolean searchElement(int data) {
	Node temp = first;
	ctr=1;
	while(temp!=null) {
		if(temp.data == data) {
			System.out.println("Search element successful! "+temp.data+" is in "+ctr+" position.");
			return true;
		}
		ctr++;
		temp =temp.next;
	}
	System.out.println("\n"+"Not find the element.");
	return false;
}
//2) Write a program to sort linked list element
public static void quickSortLinkedList(Node start, Node end) {//only change the data
//if only one node
	if(start == end || start.next==end) {
	//	System.out.println(start.data);
		return;
	}
	int p = start.data;
	Node l = start;
	Node u = start.next;
	while(u!=end) {
		//if u data smaller than p, swap u and l,l++;else u++
		if(u.data<p) {
			Node temp= u;
			l.data=u.data;
			u.data=temp.data;
			l=l.next;
		}
		u=u.next;
	}
//when u goes to the end, if l not the first node, swap l and p 
	if(l!=start) {
		int temp = p;
		p=l.data;
		l.data=temp;
	}
//then recur in prelist and postlist
	quickSortLinkedList(start,l);
	quickSortLinkedList(l.next,end);
	
////else
//	Node min= first;
//	Node cur = first.next;
//	while(min.next!=null) {
//		while(cur.next!=null) {
//			if(min.data>cur.data) {
//				Node temp = min;
//				min.data = cur.data;
//				cur.data = temp.data;
//			}
//			cur = cur.next;
//		}
//		min= min.next;
//	}//selection sort failed


}

//3) Write a program to print list in reverse order
public void reversePrintList() {
recur(first);
int[] arr = new int[res.size()];
//put each element into array
for(int i=0;i<arr.length;i++) {
	arr[i]=res.get(i);
}
for(int i=0;i<arr.length;i++) {
	System.out.print(arr[i]+"\t");
}

}
public void recur(Node fnode) {
	//in this problem, first to find the last element in linkedlist	
		if(fnode==null) {
			return;
		}
	//recur the method util first = null;
		recur(fnode.next);
		res.add(fnode.data);//when rec end, store the last data in arraylist

	}
//another way
public void reversePrint() {
	if(first==null) {
		return;
	}
	Node cur = first;
	Node temp =first;
	int length=0;
	while(cur!=null) {
		length++;
		cur = cur.next;
	}
	int[] resarr = new int[length];
	for(int i=length-1;i>=0;i--) {
		resarr[i]=temp.data;
		temp=temp.next;
	}
	//print
	for(int i=0;i<resarr.length;i++) {
		System.out.print(resarr[i]+"\t");
	}
}
//4) Write a program to concatenate two lists into third new list
public static void concatenateWithNewList(Node l1, Node l2) throws IOException {
	//3.next = 1.next; when 1==null; 3.next = 2.next;
LinkedList ln = new LinkedList();
Node temp1= l1.next;
ln.createfirstNode(l1.data);
while(temp1!=null) {//from the second element add in the new list
	ln.createRestNode(temp1.data);
	temp1=temp1.next;
}//add all element in list 1
while(l2!=null) {
	ln.createRestNode(l2.data);
	l2 = l2.next;
}//add all elements in list 2
//print all list
ln.printList();
}
	
//5) Write a program to concatenate two lists without creating third linked list.
public static void concatenateWithOutNewList (Node n1,Node n2)throws IOException {
	Node temp = n1;
    while(temp.next != null) {
        temp = temp.next;
    }// let temp = last node
    temp.next = n2; //l1_lastnode.next = l2_first node
    while(n1 != null) {
    	System.out.print(n1.data+"\t");
        n1 = n1.next;
    }
}
//6) Write a program to merge two linked list into third new list
public static void mergeWithNewList(Node n1, Node n2) throws IOException {
	LinkedList ln = new LinkedList();
	//frist element
	ln.createfirstNode(n1.data);
	Node temp = n1.next;
	while(temp!=null && n2!=null) {
			ln.createRestNode(n2.data);
			n2=n2.next;
			ln.createRestNode(temp.data);
			temp = temp.next;
		}
	if(n2==null) {
		while(n1!=null) {
			ln.createRestNode(n1.data);
			System.out.print(n1.data+"\t");
			n1 = n1.next;
		}

	}
	if(n1==null) {
		while(n2!=null) {
			ln.createRestNode(n2.data);
			System.out.print(n2.data+"\t");
			n2 = n2.next;
		}
	}
		ln.printList();
		
}
//7) Write a program to merge two linked list without creating third linked list.
public static void mergeWithOutNewList(Node n1, Node n2) {
	Node temp = n1;
	Node head = temp;
    n1 = n1.next;
	while(n1!=null && n2!=null) {
		temp.next = n2;
        n2 = n2.next;
        temp = temp.next;
        temp.next = n1;
        n1 = n1.next;
        temp = temp.next;
	}
	if(n1==null) {
//		while(n2!=null) {
//			System.out.print(n2.data+"\t");
//			n2 = n2.next;
//		}
		temp.next = n2;
	}
	if(n2==null) {
//		while(n1!=null) {
//			System.out.print(n1.data+"\t");
//			n1 = n1.next;
//		}
		temp.next = n1;
	}
	 while(head != null) {
         System.out.print(head.data+"\t");
         head = head.next;
     }
}
//8) Write a program to merge two sorted linked list into third new list in such a way that newly created list will be sorted one.
public static void mergeSortWithNewList(Node n1, Node n2) throws IOException {
	LinkedList ln = new LinkedList();
	//frist element
	ln.createfirstNode(n1.data);
	Node temp = n1.next;
	while(temp!=null && n2!=null) {
		if(n2.data<n1.data) {
			ln.createRestNode(n2.data);
			n2=n2.next;
			}
		else {
			ln.createRestNode(temp.data);
			temp = temp.next;}
		
	if(n2==null) {
		while(n1!=null) {
			ln.createRestNode(n1.data);
			System.out.print(n1.data+"\t");
			n1 = n1.next;
		}

	}
	if(n1==null) {
		while(n2!=null) {
			ln.createRestNode(n2.data);
			System.out.print(n2.data+"\t");
			n2 = n2.next;
		}
	}
	}
		ln.printList();
}
//9) Write a program to merge two sorted linked list without creating third linked list in such a way that newly created list will be sorted one.
public static void mergeSortWithOutNewList(Node n1, Node n2) {
//	if(n1==null) {
//		return n2;
//	}
//	if(n2==null) {
//		return n1;
//	}
//	if(n1.data<n2.data) {
//		n1.next = mergeSortWithOutNewList(n1.next,n2);
//		return n1;
//	}
//	else {
//		n2.next = mergeSortWithOutNewList(n1,n2.next);
//		return n2;
//	}
	Node temp = n1;
	Node head = temp;
    n1 = n1.next;
    head = head.next;
	while(n1!=null && n2!=null) {
		if(n1.data>n2.data) {
			temp.next=n2;
			n2=n2.next;
		}
		else {
			temp.next=n1;
			n1=n1.next;
		}
		temp=temp.next;
	}
	if(n1==null) {
		temp.next = n2;
	}
	if(n2==null) {
		temp.next = n1;
	}
	 while(head != null) {
         System.out.print(head.data+"\t");
         head = head.next;
     }

}

//10) Write a program to search element in linked list and if it exists delete node with that data.
public void deleteNode(int data) {
	//if there does not exist an element
	if(searchElement(data) == false) {
		//System.out.println("Element doesn't exist ");
		return;
	}
	//else delete data
	//if delete first node
	if(first.data == data) {
	//	Node temp = first;
		first = first.next;
	//	temp = null;
		System.out.println("Delete successful!");
		return;
	}
	//else, we need to find node ,then delete
	Node t = first;
	while(t.next!=null) {
		if(t.next.data == data) {//we need to found the previous of element, t.next=element need to delete
			Node temp = t.next;
			t.next = temp.next;
			temp = null;
			System.out.println("Delete successful!");
			return;
		}
	}
	
		
	
}

//11) Write a program to find smallest and greates element from the linked list
public void findMin() {
//	if(first==last) {
//		System.out.println("\nMin element is : "+ first.data);
//		return;}
	int min =first.data;
	Node cur = first;
	while(cur !=null) {
		if(min > cur.data) {
			min=cur.data;
		}
		cur = cur.next;
	}
	System.out.println("\nMin element is : "+ min);
}
public int findMax() {
	int max =first.data;
	Node cur = first;
	while(cur !=null) {
		if(max < cur.data) {
			max=cur.data;
		}
		cur = cur.next;
	}
	System.out.println("\nMax element is : "+ max);
	return max;
}
//12) Write a program to reverse the order of linked list without creating new linked list.
public void reverseOrder() {
	Node pre = null;
	Node cur = first;
	while(cur!=null) {
		Node next = cur.next; //store the next node 
		cur.next=pre;	//let next node be the previous one
		pre = cur;//let pre node be cur
		cur = next;//cur be the next node we stored
	}
	//print
	Node temp = pre;
	while(temp!=null) {
		System.out.print(temp.data+"\t");
		temp = temp.next;
	}
}

//client
public static void main(String[] args) throws Exception {
//create linkedlist
System.out.println("\n=========================START=================================");
LinkedList ll = new LinkedList();
LinkedList l2 = new LinkedList();
LinkedList l3 = new LinkedList();
LinkedList l4 = new LinkedList();
LinkedList l5 = new LinkedList();
LinkedList l6 = new LinkedList();

ll.createfirstNode(70);
ll.createRestNode(5);
ll.createRestNode(20);
ll.createRestNode(17);
ll.createRestNode(9);
ll.createRestNode(54);
ll.printList();

l2.createfirstNode(10);
l2.createRestNode(33);
l2.createRestNode(20);
l2.createRestNode(67);
l2.createRestNode(89);

l3.createfirstNode(30);
l3.createRestNode(130);
l3.createRestNode(330);
l3.createRestNode(230);
l3.createRestNode(3);

l4.createfirstNode(40);
l4.createRestNode(140);
l4.createRestNode(440);
l4.createRestNode(440);
l4.createRestNode(44);

l5.createfirstNode(5);
l5.createRestNode(150);
l5.createRestNode(550);

l6.createfirstNode(60);
l6.createRestNode(160);
l6.createRestNode(660);


System.out.print("\n=========================Q1=================================");
//Q1Search element
ll.searchElement(50);
ll.searchElement(54);
System.out.println("=========================Q2=================================");
//Q2sort-only change data
System.out.println("Q2 After sorting linkedlist : ");
quickSortLinkedList(ll.first,null);
ll.printList();
//Collections.sort(ll);
//Q3 Reseve linkedlist --only change data
System.out.println("\n=========================Q3=================================");
System.out.println("Q3 Reseve linkedlist : ");
ll.reversePrintList();
//ll.reversePrint();
System.out.println("\n=========================Q4=================================");
//Q4 Write a program to concatenate two lists into third new list
System.out.println("Concatenate two lists with creating third linked list");
concatenateWithNewList(l2.first,l3.first);
//Q5 without third list
System.out.println("\n=========================Q5=================================");
System.out.println("Concatenate two lists without creating third linked list");
concatenateWithOutNewList(l2.first,l3.first);
//Q6Write a program to merge two linked list into third new list
System.out.println("\n=========================Q6=================================");
l3.printList();
System.out.print("\n");
l4.printList();
System.out.println("\nMerge two linked list into third new list");
mergeWithNewList(l3.first,l4.first);//test not pass in l2 and l3 situation
System.out.println("\n=========================Q7=================================");
System.out.println("merge two linked list without third new list");
mergeWithOutNewList(l3.first,l4.first);
System.out.println("\n=========================Q8=================================");
System.out.println("After sorting two list are: ");
quickSortLinkedList(l5.first, null);
l5.printList();
quickSortLinkedList(l6.first,null);
System.out.print("\n");
l6.printList();
System.out.println("\nMerge two sorted linked list into third new list");
mergeSortWithNewList(l5.first,l6.first);
System.out.println("\n=========================Q9=================================");
System.out.println("merge two two linked list without third new list");

//Node merge = mergeSortWithOutNewList(l2.first,l3.first);
mergeSortWithOutNewList(l5.first,l6.first);

//Q10 search element and delete
System.out.println("\n=========================Q10=================================");

System.out.print("Q10 Enter the data which you want to delete");
ll.deleteNode(50);
ll.deleteNode(5);
System.out.println("\nAfter deleting the node : ");
ll.printList();
//Q11 Min & Max
System.out.println("\n=========================Q11=================================");
System.out.println("Q11 find smallest and greates element from the linked list");
ll.findMin();// an error when linkedlist only has 1 element.
ll.findMax();
//Q12
System.out.println("=========================Q12=================================");
System.out.println("Q12 Before reverse order the list is: ");
ll.printList();
System.out.println("\n    After reverse order the list is: ");
ll.reverseOrder();
System.out.println("\n=========================END=================================");
}
}
