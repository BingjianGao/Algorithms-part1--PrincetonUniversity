package assignment3;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import edu.princeton.cs.algs4.Merge;

public class FastCollinearPoints {
	ArrayList<LineSegment> LineArray=new ArrayList<>();
	Point[] Parray;// copy of given point array

	public FastCollinearPoints(Point[] points) { // finds all line segments containing 4 points
		// TODO Auto-generated constructor stub
		if (points==null) 
			throw new java.lang.IllegalArgumentException();
		Parray=Arrays.copyOf(points, points.length);
		// sort points first
		//Arrays.sort(Parray); 
		Merge.sort(Parray);
		Point p0;
		for(int i=0;i<Parray.length-3;i++) {  // i<Parray.length-3 make sure at least have 4 points
			   p0=Parray[i];
			   double[] Before=new double[i];  //before size is i
			   for(int bi=0;bi<i;bi++) {
				   Before[bi]=p0.slopeTo(Parray[bi]);
			   }                               // before slope value array 
			   Arrays.sort(Before);    // for binary search later
			   Point[] After=Arrays.copyOfRange(points, i+1, points.length-1);
			   Arrays.sort(After, p0.slopeOrder());
			   
			   lineSeg(Before,p0,After);
			   
			   /*
			   for(int k=0;k<After.length-2;k++) {
				   p1=After[k];
				   p2=After[k+1];
				   p3=After[k+2];
				   double s1=p0.slopeTo(p1);
				   double s2=p0.slopeTo(p2);
				   double s3=p0.slopeTo(p3);
				   if(s1==s2&&s1==s3) {
					   Point[] pf= {p0,p1,p2,p3};
					   Arrays.sort(pf);
					   LineArray.add(new LineSegment(pf[0],pf[3]));
				   }
			   }
			   */
		   }
		   
	}
	
	private void lineSeg (double[] before, Point p0, Point[] after) {
		
		int num=1;
		double lastslope=Double.NEGATIVE_INFINITY;
		double slope=Double.NEGATIVE_INFINITY;
		
		for(int j=0;j<after.length;j++) {
			checking(p0,after[j]);
			slope=p0.slopeTo(after[j]);
			
			if(slope!=lastslope) {
				if(num>=3&&!existslope(before,slope))
					LineArray.add(new LineSegment(p0,Parray[j-1]));
				num=1;
					
			}else num++;
			lastslope=slope;
			
		}
		if(num>=3&&!existslope(before,slope))
			
			LineArray.add(new LineSegment(p0,Parray[Parray.length-1]));
		
		
	}
	private boolean existslope(double[] before,double slope) {
		
		int low=0;
		int high=before.length-1;
		
		while(low<=high) {
			int mid=low+(high-low)/2;
			
			if(before[mid]>slope) high=mid-1;
			else if(before[mid]<slope) low=mid+1;
			else return true;
		}
		
		return false;
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
		   return LineArray.toArray(new LineSegment[numberOfSegments()]);
	   }

}
