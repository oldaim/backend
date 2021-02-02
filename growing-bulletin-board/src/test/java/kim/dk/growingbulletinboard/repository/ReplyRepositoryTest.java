package kim.dk.growingbulletinboard.repository;

import kim.dk.growingbulletinboard.domain.board.Board;
import kim.dk.growingbulletinboard.domain.reply.Reply;
import kim.dk.growingbulletinboard.domain.reply.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTest {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i->{
            long bno =(long)(Math.random()*50)+10;
            Board board =Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .text("Reply......."+i)
                    .board(board)
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    public void testRead1(){
        Optional<Reply> result = replyRepository.findById(1L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }

    @Test
    public void testListByBoard(){
        List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(
                Board.builder().bno(50L).build());

        replyList.forEach(reply-> System.out.println(reply));
    }
}
