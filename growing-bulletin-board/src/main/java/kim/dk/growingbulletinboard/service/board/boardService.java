package kim.dk.growingbulletinboard.service.board;

import kim.dk.growingbulletinboard.domain.board.Board;
import kim.dk.growingbulletinboard.domain.catagory.Category;
import kim.dk.growingbulletinboard.domain.member.Member;
import kim.dk.growingbulletinboard.service.dto.BoardDTO;

import java.util.List;

public interface boardService {
    Long register(BoardDTO dto);

    BoardDTO get(Long bno);

    void delete(Long bno);

    void modify(BoardDTO boardDTO);

    List<BoardDTO> list(Long cno);

    default Board dtoToEntity(BoardDTO dto){
        Member member= Member.builder().email(dto.getWriterEmail()).build();
        Category category = Category.builder().title(dto.getCategory()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .content(dto.getContent())
                .title(dto.getTitle())
                .member(member)
                .category(category)
                .build();
        return board;
    }

    default BoardDTO EntityToDTO(Board board,Member member,Category category,int replyCount){

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .content(board.getContent())
                .modDate(board.getModDate())
                .regDate(board.getRegDate())
                .writerEmail(member.getEmail())
                .category(category.getTitle())
                .replyCount(replyCount)
                .build();
        return boardDTO;
    }
}
