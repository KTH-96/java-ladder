package view;

import game.GameInfo;
import game.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private static String FIND_PEOPLE_MESSAGE = "참여할 사람의 이름을 입력하세요. (이름은 쉼포로 구분하세요)";
    private static String FIND_HEIGHT_MESSAGE = "최대 사다리 높이는 몇개인가요?";
    private static String SET_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static Scanner sc = new Scanner(System.in);
    private GameRepository gameRepository = GameRepository.getInstance();

    public void startGame() {
        List<String> playerList = new ArrayList<>();
        List<String> results = new ArrayList<>();
        gameRepository.save(new GameInfo(playerList.size(), getHeight(),
                getPlayerList(playerList), getResultList(results)));
    }

    private List<String> getResultList(List<String> results) {
        StringTokenizer st = new StringTokenizer(getResult(), ",");
        while (st.hasMoreTokens()) {
            results.add(st.nextToken());
        }
        return results;
    }

    private String getResult() {
        System.out.println(SET_RESULT);
        return sc.next();
    }

    private List<String> getPlayerList(List<String> playerList) {
        StringTokenizer st = new StringTokenizer(getPeople(), ",");
        while (st.hasMoreTokens()) {
            playerList.add(st.nextToken());
        }
        return playerList;
    }

    private int getHeight() {
        System.out.println(FIND_HEIGHT_MESSAGE);
        int height = sc.nextInt();
        return height;
    }

    private String getPeople() {
        System.out.println(FIND_PEOPLE_MESSAGE);
        String people = sc.next();
        return people;
    }

    public void close() {
        sc.close();
    }
}
