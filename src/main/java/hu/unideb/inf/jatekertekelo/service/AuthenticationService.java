package hu.unideb.inf.jatekertekelo.service;

import hu.unideb.inf.jatekertekelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.jatekertekelo.service.dto.RegisztracioDto;

public interface AuthenticationService {

    public void bejelentkezes(BejelentkezesDto dto);
    public void regisztracio(RegisztracioDto dto);
}
