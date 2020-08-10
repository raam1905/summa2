/*package hackerrank;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

class Tree<T> {
	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	

	public Tree(T data) {
		// Node node = new Node();

		root = new Node<T>();
		root.setData(data);// rootData;
		root.setChildren(new ArrayList<Node<T>>());
	}

}

class Node<T> {
	private T data;
	private Node<T> parent;
	private List<Node<T>> children;
	
	Node(){
		
	}
	Node(T data, Node<T> parent, List<Node<T>> children){
		this.data = data;
		this.parent=parent;
		this.children = children;
		
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public List<Node<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}

}

public class PrimeString2 {

	static List result= new ArrayList();
	static Tree dataTree =null;;

	public static void preorder(List list, Node node){
		System.out.println(node.getData());
		list.add(node.getData());
		
		List<Node> children = node.getChildren();
		if(children.size() > 0){
			for(Node n: children){
				preorder(list,n);
			}
		}
		else{
			result.add(new ArrayList(list));
			list.remove(node.getData());
				
		}
	}
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}
	
	 * fn(73) = 73 + fn(7) + fn(3)
	 
//11373
	public static int  primeStringv3(Node<String> parentNode, String s){
		//String s= parentNode.getData();
		
		for(int i=1;i<=s.length();i++){
			
				int num = Integer.parseInt(s.substring(0,i));
				
				if(isPrime(num)){
					
					Node<String> node= new Node(num,parentNode,new ArrayList<>());
					parentNode.getChildren().add(node);
					primeStringv3(node,s.substring(i));
				}
				
		}
		return 0;
		
	}

	
	public static int primeString(List result, String s) {

		// int num = Integer.parseInt(s); //(73)

		List partition = null;
		
		 * if(isPrime(num)){ partition = new ArrayList(); partition.add(num);
		 * result.add(partition)); }
		 
		for (int i = 1; i <= s.length(); i++) {
			// primeList = new ArrayList();
			int num = Integer.parseInt(s.substring(0, i));
			// System.out.println(" " +num);
			if (isPrime(num)) {
				// 3
				// create Parition
				
				 * if (result.size()==0){ partition = new ArrayList();
				 * partition.add(num); result.add(partition); }
				 

				// generate combination

				String subString = s.substring(i);

				// System.out.println(subString);

				// result.add(primeList);
				
				 * List a = primeString(subString); if(a != null)
				 * primeList.addAll(primeString(subString));
				 

				
				 * System.out.print(num + " ");
				 * System.out.println(s.substring(i));
				 
			}

		}
		// System.out.println(primeList);
		System.out.println("result" + result);
		return (Integer) null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "11373";
		dataTree = new Tree<String>(input);
		List a = new ArrayList();
		primeStringv3(dataTree.getRoot(), input);
		//System.out.println(dataTree);
		List list = new ArrayList();
		preorder(list,dataTree.getRoot());
		System.out.println(result);
		
	}

}
*/