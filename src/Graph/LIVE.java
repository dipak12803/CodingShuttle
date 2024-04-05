package Graph;

public class LIVE {
    public static void main(String[] args) {
        int a[][]={
                {0,3,1,0},
                {3,0,3,3},
                {2,3,0,3},
                {0,3,3,3}
        };
        System.out.println(pathExistsInMatrix(a));

    }

    static boolean pathExistsInMatrix(int[][] a){
        int row=a.length;
        int col=a[0].length;
        boolean vis[][]=new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(a[i][j]==1){
                    return dfs(a,i,j,vis);
                }
            }
        }
        return false;
    }
    static boolean isSafe(int a[][],int i,int j){
        int row=a.length;
        int col=a[0].length;

        return i>=0 && i<row && j>=0 && j<col && a[i][j]!=0;
    }
    static boolean dfs(int[][] a,int i,int j,boolean[][] vis){
        if(!isSafe(a,i,j)) return false;
        if(vis[i][j]) return false;
        if(a[i][j]==2) return true;

        vis[i][j]=true;

        int[] x={0,1,0,-1};
        int[] y={1,0,-1,0};

        for(int ind=0;ind<4;ind++){
            int nextI=i+x[i];
            int nextJ=j+y[j];
             if(dfs(a,nextI,nextJ,vis)) return true;

        }

        return false;
    }
}
