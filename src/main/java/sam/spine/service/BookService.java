package sam.spine.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.spine.model.Book;
import sam.spine.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Boolean bookExists(Long id) {
        return this.bookRepository.findById(id).isPresent();
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> book1 = bookRepository.findById(id);
        if (book1.isEmpty()) {
            throw new IllegalArgumentException("Book with ID" + id + " not found");
        }
        Book book2 = book1.get();
        book2.setTitle(book.getTitle());
        book2.setAuthor(book.getAuthors());
        book2.setGenre(book.getGenre());
        return bookRepository.save(book2);

    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
