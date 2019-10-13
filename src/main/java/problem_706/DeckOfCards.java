package main.java.problem_706;

import java.util.Random;

public class DeckOfCards {

    Card[] cards;
    String[] suits;
    int currentCard;
    int NCARDS = 52;

    public DeckOfCards() {
        int index = 0;
        this.cards = new Card[52];
        this.suits = new String[]{SUIT.Spade.name(), SUIT.Heart.name(), SUIT.Diamond.name(), SUIT.Club.name()};
        this.currentCard = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < 13; j++) {
                cards[index++] = new Card(suits[i], j + 1);
            }
        }
    }

    public void shuffle(int n) {
        int i, j, k;
        Random random=new Random();
        for (k = 0; k < n; k++) {
            i = random.nextInt(NCARDS);  // Pick 2 random cards
            j = random.nextInt(NCARDS);  // in the deck
            Card tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        currentCard = 0;   // Reset current card to deal
    }

    public Card deal() {
        if (currentCard < NCARDS) {
            return (cards[currentCard++]);
        } else {
            System.out.println("Out of cards error");
            return (null);  // Error;
        }
    }

    public void printCurrentDeck() {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(cards[index].suite + ":" + cards[index++].rank + ", ");
            }
            System.out.println();
        }
    }

    class Card {
        String suite;
        char rank;
        boolean isJoker;
        public Card(String suite, int rank) {
            this.suite = suite;
            switch(rank) {
                case 1:
                    this.rank = 'A';
                    break;
                case 11:
                    this.rank = 'K';
                    break;
                case 12:
                    this.rank = 'Q';
                    break;
                case 13:
                    this.rank = 'J';
                    break;
                default:
                    this.rank = (char) (rank+'0');
            }
        }
    }

    enum SUIT {
        Spade,
        Heart,
        Diamond,
        Club
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.printCurrentDeck();
        deckOfCards.shuffle(10000);
        Card card = deckOfCards.deal();
        System.out.println("--------------------");
        deckOfCards.printCurrentDeck();
    }
}
