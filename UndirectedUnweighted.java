//creating undirected and unweighted graph using Adjecency list method.

import java.util.*;

class UndirectedUnweighted{

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

		graph[0].add(new Edge(0,2));      //add edges for every vertex

		graph[1].add(new Edge(1,2));
		graph[1].add(new Edge(1,3));  

		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,1));
		graph[2].add(new Edge(2,3));

		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,2));    

	}

	public static void main(String args[]){
		int V = 4;   //size of graph / total no of vertices

				//int arr[] = new int[size]
		ArrayList<Edge> graph[] = new ArrayList[V];    //Array named graph of Arraylists with diff edges
		createGraph(graph);

		//print neighbors of vertices

		//neigbors of 0
		for(int i=0;i<graph[0].size();i++){
			Edge e = graph[0].get(i);
			System.out.print(e.dest + " ");
		}
		System.out.println();

		//neigbors of 1
		for(int i=0;i<graph[1].size();i++){
			Edge e = graph[1].get(i);
			System.out.print(e.dest + " ");
		}
		System.out.println();

		//neigbors of 2
		for(int i=0;i<graph[2].size();i++){
			Edge e = graph[2].get(i);
			System.out.print(e.dest + " ");
		}
		System.out.println();

		//neigbors of 3
		for(int i=0;i<graph[3].size();i++){
			Edge e = graph[3].get(i);
			System.out.print(e.dest + " ");
		}
	}
}