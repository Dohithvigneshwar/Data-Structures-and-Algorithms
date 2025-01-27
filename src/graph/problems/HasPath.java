package graph.problems;
import java.util.*;
public class HasPath {
	public static void main(String args[]) {
		int n = 5;
		int m = 7;
		int Edge[][] = {
				{0,1},
				{1,2},
				{2,0},
				{2,3},
				{1,1},
				{3,1},
				{1,0}
		};
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i<n;i++) graph.add(new ArrayList<>());
		for(int i=0;i<m;i++) {
			int v = Edge[i][0];
			int u = Edge[i][1];
			graph.get(v).add(u);
		}
		System.out.println(graph);
		int src = 0;
		int dest = 4;
		boolean varray[] = new boolean[n];
		boolean ans = isvalidPath(graph,varray,src,dest);
		System.out.println(ans);
	}	
	public static boolean isvalidPath(List<List<Integer>> graph,boolean varray[],int src,int dest) {
		if(src == dest) return true;
		varray[src] = true;
		for(int i=0;i<graph.get(src).size();i++) {
			int data = graph.get(src).get(i);
			if(!varray[data]) {
				if(isvalidPath(graph,varray,data,dest)) {
					return true;
				}
			}
		}
		return false;
	}
}
