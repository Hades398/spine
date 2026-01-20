package sam.spine.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private BigInteger total_pages;
    private Date published_date;
    private long publisher_id;
    private String description;
    private String isbn;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(BigInteger total_pages) {
        this.total_pages = total_pages;
    }

    public Date getPublishedDate() {
        return published_date;
    }

    public void setPublishedDate(Date published_date) {
        this.published_date = published_date;
    }

    public long getPublisherId() {
        return publisher_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
