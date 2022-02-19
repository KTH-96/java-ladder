package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    GameRepository gameRepository;
    List<String> player;
    List<String> result;
    @BeforeEach
    void setUp() {
        gameRepository = GameRepository.getInstance();
        player = new ArrayList<>();
        player.add("aaa");
        player.add("ccc");
        player.add("xxx");
        result = new ArrayList<>();
        result.add("꽝");
        result.add("100");
        result.add("200");
    }
    @Test
    @DisplayName("GameRepository 클래스 메서드 테스트")
    void gameRepositoryTest() {
        //given 준비
        gameRepository.save(new GameInfo(player.size(), 3, player, result));
        //when 실행
        List<String> playerNames = gameRepository.findPlayerNames();
        List<String> results = gameRepository.findResult();

        //then 검증
        assertAll(
                () -> assertEquals(3 ,gameRepository.findPlayerNumber()),
                () -> assertEquals(3 ,gameRepository.findHeight()),
                () -> assertEquals("aaa", playerNames.get(0)),
                () -> assertEquals("ccc", playerNames.get(1)),
                () -> assertEquals("xxx", playerNames.get(2)),
                () -> assertEquals("꽝", results.get(0)),
                () -> assertEquals("100", results.get(1)),
                () -> assertEquals("200", results.get(2))
        );
    }
}