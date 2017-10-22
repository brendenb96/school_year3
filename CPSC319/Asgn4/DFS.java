
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

/**
 * Depth first traversal structure
 */
public class DFS {
	
	private Stack<Integer> stack;

	public DFS(){
	}
	
	// Depth first traversal
	public void dfs(int adj[][], int source, int end, BufferedWriter output) throws IOException{

		stack = new Stack<Integer>();
		int numNodes = adj[source].length - 1;
		int [] visited = new int[numNodes + 1];
		int element = source;
		int i = source;
		boolean found = false;

		visited[source] = 1;
		stack.push(source);
		
		while(!stack.isEmpty())
		{
			element = stack.peek();
			i = 0;

			while (i <= numNodes) {
				if (adj[element][end] == 1) {
					stack.push(end);
					found = true;
					break;
				}
				if (adj[element][i] == 1 && visited[i] == 0) {
					stack.push(i);
					visited[i] = 1;
					element = i;
					continue;
				}
				i++;

			}
			if(found)break;
			stack.pop();
			
		}
		if(found){
			output.write(Arrays.toString(stack.toArray()) + "\n");
			output.flush();}
		
		else {
			output.write("[" + source + ", -1, " + end + "]\n");
			output.flush();}

	}
	
	
}
