package kim.dk.growingbulletinboard.domain.member;

import kim.dk.growingbulletinboard.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity {
   @Id
   private String email;

   private String password;

   private String name;
}
