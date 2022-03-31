package blackjack.domain.card;

import java.util.Objects;

public class Card {

    private final Number number;
    private final Kind kind;

    public Card(Number number, Kind kind) {
        this.number = number;
        this.kind = kind;
    }

    public boolean isAce() {
        return number == Number.ACE;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number.getName() + kind.getSymbol();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return number == card.number && kind == card.kind;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, kind);
    }
}
