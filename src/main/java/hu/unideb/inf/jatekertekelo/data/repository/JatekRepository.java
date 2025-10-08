package hu.unideb.inf.jatekertekelo.data.repository;

import hu.unideb.inf.jatekertekelo.data.entity.JatekEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JatekRepository
        extends JpaRepository<JatekEntity, Long> {

    JatekEntity getByCim(String cim);
}
