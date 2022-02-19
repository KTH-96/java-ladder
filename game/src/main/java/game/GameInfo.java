package game;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {
    private int playerNum;
    private int height;
    private List<String> playerNames = new ArrayList<>();
    private List<String> results = new ArrayList<>();

    public GameInfo(int playerNum, int height, List<String> playerNames, List<String> results) {
        this.playerNum = playerNum;
        this.height = height;
        this.playerNames = playerNames;
        this.results = results;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getResults() {
        return results;
    }
}
