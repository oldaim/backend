package kim.dk.growingbulletinboard.service.board;


import kim.dk.growingbulletinboard.domain.board.Board;
import kim.dk.growingbulletinboard.domain.board.BoardRepository;
import kim.dk.growingbulletinboard.domain.catagory.Category;
import kim.dk.growingbulletinboard.domain.member.Member;
import kim.dk.growingbulletinboard.service.board.boardService;
import kim.dk.growingbulletinboard.service.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class boardServiceImpl implements boardService {

    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO dto){ //등록

        Board board = dtoToEntity(dto);

        boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public BoardDTO get(Long bno){ //조회

       Board board=boardRepository.findById(bno)
               .orElseThrow(()-> new IllegalArgumentException("cant find board Id"));


       return EntityToDTO(board,board.getMember(),board.getCategory(),board.getReplyCount());
    }

    @Override
    public List<BoardDTO> list(Long cno){ //조회

       List<Board> board=boardRepository.findByCategory(cno);



        return board.stream().map(Board -> EntityToDTO(Board,Board.getMember(),Board.getCategory(), Board.getReplyCount())).collect(Collectors.toList());
    }

    @Override
    public void delete(Long bno){ //삭제
        boardRepository.deleteById(bno);

    }

    @Override
    public void modify(BoardDTO dto){ //수정
        Board board=boardRepository.findById(dto.getBno())
                .orElseThrow(()-> new IllegalArgumentException("cant find board Id"));
        if(board != null){

            board.changeContent(dto.getContent());

            board.changeTitle(dto.getTitle());


            boardRepository.save(board);
        }
    }

}
