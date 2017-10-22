
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

/**
 * Breadth first traversal structure
 */
public class BFS {
	
	private Queue<Integer> queue;
	private LinkedList<Integer> list;
	
	public BFS(){	
	}
	
	// Breadth first traversal
	public void bfs(int adj[][], int source, int end, BufferedWriter output) throws IOException{

		queue = new LinkedList<Integer>();
		list = new LinkedList<Integer>();

		int numNodes = adj[source].length - 1;
		
		
		int[] visited = new int[numNodes + 1];
		int i,j = 0, element;
		boolean found = false;
		
		visited[source] = 1;
		queue.add(source);
		list.add(source);
	
		while(!queue.isEmpty())
		{
			
			element = queue.remove();		
			i= 0;					
		
			while (i <= numNodes) {
				if (adj[element][end] == 1) {
					queue.add(end);
					list.add(end);
					found = true;
					break;
				}
				if (adj[element][i] == 1 && visited[i] == 0) {
					queue.add(i);
					list.add(i);
					visited[i] = 1;
				}
				i++;
			}
			if(found)break;

		}
		
		if(found){
			output.write(Arrays.toString(list.toArray()) + "\n");
			output.flush();

		}
		
		else{
			output.write("[" + source + ", -1, " + end + "]\n");
			output.flush();
		}
		
	}
	
	
}