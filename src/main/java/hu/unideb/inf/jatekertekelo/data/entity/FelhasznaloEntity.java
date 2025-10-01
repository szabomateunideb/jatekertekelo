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
@Table(name = "USERS")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",  nullable = false)
    private String nev;
    @Column(name = "date_of_birth",  nullable = false)
    @Temporal(TemporalType.DATE)
    private Date szuletesiDatum;
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date regisztracioDatum;
    @Column(name = "username", length = 100, nullable = false)
    private String felhasznalonev;
    @Column(name = "pass_hash", length = 30, nullable = false)
    private String hash;
}
