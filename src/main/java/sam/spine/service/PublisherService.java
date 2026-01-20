package sam.spine.service;

import org.springframework.stereotype.Service;
import sam.spine.model.Publisher;
import sam.spine.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public void savePublishers(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Publisher getPublishersById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public void deletePublishersById(Long id) {
        publisherRepository.deleteById(id);
    }
}
