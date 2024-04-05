package DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> graph=new ArrayList<>();
        int V=6;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1,1);
        addEdge(graph,1,2,2);
        addEdge(graph,3,4,2);
        addEdge(graph,2,3,3);
        addEdge(graph,3,5,6);
        addEdge(graph,5,0,9);
        addEdge(graph,0,4,1);
        addEdge(graph,4,1,2);
        addEdge(graph,3,1,3);
        addEdge(graph,5,1,5);
        addEdge(graph,5,4,6);

        System.out.println(mstKruskal(graph));
    }
    static int mstKruskal(ArrayList<ArrayList<Pair>> graph){
        ArrayList<Edge> edges =new ArrayList<>();
        for(int i=0;i<graph.size();i++){
            ArrayList<Pair> adj=graph.get(i);
            for(Pair p:adj){
                edges.add(new Edge(i, p.v, p.w));
            }
        }
        Collections.sort(edges);
        int v= graph.size();

        disjointSet ds=new disjointSet(v);
        int ans=0;
        int count=0;

        for(Edge cur:edges){
            int src=cur.src;
            int dest=cur.dest;

            int findSrc=ds.find(src);
            int findDest=ds.find(dest);

            if(findSrc!=findDest){
                ans+= cur.wt;
                count++;
                if(count==v-1) break;
                ds.union(src,dest);
            }
        }
        return ans;
    }
    static class Edge implements Comparable<Edge>{
        int src,dest,wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge that) {
            return this.wt-that.wt;
        }
    }
    static void addEdge(ArrayList<ArrayList<Pair>> graph,int src,int dest,int wt){
        graph.get(src).add(new Pair(dest,wt));
        graph.get(dest).add(new Pair(src,wt));  //bi directional

    }
}
