package se.lexicon.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Details {

    @Id
    @Column(name = "details_id")
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;

    @Setter
    @Column(unique = true)
    private String email;
    @Setter
    private String name;
    @Setter
    private LocalDate birthDate;

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
