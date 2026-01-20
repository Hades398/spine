package sam.spine.service;

import org.springframework.stereotype.Service;
import sam.spine.model.Genre;
import sam.spine.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public Genre getGenresById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void deleteGenresById(Long id) {
        genreRepository.deleteById(id);
    }
}
