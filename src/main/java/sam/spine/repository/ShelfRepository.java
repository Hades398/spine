package sam.spine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.spine.model.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
}
