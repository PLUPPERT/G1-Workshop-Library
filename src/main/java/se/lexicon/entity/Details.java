package se.lexicon.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
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


}
