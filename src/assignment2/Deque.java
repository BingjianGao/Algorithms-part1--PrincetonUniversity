package assignment2;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node First;
	private Node Last;
	int Size;
	
	
	private class Node{
		private Item val;
		private Node next;
		private Node prev;
		public Node() {
			val=null;
			next=null;
			prev=null;
		}
	}
	
	   public Deque() {
		   // construct an empty deque
		   First=new Node();
		   Last= new Node();
		   
		   
	   }
	   
	   public boolean isEmpty() {
		   // is the deque empty?
		   return (Size==0);
		   
	   }
	   public int size() {
		   // return the number of items on the deque
		   return Size;
	   }
	   private void checkAdd(Item item) {
		   if(item==null)
			   throw new java.lang.IllegalArgumentException();
		   
	   }
	   
	   public void addFirst(Item item) {
		   // add the item to the front
		   checkAdd(item);
		   Node oldFirst=First;
		   if(size()==0) {
			   oldFirst.val=item;
			   First=oldFirst;
			   Last=oldFirst; 
		   }else {
			   First=new Node();
			   oldFirst.prev=First;
			   First.val=item;
			   First.next=oldFirst;
		   }
		   Size++;
		   
	   }
	   public void addLast(Item item){
		   // add the item to the end
		   checkAdd(item);
		   Node oldLast=Last;
		   if(size()==0) {
			   oldLast.val=item;
			   Last=oldLast;
			   First=oldLast;
		   }else {
			   Last=new Node();
			   oldLast.next=Last;
			   Last.val=item;
			   Last.prev=oldLast;
		   }
		   Size++;
		   
	   }
	   private void checkRemove() {
		   if(isEmpty())
			   throw new java.util.NoSuchElementException();
	   }
	   public Item removeFirst() {
		   // remove and return the item from the front
		   checkRemove();
		   Item result=First.val;
		   if(size()==1) {
			   First=null;
			   Last=null;
		   }else {
			   Node oldFirst=First.next;
			   oldFirst.prev=null;
			   First.next=null;
			   First=oldFirst;
		   }
		   
		   Size--;
		   return result;
		   
	   }
	   public Item removeLast() {
		   // remove and return the item from the end
		   checkRemove();
		   Item result=Last.val;
		   if(size()==1) {
			   First=null;
			   Last=null;
		   }else {
			   Node oldLast= Last.prev;
			   oldLast.next=null;
			   Last.prev=null;
			   Last=oldLast;
		   }
		   
		   Size--;
		   return result;
		   
	   }
	   public Iterator<Item> iterator(){
		   // return an iterator over items in order from front to end
		   return new DequeIterator<Item>();
	   }
	   private class DequeIterator<Item> implements Iterator<Item>{
		   private Node current=First;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return (current!=null);
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item value=(Item) current.val;
			current=current.next;
			return value;
		}
		   
	   }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> test=new Deque<>();
		test.addFirst("i");
		test.addFirst("am");
		test.addLast("ben");
		test.addLast("who");
		for (String s:test) {
			System.out.println(s);
		}
		System.out.println(test.removeFirst());
		System.out.println(test.removeFirst());
		System.out.println(test.removeFirst());
		System.out.println(test.removeFirst());
		
		System.out.println(test.removeFirst());

	}

}
