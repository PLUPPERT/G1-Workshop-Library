package se.lexicon.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(unique = true)
    private String username;
    @Getter(AccessLevel.NONE)
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details userDetails;
    @OneToMany(mappedBy = "loanId")
    private Set<BookLoan> loans = new HashSet<>();

    public AppUser(String username, String password, LocalDate regDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }
}
