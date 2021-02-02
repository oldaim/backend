package kim.dk.growingbulletinboard.repository;

import kim.dk.growingbulletinboard.domain.board.Board;
import kim.dk.growingbulletinboard.domain.board.BoardRepository;
import kim.dk.growingbulletinboard.domain.catagory.Category;
import kim.dk.growingbulletinboard.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){ //더미파일 생성
        IntStream.rangeClosed(1,8).forEach(i->{
            Member member = Member.builder().email("user"+(i+300)+"aaa.com").password("aaaaa").name("kim").build();

            Long cno =(long)(Math.random()*5)+1;
            Category category = Category.builder().cno(cno).build();

            Board board =Board.builder()
                    .title("Title..."+i)
                    .content("Content..."+i)
                    .member(member)
                    .category(category)
                    .build();

            boardRepository.save(board);
        });

    }

    @Test
    public void list(){ //카테고리 분류에 의한 게시물 분류 기능 검증
        List<Board> board=boardRepository.findByCategory((long) 3);

        board.forEach(Board->{
            System.out.println(Board);
        });
    }

    @Transactional
    @Test
    public void testRead1(){ //게시물 조회 기능 검증
        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getMember());
    }

    @Test
    public void testRead2(){ //게시물 수정 기능 검증
        Optional<Board> result = boardRepository.findById(121L);

        Board board = result.get();

        board.changeTitle("change...Title");
        board.changeContent("change...Content");

        boardRepository.save(board);
    }

    @Test
    public void testRead3(){ //게시물 삭제 기능 검증
         boardRepository.deleteById(122L);
    }
}
