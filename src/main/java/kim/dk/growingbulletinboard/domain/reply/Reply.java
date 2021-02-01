package kim.dk.growingbulletinboard.domain.reply;

import kim.dk.growingbulletinboard.domain.BaseEntity;
import kim.dk.growingbulletinboard.domain.board.Board;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String text;

    private String replyer;

    @ManyToOne
    private Board board;
}
