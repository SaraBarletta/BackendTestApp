package repository;

import model.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

	List<Hashtag> findByNome(String nome);
}
