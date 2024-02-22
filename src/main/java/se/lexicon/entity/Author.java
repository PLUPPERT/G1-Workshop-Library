package se.lexicon.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(
            name = "books_by_author",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> writtenBooks = new HashSet<>();

    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public void addBook(Book book) {
        writtenBooks.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        writtenBooks.remove(book);
        book.setAuthor(null);
    }
}
