package pokus;

import java.util.Iterator;
import java.util.Stack;

public class MyTree implements Iterable {
	public Node root;

	  MyTree() {
	    root = null;
	  }

	  public Iterator iterator() {
	    return new Iterator() {
	      private byte direction = 0; 
	      private Stack<Pair> st = new Stack();
	      public boolean hasNext() {
	        if (direction == 1 && st.empty())
	          return false;
	        return true;
	      }  
	      public Object next() {
	        Node ret;
	        if (st.empty() && direction == 0) {
	          st.push(new Pair(root));
	        }  
	        if (direction == 0) {
	          while(st.peek().node.left != null) {
	            st.push(new Pair(st.peek().node.left));
	          }  
	          ret = st.peek().node;
	          if (ret.right != null) {
	            direction = 0; 
	            st.peek().printed = true;
	            st.push(new Pair(ret.right));
	            return ret;
	          }  
	          direction = 1;
	          st.pop();
	          return ret;
	        }
	        while (st.peek().printed)
	          st.pop();
	        if (st.empty()) return root;
	        ret = st.peek().node;
	        st.peek().printed = true;
	        if (st.peek().node.right != null) {
	          direction = 0;
	          st.push(new Pair(st.peek().node.right));
	        }
	        return ret;
	      }
	      
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	    };
	  }

	  public void insert(int v) {
	    if (root == null) {
	      root = new Node(v);
	      return;
	    }
	    if (_find(v, root) != null) {
	      return;
	    }
	    _add(v, root);
	  }
	  private void _add(int v, Node n) {
	    if (v < n.value) {
	      if (n.left == null) {
	        n.left = new Node(v);
	        return;
	      }
	      _add(v, n.left);
	      return;
	    }
	    if (n.right == null) {
	      n.right = new Node(v);
	      return;
	    }
	    _add(v, n.right);
	  }
	  
	  private Node _find(int v, Node n) {
		  if (n.value == v) {
			  return root;

		  	}
		  if (v < n.value) {
			  if (n.left == null) {
				  return null;
			  }
			  return _find(v, n.left);
		  }
		  if (n.right == null) {
			  return null;
		  }
		  return _find(v, n.right);
	  }
}