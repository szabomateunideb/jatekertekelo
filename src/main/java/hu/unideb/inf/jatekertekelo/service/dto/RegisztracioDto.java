package hu.unideb.inf.jatekertekelo.service.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
public class RegisztracioDto {

    @NotBlank(message = "Nem lehet üres")
    @Size(min = 10, max = 200, message = "10 és 200 között legyen a név")
    private String nev;
    @NotNull(message = "születési dátum kötelező")
    @Past
    private LocalDate szuletesiDatum;
    private LocalDate regisztracioDatum;
    private String felhasznalonev;
    private String jelszo;
}
