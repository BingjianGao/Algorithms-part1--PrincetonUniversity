import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private Percolation Sites;
	private int Size;
	private int trial;
	private double nums;
	double mean;
	double stddev;
	
	public PercolationStats(int n, int trials) {
		// perform trials independent experiments on an n-by-n grid
		Sites=new Percolation(n);
		Size=n;
		trial=trials;
		nums=Size*Size;
		
	}
	private double[] percolateRate() {
		   int row;
		   int col;
		   double []rate=new double[trial];
		   for(int i=0;i<trial;i++) {
			   while(!Sites.percolates()) {
					row=StdRandom.uniform(1,Size+1);
					col=StdRandom.uniform(1,Size+1);
					Sites.open(row, col);
					}
			   rate[i]=Sites.numberOfOpenSites()/nums;
			   Sites=new Percolation(Size);
			  // System.out.println(rate[i]);
			}
		   return rate;
	}
	
	   public double mean()  {
		   // sample mean of percolation threshol
		   mean=StdStats.mean(percolateRate());
		   return mean;
	   }
	   public double stddev()             {
		   // sample standard deviation of percolation threshold
		   
		   stddev=StdStats.stddev(percolateRate());
		   return stddev;
	   }
	   public double confidenceLo() {
		   // low  endpoint of 95% confidence interval
		   
		   return (mean-(1.96*stddev/(Math.sqrt(trial))));
	   }
	   public double confidenceHi() {
		   // high endpoint of 95% confidence interval
		   
		   return (mean+(1.96*stddev/(Math.sqrt(trial))));
	   }

	   public static void main(String[] args) {
		   // test client (described below)
		   PercolationStats test=new PercolationStats(200,100);
		  
		  // test.percolateRate();
		   System.out.println("Percolation"+"   "+test.Size+"  "+test.trial);
		   System.out.println("mean:    "+"="+test.mean());
		   System.out.println("standard deviation:  ="+test.stddev());
		   System.out.println("95% confidence  =["+test.confidenceLo()+", "+test.confidenceHi()+" ]");
		   
		   
		   
		   
		   
	   }

}
