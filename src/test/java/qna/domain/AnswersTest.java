package qna.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class AnswersTest {

    @Test
    @DisplayName("answers 생성 테스트")
    void create() {
        assertThatCode(() -> new Answers()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("전체 삭제 예외 테스트")
    void deleteAllException(){
        Answers answers = new Answers();
        answers.add(AnswerTest.A1);
        answers.add(AnswerTest.A2);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> answers.deleteAll(AnswerTest.A1.getWriter()));
    }

    @Test
    @DisplayName("전체 삭제 검증 테스트")
    void deleteAll(){
        Answers answers = new Answers();
        answers.add(AnswerTest.A1);

        List<DeleteHistory> deleteHistoryList = answers.deleteAll(AnswerTest.A1.getWriter());

        assertThat(deleteHistoryList).isNotEmpty();
    }
}
