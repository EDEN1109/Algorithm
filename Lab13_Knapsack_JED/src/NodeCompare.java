import java.util.Comparator;

public class NodeCompare implements Comparator<Node>{
   public int compare(Node one, Node two) {
      return (int)(two.getBound()-one.getBound());
   }
}