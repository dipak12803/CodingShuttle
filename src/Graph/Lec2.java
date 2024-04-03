package Graph;

import java.util.*;

public class Lec2 {
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
//        addEdge(graph,7,5);
//        addEdge(graph,7,4);
//        addEdge(graph,7,6);
        addEdge(graph,3,6);

        boolean vis[]=new boolean[V];
//        dfs(graph,vis,0);
//        dfsIterative(graph,vis,0);

        System.out.println(numberOfConnectedComponents(graph,V));
    }



    static int numberOfConnectedComponents(ArrayList<ArrayList<Integer>> graph,int V){
        boolean[] vis=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;  //increment count of connected component
                dfs(graph,vis,i);  //once dfs run it marks visited its all connected components
                //the not connected once remains unvisited
            }
        }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>> graph,boolean vis[],int cur){
        vis[cur]=true;
//        System.out.println(cur);
        for(int neighbor: graph.get(cur)){
            if(!vis[neighbor]){
                dfs(graph,vis,neighbor);
            }

        }
    }
    static void dfsIterative(ArrayList<ArrayList<Integer>> graph,boolean vis[],int cur){
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(cur);
        vis[cur]=true;

        while(!stack.isEmpty()){
            int a=stack.pop();
            System.out.println(a);
            for(int neighbor: graph.get(a)){
                if(!vis[neighbor]){
                    stack.push(neighbor);
                    vis[neighbor]=true;
                }

            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph,int a,int b){
        if(graph.get(a).contains(b)) return;  //checking if there is existing edge
//        for bidirectional edge
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
