import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Knapsack {

	private double[] p;
	private double[] w;
	private double W;
	private int n;
	private int numNodes;

	public int getNumNodes() {
		return numNodes;
	}

	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}

	public Knapsack(double[] profits, double[] weights, double W) {

		int i;
		numNodes=0;

		n=profits.length;
		p=new double[n+1];

		for(i=1;i<=n;i++) {
			p[i]=profits[i-1];
		}

		w= new double[n+1];

		for(i=1;i<=n;i++) {
			w[i]=weights[i-1];
		}
		this.W=W;
	}

	private double bound(Node u) {

		int j,k;
		double totalWeight;
		double bound;

		if(u.getWeight() >=W) {
			bound=0; 
		}
		else { 
			bound=u.getProfit();
			j=u.getLevel()+1;
			totalWeight=u.getWeight();
			while (j<=n && totalWeight+w[j]<=W) {
				totalWeight=totalWeight+w[j];
			bound=bound+p[j];
			j++;
			}
			k=j;
			if(k<=n) { // compute bound
				bound=bound+(W-totalWeight) *((float) p[k])/w[k];
			}
		}
		return bound;

	}


	public double knapsackBT() {

		Stack<Node> S = new Stack<Node>();
		double maxProfit=0;
		Node v=new Node();
		v.setBound(bound(v));
		S.push(v); // add to stack
		numNodes=1;
		System.out.println("Root Node : " + v.toString());

		while(!S.isEmpty()) { 
			v=S.pop();
			Node u=new Node();
			u.setLevel(v.getLevel()+1); // child Node
			u.setWeight(v.getWeight()+w[u.getLevel()]);
			u.setProfit(v.getProfit()+p[u.getLevel()]);
			
			if(u.getWeight()<=W && u.getProfit()>maxProfit) { 
				maxProfit=u.getProfit(); // change max profit
			}
			u.setBound(bound(u));
			if(bound(u)>maxProfit) { // promising
				S.push(u); // add to right Node
				numNodes++;
				System.out.println("Right Node : " + u.toString());
			}

			Node x=new Node();
			x.setLevel(v.getLevel()+1);
			x.setWeight(v.getWeight());
			x.setProfit(v.getProfit());
			x.setBound(bound(x));

			if(bound(x)>maxProfit) { // promising
				S.push(x); // add to left Node
				numNodes++;
				System.out.println("Left Node : " + x.toString());
			}

		}
		return maxProfit;
	}

	public double knapsakBFS(){

		Queue<Node> Q = new LinkedList<Node>();
		double maxProfit=0;
		Node v=new Node();
		v.setBound(bound(v));
		Q.add(v); // 큐에 추가
		numNodes=1;
		System.out.println("Root Node : " + v.toString());
		while(!Q.isEmpty()) {
			v=Q.remove();
			Node u=new Node();
			u.setLevel(v.getLevel()+1);
			u.setWeight(v.getWeight()+w[u.getLevel()]);
			u.setProfit(v.getProfit()+p[u.getLevel()]);
			if(u.getWeight()<=W && u.getProfit()>maxProfit) {
				maxProfit=u.getProfit();
			}
			u.setBound(bound(u));
			if(bound(u)>maxProfit) {
				Q.add(u);
				numNodes++;
				System.out.println("Right Node : " + u.toString());
			}
			Node x=new Node();
			x.setLevel(v.getLevel()+1);
			x.setWeight(v.getWeight());
			x.setProfit(v.getProfit());
			x.setBound(bound(x));

			if(bound(x)>maxProfit) {
				Q.add(x);
				numNodes++;
				System.out.println("Left Node : " + x.toString());
			}
		}
		return maxProfit;
	}


	public double knapsakBestFS() {

		Comparator<Node> comparator=new NodeCompare();
		Queue<Node> PQ = new PriorityQueue<Node>(n,comparator);
		double maxProfit=0;
		Node v=new Node();
		v.setBound(bound(v));

		PQ.add(v);
		numNodes=1;
		System.out.println("Root Node : " + v.toString());
		while(!PQ.isEmpty()) {
			v=PQ.remove();
			if(v.getBound()>maxProfit) {
				Node u=new Node();
				u.setLevel(v.getLevel()+1);
				u.setWeight(v.getWeight()+w[u.getLevel()]);
				u.setProfit(v.getProfit()+p[u.getLevel()]);

				if(u.getWeight()<=W && u.getProfit()>maxProfit) {
					maxProfit=u.getProfit();
				}
				u.setBound(bound(u));
				if(bound(u)>maxProfit) {
					PQ.add(u);
					numNodes++;
					System.out.println("Right Node : " + u.toString());
				}

				Node x=new Node();
				x.setLevel(u.getLevel());
				x.setWeight(v.getWeight());
				x.setProfit(v.getProfit());
				x.setBound(bound(x));

				if(bound(x)>maxProfit) {
					PQ.add(x);
					numNodes++;
					System.out.println("Left Node : " + x.toString());
				}
			}
		}
		return maxProfit;
	}

}