package org.j2hongming.datastructure.graph.bfs;

import org.j2hongming.datastructure.graph.Graph;
import org.j2hongming.datastructure.graph.Vertex;

public class BFSApp {

	public static void main(String[] args) {

		Graph bFSApp = new Graph(9);
		Vertex v1 = new Vertex(5);
		Vertex v2 = new Vertex(6);
		Vertex v3 = new Vertex(1);
		Vertex v4 = new Vertex(2);
		Vertex v5 = new Vertex(3);
		Vertex v6 = new Vertex(4);
		Vertex v7 = new Vertex(8);
		Vertex v8 = new Vertex(7);
		Vertex v9 = new Vertex(9);
		bFSApp.addVertex( v1 );
		bFSApp.addVertex( v2 );
		bFSApp.addVertex( v3 );
		bFSApp.addVertex( v4 );
		bFSApp.addVertex( v5 );
		bFSApp.addVertex( v6 );
		bFSApp.addVertex( v7 );
		bFSApp.addVertex( v8 );
		bFSApp.addVertex( v9 );
		bFSApp.addEdge(v1, v2);bFSApp.addEdge(v1, v3);bFSApp.addEdge(v1, v5);
		bFSApp.addEdge(v2, v1);bFSApp.addEdge(v2, v4);
		bFSApp.addEdge(v3, v1);bFSApp.addEdge(v3, v6);
		bFSApp.addEdge(v4, v2);bFSApp.addEdge(v4, v5);bFSApp.addEdge(v4, v7);
		bFSApp.addEdge(v5, v1);bFSApp.addEdge(v5, v4);bFSApp.addEdge(v5, v6);bFSApp.addEdge(v5, v7);bFSApp.addEdge(v5, v8);
		bFSApp.addEdge(v6, v3);bFSApp.addEdge(v6, v5);bFSApp.addEdge(v6, v8);
		bFSApp.addEdge(v7, v4);bFSApp.addEdge(v7, v5);bFSApp.addEdge(v7, v9);
		bFSApp.addEdge(v8, v5);bFSApp.addEdge(v7, v9);
		bFSApp.addEdge(v9, v7);bFSApp.addEdge(v9, v8);
		
		bFSApp.bfs(v1);
	}

}
