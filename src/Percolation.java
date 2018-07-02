import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;



public class Percolation {
	private WeightedQuickUnionUF uf;
	private int[] Open;
	private int size;
	private int NumOfOpen;
	
	//constructor
	public Percolation(int n) {
		size=n;
		uf= new WeightedQuickUnionUF(n*n+2);
		Open=new int[n*n+2];
		for(int i=0;i<Open.length;i++) {
			Open[i]=0;
		}
		Open[0]=1;  //add extra top site
		Open[n*n+1]=1;  //add extra bottom site
		
		//for(int i=1;)
		//uf.union(0,1);
		
		
	}
	
	public void open(int row,int col) { // open site (row, col) if it is not open already
		int Index=(row-1)*size+col;
		int Up=(row-2)*size+col;
		int Down=row*size+col;
		int Left=Index-1;
		int Right=Index+1;
		
		if(row<1||col>size) {
			throw new IllegalArgumentException ("out of size");
		}
		if (!isOpen(row,col)) {
			Open[Index]=1;
			NumOfOpen++;
			
			// check surrounding and union them
			// first row and last row
			if(row==1) {
				if(col==1) {  // upper left site
					if(isOpen(row,col+1)) {
						uf.union(Index, Right);
					}
					if(isOpen(row+1,col)) {
						uf.union(Index, Down);
					}
					
				}else if(col==size) { //upper right site
					if(isOpen(row,col-1)) {
						uf.union(Index,Left);
					}
					if(isOpen(row+1,col)) {
						uf.union(Index,Down);
					}
					
				}else {         // other sites in first row
					if(isOpen(row,col-1)) {
						uf.union(Index,Left);
					}
					if(isOpen(row,col+1)) {
						uf.union(Index, Right);
					}
					if(isOpen(row+1,col)) {
						uf.union(Index,Down);
					}
					
				}
				uf.union(0,Index);
				
			}else if(row==size){  //check last row  
				if(col==1) {  // bottom left site
					if(isOpen(row,col+1)) {
						uf.union(Index, Right);
					}
					if(isOpen(row-1,col)) {
						uf.union(Index, Up);
					}
				}else if(col==size) {
					if(isOpen(row,col-1)) {
						uf.union(Index,Left);
					}
					if(isOpen(row-1,col)) {
						uf.union(Index,Up);
					}
					
				}else {
					if(isOpen(row,col-1)) {
						uf.union(Index,Left);
					}
					if(isOpen(row,col+1)) {
						uf.union(Index, Right);
					}
					if(isOpen(row-1,col)) {
						uf.union(Index,Up);
					}
				}
				uf.union(Index,size*size+1);
			}else {    // check other rows
				if(col==1) {  // left site
					if(isOpen(row,col+1)) {
						uf.union(Index, Right);
					}
					if(isOpen(row-1,col)) {
						uf.union(Index, Up);
					}
					if(isOpen(row+1,col)) {
						uf.union(Index,Down);
					}
				}else if(col==size) {
					if(isOpen(row,col-1)) {
						uf.union(Index,Left);
					}
					if(isOpen(row+1,col)) {
						uf.union(Index,Down);
					}
					if(isOpen(row-1,col)) {
						uf.union(Index, Up);
					}
				}else {
					if(isOpen(row,col-1)) {
						uf.union(Index,Left);
					}
					if(isOpen(row,col+1)) {
						uf.union(Index, Right);
					}
					if(isOpen(row-1,col)) {
						uf.union(Index,Up);
					}
					if(isOpen(row+1,col)) {
						uf.union(Index,Down);
					}
				}
			}
			
		}
		
	}
	
	public boolean isOpen(int row,int col) {// is site (row, col) open?
		if(row<1||col>size) {
			throw new IllegalArgumentException ("out of size");
		}
		int Index=(row-1)*size+col;
		if(Open[Index]==1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull(int row, int col) {// is site (row, col) full?
		if(row<1||col>size) {
			throw new IllegalArgumentException ("out of size");
		}
		int Index=(row-1)*size+col;
		return uf.connected(0, Index);
		
	}
	
	public int numberOfOpenSites() {// number of open sites
		
		return NumOfOpen;	
	}
	
	public boolean percolates() {// does the system percolate?
		
		return uf.connected(0, size*size+1);
	}
	
	public static void main(String[] args) {
		int n=100;
		Percolation test=new Percolation(n);
		int row;
		int col;
		
		while(!test.percolates()) {
			row=StdRandom.uniform(1,n+1);
			col=StdRandom.uniform(1,n+1);
			test.open(row, col);
			
		}
		System.out.println(test.numberOfOpenSites());
	}
	
}
