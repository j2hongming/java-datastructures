package org.j2hongming.datastructure.graph.dfs;

import org.j2hongming.datastructure.graph.Graph;
import org.j2hongming.datastructure.graph.Vertex;

public class DFSApp {

	public static void main(String[] args) {

		Graph dFSApp = new Graph(8);
		Vertex va = new Vertex(65);
		Vertex vb = new Vertex(66);
		Vertex vc = new Vertex(67);
		Vertex vd = new Vertex(68);
		Vertex ve = new Vertex(69);
		Vertex vf = new Vertex(70);
		Vertex vg = new Vertex(71);
		Vertex vh = new Vertex(72);
		dFSApp.addVertex(va);
		dFSApp.addVertex(vb);
		dFSApp.addVertex(vc);
		dFSApp.addVertex(vd);
		dFSApp.addVertex(ve);
		dFSApp.addVertex(vf);
		dFSApp.addVertex(vg);
		dFSApp.addVertex(vh);
		dFSApp.addEdge(va, vb);dFSApp.addEdge(va, vc);
		dFSApp.addEdge(vb, vd);
		dFSApp.addEdge(vc, vb);dFSApp.addEdge(vc, vf);
		dFSApp.addEdge(vd, ve);dFSApp.addEdge(vd, vf);
		dFSApp.addEdge(vf, vb);
		dFSApp.addEdge(vg, ve);dFSApp.addEdge(vg, vh);
		dFSApp.addEdge(vh, vg);
		
		dFSApp.dfs(va);
	}

}
