package sam.spine.service;

import org.springframework.stereotype.Service;
import sam.spine.model.Author;
import sam.spine.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
