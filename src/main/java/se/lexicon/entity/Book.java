package se.lexicon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int bookId;
    @Column(nullable=false,length=13)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int maxLoanDays;
    @ManyToMany(mappedBy = "writtenBooks")
    private Set<Author> authors = new HashSet<>();

    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public Book(String isbn, String title, int maxLoanDays, Set<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.authors = authors;
    }

}
