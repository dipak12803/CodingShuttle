package JAVA_Sem6;
import java.util.*;

public class Exp2_3_LAB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> s = new ArrayList<>();

        boolean flag=true;
        while (flag) {
            System.out.println("Enter your choice :");
            System.out.println("1 Insert");
            System.out.println("2 Search");
            System.out.println("3 Delete");
            System.out.println("4 Display");
            System.out.println("5 Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    String str = in.next();
                    s.add(str);
                    break;
                case 2:
                    System.out.println("Enter the item to search ");
                    str = in.next();
                    if (s.contains(str)) {
                        System.out.println("Item exist");
                    } else {
                        System.out.println("Item does not exist");
                    }
                    break;
                case 3:
                    System.out.println("Enter the item to delete: ");
                    str = in.next();
                    s.remove(str);
                    break;
                case 4:
                    System.out.println("The items in the list are: ");
                    for (String it : s) {
                        System.out.println(it + " ");
                    }

                    break;
                case 5:
                    flag=false;
            }
        }
    }


}
