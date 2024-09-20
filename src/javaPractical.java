import java.util.*;

public class javaPractical{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of cards: ");
        int numCards = in.nextInt();
        char symbol;
        int cardNumber;
        Map<Character, List<Integer>> cardMap = new TreeMap<>(); // Using TreeMap for alphabetical order
        int cardSum = 0;

        for (int i = 0; i < numCards; i++) {
            System.out.println("Enter card " + (i + 1) + ":");
            System.out.print("Symbol: ");
            symbol = in.next().charAt(0);
            System.out.print("Number: ");
            cardNumber = in.nextInt();
            cardSum += cardNumber;

            List<Integer> cardNumbers = cardMap.getOrDefault(symbol, new ArrayList<>());
            cardNumbers.add(cardNumber);
            cardMap.put(symbol, cardNumbers);
        }

        System.out.println("Total sum of cards is " + cardSum);
        System.out.print("Distinct cards are: ");
        for (char card : cardMap.keySet()) {
            System.out.print(card + " ");
        }
        System.out.println();

        for (Map.Entry<Character, List<Integer>> entry : cardMap.entrySet()) {
            char card = entry.getKey();
            List<Integer> values = entry.getValue();
            int cSum=0;

            System.out.print("Card " + card + " -> ");
            for (int value : values) {
                cSum+=value;
                System.out.print(value + " ");
            }
            System.out.print("Sum of individual cards: "+cSum);
            System.out.println();
        }
    }
}
