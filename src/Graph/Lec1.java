package Graph;

import java.util.*;

public class Lec1 {
    public static void main(String[] args) {
//        with adjacency list
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int V=4;
        for(int i=0;i<V;i++) {
            //we have initialised empty graph with 4 empty arraylist
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,0,3);
        addEdge(graph,1,2);




//  with adjacency matrix
//        int V=4;
//       int graphMat[][]=new int[V][V];
//            addEdgeMat(graphMat,0,1,3);
//            addEdgeMat(graphMat,0,2,8);
//            addEdgeMat(graphMat,0,3,1);
//            addEdgeMat(graphMat,1,2,5);
//            addEdgeMat(graphMat,3,2,3);


//        boolean vis[]=new boolean[V];
//        int[] dist=new int[V];
//        int[] prec=new int[V];  //precedence is like parent from which the node originates
//        int src=3;
//        bfs(graph,3,vis,dist,prec);

//        System.out.println("Printing Distance : ");
//        for(int i=0;i< dist.length;i++){
//            System.out.println(i+" ->"+dist[i]);
//        }
        findPath(graph,1,3);

        }
        static void findPath(ArrayList<ArrayList<Integer>> graph,int src,int dest){
        int V=4;
            boolean vis[]=new boolean[V];
            int[] dist=new int[V];
            int[] prec=new int[V];  //precedence is like parent from which the node originates

            bfs(graph,src,vis,dist,prec);
            while(dest!=-1){
                System.out.println(dest);
                //destination is updated with it parent node at one time we will reach src which has -1 has originating point
                dest=prec[dest];
            }
        }

       static void bfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis,int[] dist,int[] prec){
        Queue<Integer> q=new LinkedList<>();
        vis[src]=true;
        dist[src]=0;
        prec[src]=-1;
        q.add(src);
        while(!q.isEmpty()){
            int cur=q.poll();
//            System.out.println(cur);
            //now traversing all the neighbours of current node
            for(int neighbor:graph.get(cur)){
                if(!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor]=true;

                    //taking distance of current node & add 1
                    dist[neighbor]=dist[cur]+1;
                    prec[neighbor]=cur;  //that neighbor is origintated from cur node
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

    static void addEdgeMat(int[][] graphMat,int src,int dest,int wt){
        graphMat[src][dest]=wt;

}

}

