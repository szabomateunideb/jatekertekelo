package hu.unideb.inf.jatekertekelo.data.repository;

import hu.unideb.inf.jatekertekelo.data.entity.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosultsagRepository
        extends JpaRepository<JogosultsagEntity, Long> {

    JogosultsagEntity findByNev(String nev);
}
