package assignment2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>  {
	private Item[] array;
	//private int Size;
	private int N;
	
	
	
	public RandomizedQueue() {
		// construct an empty randomized queue
		array=(Item[]) new Object[1]; 
		//Size=0;
		N=0;
		
	}
	   public boolean isEmpty() {
		   // is the randomized queue empty?
		   return N==0;
	   }
	   public int size() {
		   // return the number of items on the randomized queue
		   return N;
	   }
	   private void resize(int newLength) { // resize capacity double
		   Item[] copy=(Item[]) new Object[newLength];
		   for(int i=0;i<N;i++) {
			   copy[i]=array[i];
		   }
		   array=copy;
		   
	   }
	   public void enqueue(Item item) {
		   // add the item
		   if(item==null) {
			   throw new java.lang.IllegalArgumentException();
		   }
		   if(N==array.length) resize(2*array.length);
		   array[N++]=item;
		   
	   }
	   /*// the same as resize
	   private void desize(int Len) {
		   Item[] copy=(Item[])new Object[Len];
		   for(int i=0;i<N;i++) {
			   copy[i]=array[i];
		   }
		   array=copy;
	   }*/
	   public Item dequeue() {
		   // remove and return a random item
		   if(isEmpty()) {
			   throw new java.util.NoSuchElementException();
		   }
		   if(N>0&&N==array.length/4) resize(array.length/2);
		   int Index = StdRandom.uniform(0, N);
		   Item result=array[Index];
		   array[Index]=array[N-1];
		   array[N-1]=result;
		   
		   return array[--N];
	   }
	   
	   public Item sample() {
		   // return a random item (but do not remove it)
		   if(isEmpty()) {
			   throw new java.util.NoSuchElementException();
		   }
		   
		   int Index=StdRandom.uniform(0, N);
		   Item result=array[Index];
		  // array[Index]=array[N-1];
		   //array[N-1]=result;
		   //N--;
		   return result;
	   }
	   //method 1
	   /*
	   private class RandomIterator<Item> implements Iterator<Item>{
		   private int i=N;
		   private Item[] iterat=(Item[])array;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			int Index=StdRandom.uniform(0, i);
			Item result=iterat[Index];
			iterat[Index]=iterat[i-1];
			iterat[i-1]=result;
			return iterat[--i];
		}
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
		   
	   }*/
	   
	   //method 2
	   private class RandomIterator<Item> implements Iterator<Item>{
		   private int counter;
		   private Item[] temp;
		   
		   private RandomIterator(){  //private RandomIterator<Item> shouldn't include <Item>
			   counter=0;
			   temp=(Item[])new Object[N];
			   for(int i=0;i<N;i++) {
				   temp[i]=(Item) array[i];
			   }
			   StdRandom.shuffle(temp);
		   }

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return counter<N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			return temp[counter++];
		}
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
		   
	   }
	   
	   @Override
		public Iterator<Item> iterator() {
			// TODO Auto-generated method stub
			return new RandomIterator<Item>();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	
	

}
