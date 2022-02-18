package ladder;

import game.GameInfo;
import game.GameRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    GameRepository gameRepository;
    List<String> list;
    @BeforeEach
    void setUp() {
        gameRepository = GameRepository.getInstance();
        list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("xxx");
    }
    @Test
    @DisplayName("플레이어 이름이 5글자 이상일때 IllegalStateException 를 발생시킵니다")
    void LadderStringTest() {
        //given 준비
        list.add("테스트용 5글자 이상인 이름");
        //when 실행
        //then 검증
        assertThrows(IllegalStateException.class,
                () -> gameRepository.save(new GameInfo(list.size(), 5, list)));

    }
}