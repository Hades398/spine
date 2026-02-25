package sam.spine.repository;


import org.springframework.stereotype.Repository;
import sam.spine.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}
