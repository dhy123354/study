package 数据结构2.Graph;


import java.util.List;
import java.util.Set;

public class Main {
	static Graph.WeightManager<Double> weightManager = new Graph.WeightManager<Double>() {
		public int compare(Double w1, Double w2) {
			return w1.compareTo(w2);
		}

		public Double add(Double w1, Double w2) {
			return w1 + w2;
		}

		@Override
		public Double zero() {
			return 0.0;
		}
	};

	public static void main(String[] args) {
//		ListGraph<String,Integer> graph = new ListGraph<>();
//		graph.addEdge("V1","V0",9);
//		graph.addEdge("V1","V2",3);
//		graph.addEdge("V2","V0",2);
//		graph.addEdge("V2","V3",5);
//		graph.addEdge("V3","V4",1);
//		graph.addEdge("V0","V4",6);
//
//		graph.bfs("V1");
////		graph.removeEdge("V0","V4");
//
////		graph.removeVertex("V0");
//
////		graph.print();
		//testDfs();
		//testBfs();
		testMst();
		//testTopo();
	}

	static void testMst() {
		Graph<Object, Double> graph = undirectedGraph(Data.MST_01);
		Set<Graph.EdgeInfo<Object, Double>> infos = graph.mst();
		for (Graph.EdgeInfo<Object, Double> info : infos) {
			System.out.println(info);
		}
	}

	static void testBfs() {
		Graph<Object, Double> graph = directedGraph(Data.BFS_02);
		graph.bfs(0, (Object v) -> {
			System.out.println(v);
			return v.equals(5);
		});
	}

	static void testDfs(){
		Graph<Object,Double> graph = directedGraph(Data.DFS_01);

	}

	static void testTopo() {
		Graph<Object, Double> graph = directedGraph(Data.TOPO);
		List<Object> list = graph.topologicalSort();
		System.out.println(list);
	}

	/**
	 * 有向图
	 */
	private static Graph<Object, Double> directedGraph(Object[][] data) {
		Graph<Object, Double> graph = new ListGraph<>();
		for (Object[] edge : data) {
			if (edge.length == 1) {
				graph.addVertex(edge[0]);
			} else if (edge.length == 2) {
				graph.addEdge(edge[0], edge[1]);
			} else if (edge.length == 3) {
				double weight = Double.parseDouble(edge[2].toString());
				graph.addEdge(edge[0], edge[1], weight);
			}
		}
		return graph;
	}

	/**
	 * 无向图
	 * @param data
	 * @return
	 */
	private static Graph<Object, Double> undirectedGraph(Object[][] data) {
		Graph<Object, Double> graph = new ListGraph<>();
		for (Object[] edge : data) {
			if (edge.length == 1) {
				graph.addVertex(edge[0]);
			} else if (edge.length == 2) {
				graph.addEdge(edge[0], edge[1]);
				graph.addEdge(edge[1], edge[0]);
			} else if (edge.length == 3) {
				double weight = Double.parseDouble(edge[2].toString());
				graph.addEdge(edge[0], edge[1], weight);
				graph.addEdge(edge[1], edge[0], weight);
			}
		}
		return graph;
	}
}
