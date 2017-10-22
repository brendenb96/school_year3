
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryTree {
	
	public static Node root;
	
	BinaryTree(){
		this.root = null;
	}
			
	public void insert(String id)
	{
		Node newNode = new Node(id);
		if(root == null)
		{
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true)
		{
			parent = current;
			if(id.substring(8, 32).compareTo(current.studentlastname) < 0)
			{
				current = current.left;
				if(current == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				current = current.right;
				if(current == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public boolean isEmpty()
	{
		return (root == null);
	}
	
	public void printDepth(Node current,BufferedWriter out) throws IOException{
		out.write("Depth-first, In-order:\n");
		out.write("Last Name               Student Number | Home Department | Program | Year \n");
		inOrdertoFile(current,out);
	}
	public void printBreadth(Node current,BufferedWriter out) throws IOException{
		out.write("Breadth-first, In-order:\n");
		out.write("Last Name               Student Number | Home Department | Program | Year \n");
		breadthtoFile(current,out);
	}
	public void inOrdertoFile(Node current,BufferedWriter out) throws IOException{
		if(current != null){
			inOrdertoFile(current.left,out);
			System.out.print(current.toString());
			out.write(current.toString());
			inOrdertoFile(current.right,out);
		}
	}

	public void breadthtoFile(Node root, BufferedWriter out) throws IOException {
		LinkedListQueue queue = new LinkedListQueue();
		Node node = root;
		if (node != null) {
			queue.enqueue(node);
			while (!queue.isEmpty()) {
				node = queue.dequeue();
				visit(node, out);
				if (node.left != null)
					queue.enqueue(node.left);
				if (node.right != null)
					queue.enqueue(node.right);
			}
		}

	}
	public void visit(Node p, BufferedWriter out) throws IOException {
		System.out.print(p.toString());
		out.write(p.toString());
	}

	public void preOrder(Node root)
	{
		if(root == null) return;
		
		System.out.println(root.element);
		preOrder(root.left);
		preOrder(root.right);
		
	}

	public void postOrder(Node root)
	{
		if(root == null) return;
		
		preOrder(root.left);
		preOrder(root.right);
		
		System.out.println(root.element);
	
	}	
	public boolean find(String id){
		Node current = root;
		while(current!=null){
			int comp = id.compareTo(current.studentlastname);
			if(comp==0){
				return true;
			}else if(comp<0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public void delete(Node root, String key)
	{
		if(!find(key))System.out.println("No Record to delete.");
	 	else root = deleteRec(root, key);
		
	}
	
	public Node deleteRec(Node root, String key)
	{
		if(root == null) 
		{
			return root;
		}
		int comp = key.compareTo(root.studentlastname);
		if(comp < 0)
		{
			root.left = deleteRec(root.left, key);
		}			
		else if(comp > 0)
		{
			root.right = deleteRec(root.right, key);
		}
	
		else if(comp == 0)
		{
			if(root.left == null) 
			{
				return root.right;
			}
		
			else if(root.right == null)
			{
				return root.left;
			}
			root.studentlastname = minValue(root.right);
			root.right = deleteRec(root.right, root.studentlastname);
		}

		return root;
	}
	
	public String minValue(Node root)
	{
		String min = root.studentlastname;
		while(root.left != null)
		{
			min = root.left.studentlastname;
			root = root.left;
		}
		return min;
	}
	
}
