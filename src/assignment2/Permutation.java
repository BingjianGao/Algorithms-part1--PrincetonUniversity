package assignment2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=Integer.parseInt("3");
		
		
		RandomizedQueue<String> test=new RandomizedQueue<>();
		/*
		test.enqueue("a");
		test.enqueue("b");
		test.enqueue("c");
		test.enqueue("d");
		test.enqueue("e");
		test.enqueue("f");
		test.enqueue("g");
		*/
		while(!StdIn.isEmpty()) {
			String s= StdIn.readString();
			test.enqueue((String)s);
			System.out.println(s);
		}
		System.out.println("hello");
		
		Iterator<String> it=test.iterator();
		for(int i=0;i<k;i++) {
			System.out.println(it.next());
		}
		
		/*
		int k = 3;//Integer.parseInt(args[0]);
        RandomizedQueue<String> input = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            input.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(input.dequeue());
        }
		
		/*
		        int k = Integer.parseInt(args[0]);
		        RandomizedQueue<String> queue = new RandomizedQueue<String>();
		        String s;
		        System.out.print("type here>>>");
		        s = StdIn.readString();
		        System.out.println(s);
		        while (!StdIn.isEmpty()) {
		            s = StdIn.readString();
		            queue.enqueue(s);
		        }
		        System.out.println(queue.dequeue());
		        System.out.println(queue.dequeue());
		        

		        Iterator<String> iterator = queue.iterator();
		        for (int i = 0; i < k; i++) {
		            String item = iterator.next();
		            StdOut.println(item);
		        }
		    
		
		
		/*
		
		
		
		
		*/

	}

}
