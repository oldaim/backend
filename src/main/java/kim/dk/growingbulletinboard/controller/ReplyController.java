package kim.dk.growingbulletinboard.controller;

import kim.dk.growingbulletinboard.domain.reply.Reply;
import kim.dk.growingbulletinboard.service.dto.ReplyDTO;
import kim.dk.growingbulletinboard.service.reply.replyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category/replies/")
@RequiredArgsConstructor
public class ReplyController {

    private final replyService service;

    @GetMapping(value="/board/{bno}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno)
    {


        return new ResponseEntity<>(service.getList(bno), HttpStatus.OK);
    }

    @PostMapping(value="/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody ReplyDTO replyDTO){

        service.register(replyDTO);
    }

    @PostMapping(value="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public void modify(@RequestBody ReplyDTO replyDTO){

        service.modify(replyDTO);
    }

    @GetMapping(value="/delete/{rno}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long rno){

        service.remove(rno);
    }
}
