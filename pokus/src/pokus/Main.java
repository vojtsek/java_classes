package pokus;

public class Main {
	public static void main(String[] args){
		MyTree bt = new MyTree();
	    for (String arg : args) {
	        try {
	          bt.insert(Integer.parseInt(arg));
	        } catch (NumberFormatException e) {
	          System.out.println("Please insert only integers!");
	        }
	      }
	      for (Object n : bt) {
	        System.out.println(((Node) n).value);
	      }
	    }
}
