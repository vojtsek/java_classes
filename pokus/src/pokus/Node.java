package pokus;

public class Node {
	public Node left, right;
	  public int value;
	  Node(int v) {
	    left = null;
	    right = null;
	    value = v;
	  }
}

class Pair {
	  public Node node;
	  public boolean printed;

	  Pair(Node n) {
	    node = n;
	    printed = false;
	  }
}
