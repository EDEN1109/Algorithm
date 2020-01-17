
public class Lab13Test {

    public static void main(String[] args) {
      
       double W=16;
       double[] profits = {40,30,50,10};
       double[] weights= {2,5,10,5};
       
       Knapsack ns=new Knapsack(profits, weights,W);
       
       System.out.println("Knapsack results based on Backtracking : ");
       System.out.println("Max profit : "+ ns.knapsackBT());
       System.out.println("Nodes : "+ ns.getNumNodes());
       System.out.println();
       System.out.println("Knapsack results based on B a B with Breadth First Search : ");
       System.out.println("Max profit : "+ ns.knapsakBFS());
       System.out.println("Nodes : "+ ns.getNumNodes());
       System.out.println();
       System.out.println("Knapsack results based on B a B with Best First Search : ");
       System.out.println("Max profit : "+ ns.knapsakBestFS());
       System.out.println("Nodes : "+ ns.getNumNodes());
    }
}
