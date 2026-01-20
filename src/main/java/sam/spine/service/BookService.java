package sam.spine.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sam.spine.model.Book;
import sam.spine.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
