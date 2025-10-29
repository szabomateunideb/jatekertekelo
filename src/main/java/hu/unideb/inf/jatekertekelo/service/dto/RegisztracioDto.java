package hu.unideb.inf.jatekertekelo.service.dto;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class RegisztracioDto {

    private String nev;
    private LocalDate szuletesiDatum;
    private LocalDate regisztracioDatum;
    private String felhasznalonev;
    private String jelszo;
}
