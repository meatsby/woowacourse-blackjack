package blackjack.domain.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CardDeck {

    private static final String OVER_CAPACITY_EXCEPTION_MESSAGE = "카드가 부족합니다.";

    private final LinkedList<Card> cardDeck;

    private CardDeck(List<Card> cardDeck) {
        this.cardDeck = new LinkedList<>(cardDeck);
    }

    public static CardDeck initShuffled() {
        List<Card> cardDeck = Arrays.stream(Number.values())
                .flatMap(number -> Arrays.stream(Kind.values())
                        .map(kind -> new Card(number, kind)))
                .collect(Collectors.toList());
        Collections.shuffle(cardDeck);

        return new CardDeck(cardDeck);
    }

    public Cards distribute(int count) {
        validateCapacity(count);
        List<Card> distribution = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            distribution.add(cardDeck.pop());
        }
        return new Cards(distribution);
    }

    private void validateCapacity(int count) {
        if (cardDeck.size() < count) {
            throw new IllegalArgumentException(OVER_CAPACITY_EXCEPTION_MESSAGE);
        }
    }

    public LinkedList<Card> getCardDeck() {
        return cardDeck;
    }
}
