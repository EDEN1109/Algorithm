import java.util.ArrayList;

public class Node implements Comparable<Node>{
   private ArrayList<Integer> path;
   private int bound;
   private int level;
   
   
   public Node(ArrayList<Integer> path, int city, int bound, int level) {
      this.path = path;
      this.path.add(city);
      this.bound = bound;
      this.level = level;
   }
   public Node() {
      this.path = new ArrayList<Integer>();
      this.bound = 0;
      this.level = 0;
   }
   
   public Node(ArrayList<Integer> path2, int level2, int bound2) {
      this.path = path2;
      this.bound = bound2;
      this.level = level2;
   }
   
   public int computeLength(int[][] distanceMatrix) {
      int distance=0;
      for(int i=0;i<this.getPath().size()-1;i++) {
         distance = distance + distanceMatrix[this.getPath().get(i)][this.getPath().get(i+1)];
      }
      return distance;
   }
   public ArrayList<Integer> getPath() {
      return path;
   }
   public void setPath(ArrayList<Integer> path) {
      this.path = new ArrayList<>(path);
   }
   public int getBound() {
      return bound;
   }
   public void setBound(int bound) {
      this.bound = bound;
   }
   public int getLevel() {
      return level;
   }
   public void setLevel(int level) {
      this.level = level;
   }
   
   public int compareTo(Node n) {
      return this.bound-n.bound;
   }
}