package repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByTitolo(String titolo);

    List<Post> findByHashtagNome(String hashtagNome);
}
