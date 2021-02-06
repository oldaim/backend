package kim.dk.growingbulletinboard.controller;

import kim.dk.growingbulletinboard.domain.board.Board;
import kim.dk.growingbulletinboard.service.board.boardService;
import kim.dk.growingbulletinboard.service.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class BoardController {
    private final boardService service;

    @GetMapping(value="/board/{bno}",produces = MediaType.APPLICATION_JSON_VALUE) //조회
    public BoardDTO find(@PathVariable Long bno, Model model){

        return service.get(bno);

    }


    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE) //등록
    public String register(@RequestBody BoardDTO dto, RedirectAttributes redirectAttributes){
        System.out.println("success2!!");

        Long bno = service.register(dto);

        redirectAttributes.addFlashAttribute("msg",bno);

        return "redirect:/board/list";
    }

    @PostMapping(value="/modify",produces = MediaType.APPLICATION_JSON_VALUE) //수정
    public void modify(@RequestBody BoardDTO dto){
        service.modify(dto);
    }

    @GetMapping(value="/delete/{bno}",produces = MediaType.APPLICATION_JSON_VALUE)  //삭제
    public void delete(@PathVariable Long bno){
        service.delete(bno);
    }
}
