package se.lexicon.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
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
    private String password;
    private LocalDate regdate;
    @OneToOne
    @JoinColumn(name = "details_id")
    private Details details;
}
