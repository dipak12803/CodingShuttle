package JAVA_Sem6;

import java.util.Scanner;

class Video {
    private String title;
    private boolean checkedOut;
    private double totalRating;
    private int ratingCount;
    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.totalRating = 0.0;
        this.ratingCount = 0;
    }
    public String getTitle() {
        return title;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }
    public void rent() {
        if (!checkedOut) {
            checkedOut = true;
            System.out.println("Video '" + title + "' has been rented.");
        } else {
            System.out.println("Video '" + title + "' is already checked out.");
        }
    }
    public void returned() {
        if (checkedOut) {
            checkedOut = false;
            System.out.println("Video '" + title + "' has been returned.");
        } else {
            System.out.println("Video '" + title + "' is not checked out.");
        }
    }
    public void receiveRating(double rating) {
        totalRating += rating;
        ratingCount++;
        System.out.println("Rating received for video '" + title + "': " + rating);
    }
    public double getAvgRating() {
        if (ratingCount > 0) {
            return totalRating / ratingCount;
        } else {
            return 0.0;
        }
    }
}
class VideoStore {
    private Video[] videos;
    private static final int MAX_VIDEOS = 10;
    private int videoCount;
    public VideoStore() {
        videos = new Video[MAX_VIDEOS];
        videoCount = 0;
    }
    public void addVideo(String title) {
        if (videoCount < MAX_VIDEOS) {
            videos[videoCount++] = new Video(title);
            System.out.println("Video '" + title + "' added to inventory.");
        } else {
            System.out.println("Inventory is full. Cannot add more videos.");
        }
    }
    public void checkOut(String title) {
        for (Video video : videos) {
            if (video != null && video.getTitle().equalsIgnoreCase(title)) {
                video.rent();
                return;
            }
        }
        System.out.println("Video '" + title + "' not found in the inventory.");
    }
    public void returnVideo(String title) {
        for (Video video : videos) {
            if (video != null && video.getTitle().equalsIgnoreCase(title)) {
                video.returned();
                return;
            }
        }
        System.out.println("Video '" + title + "' not found in the inventory.");
    }
    public void receiveRating(String title, double rating) {
        for (Video video : videos) {
            if (video != null && video.getTitle().equalsIgnoreCase(title)) {
                video.receiveRating(rating);
                return;
            }
        }
        System.out.println("Video '" + title + "' not found in the inventory.");
    }
    public void listInventory() {
        if (videoCount == 0) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory List:");
            for (Video video : videos) {
                if (video != null) {
                    System.out.println("Title: " + video.getTitle() + ", Checked Out: " + video.isCheckedOut() +
                            ", Average Rating: " + video.getAvgRating());
                }
            }
        }
    }
}
public class EXP2 {
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
                            System.out.println("Enter the video Name and rating");
                            title = s.next();
                            double rating = s.nextDouble();
                            vs.receiveRating(title, rating);
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
                        } else if (aCh == 2) {
                            System.out.println("Enter the name of Video");
                            title = s.next();
                            vs.addVideo(title);
                        } else {
                            System.out.println("No such Option is available");
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
}
