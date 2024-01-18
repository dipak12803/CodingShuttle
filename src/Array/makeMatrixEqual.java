package Array;
import java.util.*;
public class makeMatrixEqual {
    public static void main(String[] args) {
        int[][] a={{3,63,42},
                {18,12,12},
                {15,21,18},
                {33,84,24}

        };
        int k=3;
        System.out.println(makeMatrixxxEqual(a,k));
    }
    static int makeMatrixxxEqual(int a[][],int k){
        int n=a.length;
        if(n==0) return 0;
        int m= a[0].length;
        int total=n*m;
        int[] b=new int[total];  //convert 2d array to 1d array
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i*m+j]=a[i][j];  // mapping elements from matrix to 1d array first it will store value
                //from first row and then next rows
            }

        }
            Arrays.sort(b);
        int median=b[total/2];
//        for(int i=0;i<total;i++){
//            System.out.println(i+" "+b[i]+" "+makeMatrixEqualHelper(b,b[i],k));
//
//        }
        return makeMatrixEqualHelper(b,median,k);
    }
    static int makeMatrixEqualHelper(int b[],int m,int k){
        int count=0;
        for(int i=0;i<b.length;i++){
            count+=Math.abs(b[i]-m)/k;  //it will calculate total number of operation to convert the array elements into m
        }
        return count;
    }
}
