package hu.unideb.inf.jatekertekelo.data.repository;

import hu.unideb.inf.jatekertekelo.data.entity.ErtekelesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErtekelesRepository
        extends JpaRepository<ErtekelesEntity, Long> {
}
