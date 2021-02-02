package kim.dk.growingbulletinboard.domain.board;

import kim.dk.growingbulletinboard.domain.catagory.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Query("select b from Board b where b.category.cno=:cno")
    List<Board> findByCategory(@Param("cno")Long cno);
}
