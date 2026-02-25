package sam.spine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sam.spine.model.Book;
import sam.spine.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000") // Allow React to talk to Boot
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam("query") String query) {
        return bookRepository.findByTitleContainingIgnoreCase(query);
    }
}