package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

public class Lec3 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int V=8;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());

        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,5,2);
        addEdge(graph,1,5);
        addEdge(graph,7,5);
        addEdge(graph,7,4);
        addEdge(graph,7,6);
        addEdge(graph,3,6);


        topologicalOrderingDFS(graph,V);
    }


//    KAHNS ALGO
    static void topologicalOrderingBFS(ArrayList<ArrayList<Integer>> graph,int V){
        Queue<Integer> q=new LinkedList<>();
        int inDegree[]=new int[V];
        //indegree is the number of incoming edges at particular node
        for(int i=0;i<V;i++){
            for(int e:graph.get(i)){
                inDegree[e]++;
            }
        }
        for(int i=0;i<V;i++){
            if(inDegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            System.out.println(cur);

            for(int neighbor:graph.get(cur)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
    }

    static void topologicalOrderingDFS(ArrayList<ArrayList<Integer>> graph,int V){
        boolean[] vis=new boolean[V];
        ArrayDeque<Integer> ansStack=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph,vis,i,ansStack);
            }
        }
        while(!ansStack.isEmpty()){
            System.out.println(ansStack.pop());
        }
    }
    static void dfs(ArrayList<ArrayList<Integer>> graph,boolean vis[],int cur,ArrayDeque<Integer> ansStack){
        vis[cur]=true;
//        System.out.println(cur);
        for(int neighbor: graph.get(cur)){
            if(!vis[neighbor]){
                dfs(graph,vis,neighbor,ansStack);
            }
            ansStack.push(cur);  //push into the stack at the time of backtracking
            return;  //this is the backtracking step

        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b){
        if(graph.get(a).contains(b)) return;  //checking if there is existing edge
//        for directional   edge
        graph.get(a).add(b);

    }
}
