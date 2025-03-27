package mission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Mission {

    @BeforeEach
    void setUp() {
        1. 댓글 데이터 전체 삭제
        2. 게시물 데이터 전체 삭제
        3. 사용자 데이터 전체 삭제
    }

    @DisplayName("사용자가 댓글을 작성할 수 있다.")
    @Test
    void writeComment() {
        // given
        1 - 1. 사용자_생성 메서드 호출
        1 - 2. 게시물 생성 메서드 호출
        1 - 3. 댓글 생성에 필요한 내용 준비

        // when
        1 - 4. 댓글 생성

        // then
        검증
    }

    @DisplayName("사용자가 댓글을 수정할 수 있다.")
    @Test
    void updateComment() {
        // given
        2 - 1. 사용자_생성 메서드 호출
        2 - 2. 게시물 생성 메서드 호출
        2 - 3. 댓글 생성에 필요한 내용 준비
        2 - 4. 댓글 생성

        // when
        2 - 5. 댓글 수정

        // then
        검증
    }

    @DisplayName("자신이 작성한 댓글이 아니면 수정할 수 없다.")
    @Test
    void cannotUpdateCommentWhenUserIsNotWriter() {
        // given
        3 - 1. 사용자_생성 메서드 호출하여 사용자 1 생성
        3 - 2. 사용자_생성 메서드 호출하여 사용자 2 생성
        3 - 3. 게시물 생성 메서드(사용자1) 호출
        3 - 4. 사용자1의 댓글 생성에 필요한 내용 준비
        3 - 5. 사용자1의 댓글 생성

        // when
        3 - 6. 사용자2가 사용자1의 댓글 수정 시도

        // then
        검증
    }

    private 사용자 사용자_생성() {
        1. 사용자 생성에 필요한 내용 준비
        2. 사용자 생성
        return 사용자
    }

    private 게시물 게시물_생성(사용자) {
        1. 게시물 생성에 필요한 내용 준비
        2. 게시물 생성
        return 게시물
    }
}
