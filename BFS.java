//BFS-Breadth first search traversal in graph
//take a strating point and visit every node level wise


import java.util.*;

class BFS{

	static class Edge{
		int src;
		int dest;

		public Edge(int src, int dest){
			this.src = src;
			this.dest = dest;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[]){
		for(int i=0;i<graph.length;i++){
			graph[i] = new ArrayList<Edge>();           //create empty arraylist at every index of array
		}

		graph[0].add(new Edge(0,1));      //add edges for every vertex
		graph[0].add(new Edge(0,2)); 

		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));  

		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));
		
		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5)); 

		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));  

		graph[5].add(new Edge(5,3));   
		graph[5].add(new Edge(5,4));     
		graph[5].add(new Edge(5,6));

		graph[6].add(new Edge(6,5));              

	}

	public static void bfs(ArrayList<Edge> graph[],int V,boolean vis[],int start){

		Queue<Integer> q = new LinkedList<>();      //make a queue to track elements
		
		q.add(start);                            //add a starting point(vertex) for traversal

		while(!q.isEmpty())
		{
			int curr = q.remove();
			if(vis[curr] == false)           //means curr is not yet visited
			{
				System.out.print(curr+" ");   //print it
				vis[curr] = true;				//mark as visited-True

				for(int i=0; i<graph[curr].size();i++){       //now add neighbors of curr
					Edge e = graph[curr].get(i);		//for that..run a loop from 0 to curr.size to get all edges at that index or of that edge
					q.add(e.dest);						////then, add that edge destination in queue.									
				}
			}														
		}
	} 



	public static void main(String args[]){
		int V = 7;   //size of graph / total no of vertices

				//int arr[] = new int[size]
		ArrayList<Edge> graph[] = new ArrayList[V];    //Array named graph of Arraylists with diff edges
		createGraph(graph);

		boolean vis[] = new boolean[V];          //a boolen array named vis to track visited nodes with size V
		for(int i=0;i<V;i++)					//a loop to check if all vertices are visited or not
		{
			if(vis[i]==false)					//means i is not yet visited
			{
				bfs(graph,V,vis,i);					
			}
		}
		System.out.println();
	}
}