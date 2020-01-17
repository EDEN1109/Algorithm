
public class Node {
   
   private int level;
   private double profit;
   private double weight;
   private double bound;
   
   public Node() {
      this(0,0,0,0);
   }
   
   public Node(int level, double profit, double weight, double bound) {
      this.level = level;
      this.profit = profit;
      this.weight = weight;
      this.bound = bound;
   }

   public Node(Node u) {
      this.level = u.getLevel();
      this.profit = u.getProfit();
      this.weight = u.getWeight();
      this.bound = u.getBound();
   }

   @Override
   public String toString() {
      return "Node [level=" + level + ", profit=" + profit + ", weight=" + weight + ", bound=" + bound + "]";
   }
   public int getLevel() {
      return level;
   }
   public void setLevel(int level) {
      this.level = level;
   }
   public double getProfit() {
      return profit;
   }
   public void setProfit(double profit) {
      this.profit = profit;
   }
   public double getWeight() {
      return weight;
   }
   public void setWeight(double weight) {
      this.weight = weight;
   }
   public double getBound() {
      return bound;
   }
   public void setBound(double bound) {
      this.bound = bound;
   }
   

}