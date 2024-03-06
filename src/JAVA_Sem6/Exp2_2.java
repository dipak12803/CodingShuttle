package JAVA_Sem6;

import java.util.*;
class Card {
    String symbol;
    int number;
    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}

public class Exp2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> seenSymbols = new HashSet<>();
        Map<String, Card> cards = new HashMap<>();
        int uniqueSymbols = 0;

        while (uniqueSymbols < 4) {
            System.out.println("Enter a card (symbol and number):");
            String symbol = scanner.next();
            int number = scanner.nextInt();

            if (!seenSymbols.contains(symbol)) {
                seenSymbols.add(symbol);
                cards.put(symbol, new Card(symbol, number));
                uniqueSymbols++;
            }
        }
        System.out.println("Four symbols gathered in " + cards.size() + " cards.");
        System.out.println("Cards with first occurrence:");
        for (Card card : cards.values()) {
            System.out.println(card);
        }
    }
}
