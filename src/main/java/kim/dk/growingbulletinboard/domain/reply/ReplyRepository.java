package kim.dk.growingbulletinboard.domain.reply;

import kim.dk.growingbulletinboard.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    List<Reply> getRepliesByBoardOrderByRno(Board board);
}
