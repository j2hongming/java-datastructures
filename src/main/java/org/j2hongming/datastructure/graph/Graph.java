package org.j2hongming.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/graph-breadth-first-searchbfsguang-du-you-xian-sou-xun.html
 * @see http://alrightchiu.github.io/SecondRound/graph-depth-first-searchdfsshen-du-you-xian-sou-xun.html
 */
public class Graph {

	private int vertexNum;
	private Vertex[] adjList;
	private Map<Integer, Color> color;
	private Map<Integer, Vertex> predecessor;
	
	// For BFS
	private Map<Integer, Integer> distance;
	
	// For DFS
	private int time;
	private Map<Integer, Integer> discover;
	private Map<Integer, Integer> finish;

	public Graph() {
		this.vertexNum = 0;
		this.time = 0;
	}

	public Graph(int n) {
		this.vertexNum = n;
		this.time = 0;
		this.adjList = new Vertex[n];
		// this.color = new Color[n];
		// this.distance = new int[n];
		// this.predecessor = new Vertex[n];
		this.color = new HashMap<Integer, Color>();
		this.distance = new HashMap<Integer, Integer>();
		this.predecessor = new HashMap<Integer, Vertex>();
		for (int idx = 0; idx < n; idx++) {
			this.adjList[idx] = null;
			// this.color[idx] = Color.White;
			// this.distance[idx] = this.vertexNum + 1;
			// this.predecessor[idx] = null;
		}

	}

	public void addVertex(Vertex v) {
		int idx = 0;
		while (this.adjList[idx] != null) {
			idx++;
		}
		this.adjList[idx] = v;
	}

	public void addEdge(Vertex from, Vertex to) {
		for (int idx = 0; idx < this.vertexNum; idx++) {
			if (this.adjList[idx].getKey() == from.getKey()) {
				from.getAdjVertexs().add(to);
				break;
			}
		}
	}

	public void bfs(Vertex startV) {
		Queue<Vertex> q = new LinkedList<Vertex>();

		for (Vertex v : adjList) {
			this.color.put(v.getKey(), Color.White);
			this.distance.put(v.getKey(), this.vertexNum + 1);
			this.predecessor.put(v.getKey(), null);
		}

		if (this.color.get(startV.getKey()).equals(Color.White)) {

			this.color.put(startV.getKey(), Color.Gray);
			this.distance.put(startV.getKey(), 0);
			this.predecessor.put(startV.getKey(), null);
			q.add(startV);

			while (!q.isEmpty()) {

				Vertex newStartV = q.peek();
				List<Vertex> adjVertexs = newStartV.getAdjVertexs();
				for (Vertex adjV : adjVertexs) {
					if (this.color.get(adjV.getKey()).equals(Color.White)) {
						this.color.put(adjV.getKey(), Color.Gray);
						this.distance.put(adjV.getKey(), this.distance.get(newStartV.getKey()) + 1);
						this.predecessor.put(adjV.getKey(), adjV);
						q.add(adjV);
					}
				}

				q.poll();
				this.color.put(newStartV.getKey(), Color.Black);
			}

		}
		
		// 尚未處理graph有多個connected component的狀況，亦即color中還有white

	}
	
	public void dfs(Vertex startV){
		
		this.discover = new HashMap<Integer, Integer>();
		this.finish = new HashMap<Integer, Integer>();
		for (Vertex v : adjList) {
			this.color.put(v.getKey(), Color.White);
			this.discover.put(v.getKey(), 0);
			this.finish.put(v.getKey(), 0);
			this.predecessor.put(v.getKey(), null);
		}

		if (this.color.get(startV.getKey()).equals(Color.White)) {
			dFSVisit(startV);
		}
		
		// 把AdjList完整走過一遍, 確保所有vertex都被搜尋過
		for(Vertex v:this.adjList){
			if (this.color.get(v.getKey()).equals(Color.White)) {
				dFSVisit(v);
			}
		}
	}
	
	public void dFSVisit(Vertex visitV){
		
		this.color.put(visitV.getKey(), Color.Gray);
		this.discover.put(visitV.getKey(), ++(this.time));
		
		List<Vertex> adjVertexs = visitV.getAdjVertexs();
		for (Vertex adjV : adjVertexs) {
			if (this.color.get(adjV.getKey()).equals(Color.White)) {
				this.predecessor.put(adjV.getKey(), visitV);
				dFSVisit(adjV);
			}
		}
		
		this.color.put(visitV.getKey(), Color.Black);
		this.finish.put(visitV.getKey(), ++(this.time));
	}
}
