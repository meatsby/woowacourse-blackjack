package blackjack.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.card.Kind;
import blackjack.domain.card.Number;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어 생성자 테스트")
    @Test
    void create() {
        Player player = new Player(new Name("Pobi"), new Cards(List.of(Card.from(Number.ACE, Kind.SPADE))));

        assertThat(player).isNotNull();
    }

    @DisplayName("Ace를 1로 판단했을 시 베스트 점수 계산 테스트")
    @Test
    void calculateBestScore_ConsideringAceIsOne_IsBest() {
        Player player = new Player(new Name("Pobi"),
                new Cards(List.of(Card.from(Number.ACE, Kind.SPADE),
                        Card.from(Number.KING, Kind.SPADE))));

        assertThat(player.calculateBestScore()).isEqualTo(21);
    }

    @DisplayName("Ace를 11로 판단했을 시 베스트 점수 계산 테스트")
    @Test
    void calculateBestScore_ConsideringAceIsEleven_IsBest() {
        Player player = new Player(new Name("Pobi"),
                new Cards(List.of(Card.from(Number.ACE, Kind.SPADE),
                        Card.from(Number.FIVE, Kind.SPADE),
                        Card.from(Number.SEVEN, Kind.SPADE),
                        Card.from(Number.EIGHT, Kind.SPADE))));

        assertThat(player.calculateBestScore()).isEqualTo(21);
    }

    @DisplayName("Ace만 있을 시 베스트 점수 계산 테스트")
    @Test
    void calculateBestScore_FourAces_IsBest() {
        Player player = new Player(new Name("Pobi"),
                new Cards(List.of(Card.from(Number.ACE, Kind.SPADE),
                        Card.from(Number.ACE, Kind.DIAMOND),
                        Card.from(Number.ACE, Kind.CLOVER),
                        Card.from(Number.ACE, Kind.HEART))));

        assertThat(player.calculateBestScore()).isEqualTo(14);
    }
}