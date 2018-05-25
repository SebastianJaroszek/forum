package pl.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.forum.entity.Thread;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {

}
