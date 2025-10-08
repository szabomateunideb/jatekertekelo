package hu.unideb.inf.jatekertekelo.service;

import hu.unideb.inf.jatekertekelo.service.dto.JatekCardDto;

import java.util.List;

public interface JatekService {
    JatekCardDto getById(Long id);
    JatekCardDto getByCim(String cim);
    List<JatekCardDto> getAll();
    void deleteById(Long id);
    JatekCardDto save(JatekCardDto jatekCardDto);
}
