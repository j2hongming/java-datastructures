package org.j2hongming.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int key;
	private List<Vertex> adjVertexs;

	public Vertex(int key){
		this.key = key;
		adjVertexs = new ArrayList<Vertex>();
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public List<Vertex> getAdjVertexs() {
		return adjVertexs;
	}

	public void setAdjVertexs(List<Vertex> adjVertexs) {
		this.adjVertexs = adjVertexs;
	}
	
	
}
