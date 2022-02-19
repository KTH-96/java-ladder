package game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository implements MemoryRepository{

    private static GameRepository instance;
    private GameRepository() {}

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    private static List<GameInfo> store = new ArrayList<>();
    @Override
    public void save(GameInfo gameInfo) {
        store.add(validNameLength(gameInfo));
    }

    private GameInfo validNameLength(GameInfo gameInfo) {
        List<String> playerNames = gameInfo.getPlayerNames();
        for (String playerName : playerNames) {
            if (playerName.length() > 5){
                throw new IllegalStateException("이름의 최대 글자수는 5글자입니다!");
            }
        }
        return gameInfo;
    }

    @Override
    public int findPlayerNumber() {
        return store.get(0).getPlayerNum();
    }

    @Override
    public int findHeight() {
        return store.get(0).getHeight();
    }

    @Override
    public List<String> findPlayerNames() {
        return store.get(0).getPlayerNames();
    }


    public List<String> findResult() {
        return store.get(0).getResults();
    }
}
