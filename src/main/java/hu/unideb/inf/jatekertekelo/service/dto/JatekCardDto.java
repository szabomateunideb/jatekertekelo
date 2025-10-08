package hu.unideb.inf.jatekertekelo.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class JatekCardDto {
    private Long id;
    private String cim;
    private Date megjelenesDatuma;
    private String kiado;
    private String korhatarBesorolas;
}
