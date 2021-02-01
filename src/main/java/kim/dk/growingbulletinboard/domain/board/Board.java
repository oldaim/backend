package kim.dk.growingbulletinboard.domain.board;

import kim.dk.growingbulletinboard.domain.BaseEntity;
import kim.dk.growingbulletinboard.domain.catagory.Category;
import kim.dk.growingbulletinboard.domain.member.Member;
import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne
    private Member member;
    /*EAGER 방식은 N+1문제를 야기할수있어서 책에서 나온것처럼 @Query 로 처리할지 다른방법이 있는지 찾아봐야겠다*/

    @ManyToOne
    private Category category;
}