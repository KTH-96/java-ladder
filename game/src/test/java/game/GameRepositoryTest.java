package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    GameRepository gameRepository = GameRepository.getInstance();
    @Test
    @DisplayName("GameRepository 클래스 메서드 테스트")
    void gameRepositoryTest() {
        //given 준비
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("xxx");
        gameRepository.save(new GameInfo(list.size(), 3, list));
        //when 실행
        List<String> playerNames = gameRepository.findPlayerNames();

        //then 검증
        assertAll(
                () -> assertEquals(3 ,gameRepository.findPlayerNumber()),
                () -> assertEquals(3 ,gameRepository.findHeight()),
                () -> assertEquals("aaa", playerNames.get(0)),
                () -> assertEquals("ccc", playerNames.get(1)),
                () -> assertEquals("xxx", playerNames.get(2))
        );
    }
}