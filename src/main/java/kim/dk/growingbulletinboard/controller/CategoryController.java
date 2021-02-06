package kim.dk.growingbulletinboard.controller;

import kim.dk.growingbulletinboard.service.board.boardService;
import kim.dk.growingbulletinboard.service.dto.BoardDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final boardService service;

    @GetMapping("/")
    public void menu_first(){

    }
    @GetMapping(value = "/{cno}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoardDTO>> list(@PathVariable Long cno){

        return new ResponseEntity<>(service.list(cno), HttpStatus.OK);
    }


}
