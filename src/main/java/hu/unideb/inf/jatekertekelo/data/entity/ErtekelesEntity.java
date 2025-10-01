package hu.unideb.inf.jatekertekelo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_rating")
public class ErtekelesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "rating")
    private Integer ertekeles;
    @Column(name = "description")
    private String leiras;
    @Column(name = "date_of_rating")
    @Temporal(TemporalType.DATE)
    private Date ertekelesDatuma;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private FelhasznaloEntity felhasznalo;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private JatekEntity jatek;
}
