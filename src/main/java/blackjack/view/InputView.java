package blackjack.view;

import blackjack.domain.participant.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> requestPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.asList(scanner.nextLine().split(", "));
    }

    public static int requestBet(String playerName) {
        System.out.printf("%n%s의 베팅 금액은?%n", playerName);
        return parseNumber(scanner.nextLine());
    }

    private static int parseNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("베팅금액은 숫자여야 합니다.");
        }
    }

    public static boolean requestDecision(Player player) {
        System.out.println(player.getName().getValue() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return scanner.nextLine().equals("y");
    }
}
