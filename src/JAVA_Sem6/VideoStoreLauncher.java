package JAVA_Sem6;
import java.util.*;
    public class VideoStoreLauncher {

        public static void main(String[] args) {
            VideoStore vs = new VideoStore();
            int ch, uCh, aCh;
            String title, choice;
            do {
                System.out.println("=========Menu=========");
                System.out.println("1. Login as User");
                System.out.println("2. Login as Admin");
                System.out.println("Enter Your Choice");
                Scanner s = new Scanner(System.in);
                ch = s.nextInt();
                do {
                    switch (ch) {
                        case 1:
                            System.out.println("1. List Inventory");
                            System.out.println("2. Rent Video");
                            System.out.println("3. Enter the rating of Video");
                            System.out.println("4. Return Video");
                            uCh = s.nextInt();
                            if (uCh == 1) {
                                vs.listInventory();
                            } else if (uCh == 2) {
                                vs.listInventory();
                                System.out.println("Enter the video Name you want");
                                title = s.next();
                                vs.checkOut(title);
                            } else if (uCh == 3) {
                                vs.receiveRating();
                            } else if (uCh == 4) {
                                System.out.println("Enter the video Name you want to return");
                                title = s.next();
                                vs.returnVideo(title);
                            } else {
                                System.out.println("No such Option is available");
                            }
                            break;
                        case 2:
                            System.out.println("1. List Inventory");
                            System.out.println("2. Add Video");
                            aCh = s.nextInt();
                            if (aCh == 1) {
                                vs.listInventory();
                            }
                            if (aCh == 2) {
                                System.out.println("Enter the name of Video");
                                title = s.next();
                                vs.addVideo(title);
                            }
                            break;
                        default:
                            System.out.println("Sorry Wrong Choice");
                    }
                    System.out.println("Do you want to repeat yes/no");
                    choice = s.next();
                } while (choice.equalsIgnoreCase("yes"));
                System.out.println("Want to Return to main Menu yes/no");
                choice = s.next();
            } while (choice.equalsIgnoreCase("yes"));
        }
        public static class Video{
            String title;
            boolean checked;
            double avgRating;
            void isChecked(){

            }
            boolean isRent;


        }
        public static class VideoStore extends Video {
            ArrayList<String> video=new ArrayList<>();
            static int i=0;



            public void addVideo(String title) {
                this.title=title;
                video.add(title);
                i++;
                
            }

            public void listInventory() {
                System.out.println(video+"Video count : "+i);
            }

            public void returnVideo(String title) {
            }

            public void checkOut(String title) {
                this.title=title;


            }

            public void receiveRating() {

            }
        }


    }


