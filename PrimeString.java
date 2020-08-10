package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	Node() {

	}

	Node(T data, Node<T> parent, List<Node<T>> children) {
		this.data = data;
		this.parent = parent;
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

// -----
public class PrimeString {
	static final Integer MOD = 1000000007;
	static List<List<String>> result = new ArrayList<>();
	static Tree<String> dataTree = null;;

	public static void preorder(List<String> list, Node<String> node) {

		// skip adding root data(input string) to list as it is not needed for
		// output
		if (!dataTree.getRoot().getData().equals(node.getData()))
			list.add(node.getData());

		List<Node<String>> children = node.getChildren();
		if (children.size() > 0) {
			for (Node<String> n : children) {
				preorder(list, n);
				list.remove(list.size() - 1);
			}
		} else {
			if(list.stream().noneMatch((e) -> e.startsWith("0")))
				result.add(new ArrayList<>(list));
			
			//result.add(new ArrayList<>(list.stream().filter((e)->!e.startsWith("0")).collect(Collectors.toList())));
			
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

	/*
	 * fn(73) = 73 + fn(7) + fn(3)
	 */
	// 11373
	public static void generatePrimeStrings(Node<String> parentNode, String s) {
		// String s= parentNode.getData();

		for (int i = 1; i <= s.length(); i++) {

			Integer num = Integer.parseInt(s.substring(0, i));

			if (isPrime(num)) {

				Node<String> node = new Node<String>(s.substring(0, i), parentNode, new ArrayList<>());
				
				parentNode.getChildren().add(node);
				generatePrimeStrings(node, s.substring(i));
			}

		}
		

	}

	static int countPrimeStrings(String number) {
		if(number.startsWith("0"))
			return 0;
		dataTree = new Tree<String>(number);

		generatePrimeStrings(dataTree.getRoot(), number);
		// System.out.println(dataTree);
		List<String> list = new ArrayList<>();

		preorder(list, dataTree.getRoot());
		
		return (result.size() % MOD);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String input = "3175";
		String input = "1137311";
		
		System.out.println(countPrimeStrings(input));
		System.out.println(result);

	}

}
