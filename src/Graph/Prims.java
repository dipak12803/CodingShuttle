package Graph;

import DisjointSet.Kruskal;
import DisjointSet.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prims {
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
        System.out.println(mstPrims(graph,V));

    }
    static int[] minDistanceDijkstra(ArrayList<ArrayList<Pair>> graph,int V,int src){
        int ans[]=new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;

        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(-1,src,0));
        boolean vis[]=new boolean[V];


        while(!pq.isEmpty()){
            Edge edge=pq.poll();
            int cur= edge.dest;
            if(vis[cur]) continue;


            vis[cur]=true;
            ArrayList<Pair> curNeighbours=graph.get(cur);
            for(Pair pair :curNeighbours){
                if(!vis[pair.v]){
                    if(ans[cur]!=Integer.MAX_VALUE && ans[pair.v]>ans[cur]+pair.w){
                        ans[pair.v]=ans[cur]+ pair.w;

                    pq.add(new Edge(cur,pair.v,ans[pair.v]));
                    }
                }
            }

        }
        return ans;
    }
    static int mstPrims(ArrayList<ArrayList<Pair>> graph,int V){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(-1,0,0));
        boolean vis[]=new boolean[V];

        int ans=0;
        while(!pq.isEmpty()){
            Edge cur=pq.poll();
            if(vis[cur.dest]) continue;


            vis[cur.dest]=true;
            ans+=cur.wt;
            ArrayList<Pair> curNeighbours=graph.get(cur.dest);
            for(Pair pair :curNeighbours){
                if(!vis[pair.v]){
                    pq.add(new Edge(cur.dest,pair.v,pair.w));
                }
            }

        }
        return ans;
    }
    static void addEdge(ArrayList<ArrayList<Pair>> graph,int src,int dest,int wt){
        graph.get(src).add(new Pair(dest,wt));
        graph.get(dest).add(new Pair(src,wt));  //bi directional

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
}
