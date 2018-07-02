package assignment4;

public class Board {

	//private int n=0;  //dimension
	private int num_ham=0;
	private int sum_man=0;
	private int[][] block;
	
	
	public Board(int[][] blocks)           // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    {
    	block
    	
    	
    }
    public int dimension()                 // board dimension n
    {
    	return block.length;
    }

    public int hamming()                   // number of blocks out of place
    {
    	
    	for(int i=0;i<n-1;i++) {
    		for(int j=0;j<n;j++){
    			if(block[i][j]!=i*n+j+1) num_ham++;
    		}
    	}
    	// last line
    	for(int j=0;j<n-1;j++) {
    		//i=n-1  last block is empty
    		if(block[n-1][j]!=(n-1)*n+j+1) num_ham++;
    		
    	}
    		
    	
    	return num_ham;
    }

    public int manhattan()  {
    	// sum of Manhattan distances between blocks and goal
    	int rest=0;
    	int x=0,y=0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++){
    			if(block[i][j]==i*n+j+1) continue;
    			else if(block[i][j]>i*n+j+1) {
    				rest= block[i][j]-(i*n+j+1);
    				y=rest/n;
    				x=rest%n;
    				if(x>n-1-j) {    // if need to add 1 for y
    					y++;
    					x=n-x;
    				}
    				sum_man=sum_man+x+y;
    			}else {
    				rest= (i*n+j+1)-block[i][j];
    				y=rest/n;
    				x=rest%n;
    				if(x>j) {       // y+1?
    					y++;
    					x=n-x;
    				}
    				sum_man=sum_man+x+y;
    			}
    		}
    	}
    
    		
    	
    	return sum_man;
    }

    public boolean isGoal()                // is this board the goal board?
    {
    	return num_ham==0;
    }

    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    {
    	
    }

    public boolean equals(Object y)        // does this board equal y?
    {
    	return block.equals(y);
    }

    public Iterable<Board> neighbors()     // all neighboring boards
    {
    	
    }

    public String toString()               // string representation of this board (in the output format specified below)
    {
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
