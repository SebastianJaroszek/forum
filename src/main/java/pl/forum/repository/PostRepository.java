package pl.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.forum.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
