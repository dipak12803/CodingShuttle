public class Pattern {
    public static void main(String[] args) {
//        for(int i=1;i<=4;i++){
//           for(int j=1;j<=i;j++){
//               System.out.print(j+" ");
//          }
//          System.out.println();
//       }
//1
//1 2
//1 2 3
//1 2 3 4
//
//
//    }

        int n=8;
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n-i;j++){
//                System.out.print(" ");
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//       *
//      **
//     ***
//    ****
//   *****
//  ******
// *******
//********


//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n-i;j++){
//                System.out.print(" ");
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }
//                           pyramid like output




        //DIAMOND OUTPUT
        for(int i=0;i<n;i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j <= 2 * i - 1; j++) {
                if(j==2*i-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int i=n-2;i>=0;i--){
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j <= 2 * i - 1; j++) {
                if(j==2*i-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        }

        }

