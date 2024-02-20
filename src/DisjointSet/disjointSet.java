package DisjointSet;

public class disjointSet {
    int p[];
    int r[];  //rank
    int n;
    int count;
    public disjointSet(int n){
        this.n=n;
        p=new int[n];
        r=new int[n];
        count=n;

        for(int i=0;i<n;i++){
            p[i]=i;
            r[i]=1;

        }
    }
    public int find(int a){
        if(p[a]!=a){
            int root=find(p[a]);
            p[a]=root;   //path compression
            return root;
        }
        return a;
    }
    public void union(int a,int b){
        int ra=find(a);   //representative of a
        int rb=find(b);
        if(ra!=rb){
            count--;
//            p[ra]=rb;
            if(r[ra]>r[rb]){
                p[rb]=ra;
            }
            else if(r[ra]<r[rb]){
                p[ra]=rb;
            }
            else{
                p[ra]=rb;
                r[rb]++;
            }
        }
    }

    public static void main(String[] args) {
        int n=8;
        disjointSet ds=new disjointSet(n);
        ds.union(0,3);
        ds.union(1,3);
        ds.union(5,4);
        ds.union(1,3);
        ds.union(0,1);
        System.out.println(ds.count);
    }
}
