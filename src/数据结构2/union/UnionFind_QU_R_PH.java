package 数据结构2.union;

/**
 * Quick Union - 基于rank的优化 - 路径减半(Path Halving)
 * @author MJ Lee
 *
 */
public class UnionFind_QU_R_PH extends UnionFind_QU {

	public UnionFind_QU_R_PH(int capacity) {
		super(capacity);
	}
	
	@Override
	public int find(int v) { 
		rangeCheck(v);
		while (v != parents[v]) {
			parents[v] = parents[parents[v]];
			v = parents[v];
		}
		return v;
	}
}