package sam.spine.repository;

import org.springframework.stereotype.Repository;
import sam.spine.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
