package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
	
	//private int Nums;
	//private Point[] Parray;
	ArrayList<LineSegment> LineArray=new ArrayList<>();
	Point[] Parray;// copy of given point array

	public BruteCollinearPoints(Point[] points) { // finds all line segments containing 4 points
		// TODO Auto-generated constructor stub
		if (points==null) 
			throw new java.lang.IllegalArgumentException();
		Parray=Arrays.copyOf(points, points.length);
		   Point p0,p1,p2,p3;  // four points in the same line
		   double s1,s2,s3;  //  slope
		   for(int i=0;i<Parray.length;i++) {
			   p0=Parray[i];
			   for(int j=i+1;j<Parray.length;j++) {
				   p1=Parray[j];
				   checking(p0,p1);
				   s1=p0.slopeTo(p1);
				   for(int k=j+1;k<Parray.length;k++) {
					   p2=Parray[k];
					   s2=p0.slopeTo(p2);
					   if(s1==s2) {
						   for(int l=k+1;l<Parray.length;l++) {
							   p3=Parray[l];
							   s3=p0.slopeTo(p3);
							   if(s3==s1) {
								   
								   Point[] line={p0,p1,p2,p3};
								   Arrays.sort(line);  // sort 4 points
								   LineArray.add(new LineSegment(line[0],line[3]));
							   }
						   }
					   }
				   }
			   }
		   }
		   
	}
	
	
	private void checking(Point a, Point b) {
		if(a==null||b==null) {
			throw new java.lang.IllegalArgumentException();
		}
		if(a.compareTo(b)==0) {
			throw new java.lang.IllegalArgumentException();
		}
	}
	
	   public  int numberOfSegments()  {
		   // the number of line segments
		   return LineArray.size();
	   }
	   
	   public LineSegment[] segments() {
		   /*
		   // the line segments
		   // for loop defined p0
		   //LineSegment[] result=new LineSegment[Parray.length/4];
		   // can use arraylist , easier
		   ArrayList<LineSegment> result=new ArrayList<>();
		    
		   Point[] line=new Point[4]; // point array to store 4 points that are  in the same line
		   Point p0,p1,p2,p3;  // four points in the same line
		   double s1,s2,s3;  //  slope
		   for(int i=0;i<Parray.length;i++) {
			   p0=Parray[i];
			   for(int j=i+1;j<Parray.length;j++) {
				   p1=Parray[j];
				   s1=p0.slopeTo(p1);
				   for(int k=j+1;k<Parray.length;k++) {
					   p2=Parray[k];
					   s2=p0.slopeTo(p2);
					   if(s1==s2) {
						   for(int l=k+1;l<Parray.length;l++) {
							   p3=Parray[l];
							   s3=p0.slopeTo(p3);
							   if(s3==s1) {
								   line[0]=p0;
								   line[1]=p1;
								   line[2]=p2;
								   line[3]=p3;
								   Arrays.sort(line);  // sort 4 points
								   result[Nums]=new LineSegment(line[0],line[3]);
								   Nums++;   
							   }
						   }
					   }
				   }
			   }
		   }
		   //LineSegment[] fa=Arrays.copyOfRange(result, 0, Nums-1); // keep only meanful Linesegment
		   */ // move to constructor;
		   
		   return LineArray.toArray(new LineSegment[numberOfSegments()]);
	}

}
