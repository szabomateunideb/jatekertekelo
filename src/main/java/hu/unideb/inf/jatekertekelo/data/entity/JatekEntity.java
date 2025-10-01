package hu.unideb.inf.jatekertekelo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Game")
public class JatekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String cim;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date megjelenesDatuma;
    @Column(name = "steam_id")
    private String steamId;
    @Column(name = "publisher")
    private String kiado;
    @Column(name = "developer")
    private String fejleszto;
    @Column(name = "description")
    private String leiras;
    @Column(name = "pg_rating")
    private String korhatarBesorolas;


}